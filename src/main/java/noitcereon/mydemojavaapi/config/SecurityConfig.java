package noitcereon.mydemojavaapi.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // This enables the use of @PreAuthorize
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.trace("Starting Security Configuration");
        http
                // Enable CORS -- this is configured on controllers with @CrossOrigin
                .cors().and()

                // Sessions will not be used
                .sessionManagement().disable()

                // Disable Cross Site Request Forgery tokens - They are not needed when there are no sessions.
                .csrf().disable()

                // Enable security for http requests
                .authorizeRequests(authorize -> {
                    authorize
                            // Specify paths where public access is allowed
                            // public Swagger paths
                            .antMatchers("/swagger-ui/**").permitAll()
                            .antMatchers("/swagger").permitAll()
                            .antMatchers("/v3/api-docs/**").permitAll()

                            // Other public paths
                            .antMatchers("/").permitAll()
                            .antMatchers("/favicon.ico").permitAll()

                            // All remaining paths require authentication
                            .anyRequest().authenticated();
                })
                // Configure OAuth2 Resource Server (JWT authentication) tentative note: gives @PreAuthorize more options
                .oauth2ResourceServer(oauth2 -> {
                    // Used to convert JWT to AbstractAuthenticationToken
                    JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();

                    // Used to convert JWT 'roles' claim into GrantedAuthorities
                    JwtGrantedAuthoritiesConverter roleConverter = new JwtGrantedAuthoritiesConverter();
                    roleConverter.setAuthorityPrefix("ROLE_");
                    roleConverter.setAuthoritiesClaimName("roles");

                    // Set the jwtConverters JwtGrantedAuthoritiesConverter object
                    jwtConverter.setJwtGrantedAuthoritiesConverter(roleConverter);

                    // Tell the oauth2 config to use the jwtConverter we just configured.
                    // This enables JWT authentication and access control from JWT claims
                    oauth2.jwt().jwtAuthenticationConverter(jwtConverter);
                });
        logger.trace("Finished Security Configuration");
    }
}
