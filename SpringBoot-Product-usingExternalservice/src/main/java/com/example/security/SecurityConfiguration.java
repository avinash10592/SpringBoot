package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Set your configuration on auth object
//		auth.inMemoryAuthentication().withUser("avinash").password("1234").roles("user").and().withUser("avi")
//				.password("9876").roles("admin");
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/myapp/products/**").hasRole("admin")
		.antMatchers("/myapp/viewWithoutEdit/**").hasAnyRole("admin","user")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}

	
}
