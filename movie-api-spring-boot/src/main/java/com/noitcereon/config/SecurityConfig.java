package com.noitcereon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        logger.info("Configuring security");
//        http
//                .cors().and()
//
//                .formLogin().disable()
//
//                // Sessions will not be used
//                .sessionManagement().disable()
//
//                // Cross request forgery not required when no sessions (I guess because it's not a UI you access?)
//                .csrf().disable()
//
//                .authorizeHttpRequests((authorization) -> authorization
//                        .anyRequest().permitAll()
//                )
//                .httpBasic().disable();
//
//        return http.build();
//    }
//}
