package com.nikorp.myspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.nikorp.myspring.utils.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		var users = User.withDefaultPasswordEncoder();
//		
//		auth.inMemoryAuthentication()
//			.withUser(users.username("nikhil").password("test123").roles("ADMIN", "MANAGER", "EMPLOYEE"))
//			.withUser(users.username("riddhiman").password("test123").roles("MANAGER", "EMPLOYEE"))
//			.withUser(users.username("ravina").password("test123").roles("EMPLOYEE"));
		
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/home").hasRole("EMPLOYEE")
			.antMatchers("/home/leaders/**").hasRole("MANAGER")
			.antMatchers("/home/admin/**").hasRole("ADMIN")
			.and()
			.formLogin().permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/home/accessdenied");
	}
	
}
