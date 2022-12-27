package com.nt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


	 @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http.cors()
         .and()
         .authorizeRequests()
         .antMatchers("/api/employee**")
         //.anyRequest()
         .access("hasAuthority('SCOPE_api.read')")
         //.authenticated()
         .and()
         .oauth2ResourceServer()
         .jwt();
		 
		 return http.build();
	    }
}
