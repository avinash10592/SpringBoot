package com.example.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Setting up the JDBC configuration on the auth object
		auth.jdbcAuthentication().dataSource(datasource)
				.usersByUsernameQuery("select username, password, enabled " + "from users " + "where username = ?")
				.authoritiesByUsernameQuery("select username, role " + "from user_roles " + "where username= ?");

	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	// Set your configuration on auth object
//		auth.inMemoryAuthentication().withUser("avinash").password("1234").roles("user").and().withUser("avi")
//				.password("9876").roles("admin");
//		auth.userDetailsService(userDetailsService);
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/myapp/products/**").hasRole("ADMIN")
				.antMatchers("/myapp/viewWithoutEdit/**").hasAnyRole("USER", "ADMIN").antMatchers("/").permitAll().and()
				.formLogin();
	}

}
