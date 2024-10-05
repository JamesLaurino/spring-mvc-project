package com.fotovacreation.springMVC.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
        @Autowired
        private UserDetailsService userDetailsService;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http.formLogin().
                    loginPage("/login").
                    permitAll().
                    defaultSuccessUrl("/product", true);

            return http.authorizeHttpRequests(auth -> auth
                    .requestMatchers(HttpMethod.GET, "/user").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/sign-in").permitAll()
                    .requestMatchers("/images/**").permitAll()
                    .requestMatchers(HttpMethod.GET,"/card/**").permitAll()
                    .requestMatchers(HttpMethod.POST,"/card/**").permitAll()
                    .requestMatchers(HttpMethod.GET,"/furniture/**").permitAll()
                    .requestMatchers(HttpMethod.GET,"/category/**").permitAll()
                    .requestMatchers(HttpMethod.POST,"/category/**").permitAll()
                    .anyRequest().authenticated()). build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

}
