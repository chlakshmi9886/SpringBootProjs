package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity	
public class SecurityConfigClass extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
		//auth.inMemoryAuthentication().withUser("ramesh").password("{noop}hyd").roles("MANAGER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$jtZYrIb2PeA/dmEwu8Skp.q3CDw2M42MOCzjSFqNrjkzcBR1CZ2F6").roles("CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("ramesh").password("$2a$10$qjeiKAtPrZmKc9hcQC2rSOUdlGTQVuEc/7Riw2n3cYZyVxjh.oyZi").roles("MANAGER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
								.antMatchers("/offers").authenticated()
								.antMatchers("/show_balance").hasAnyRole("CUSTOMER","MANAGER")
								.antMatchers("/loanApprove").hasRole("MANAGER")
								.anyRequest().authenticated()
								//.and().httpBasic()
								.and().formLogin()
								//.and().logout()
								.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
								.and().exceptionHandling().accessDeniedPage("/denied");
	}
}
