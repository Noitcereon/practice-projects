package noitcereon.mydemojavaapi.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
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
                });
        logger.trace("Finished Security Configuration");
    }
}
