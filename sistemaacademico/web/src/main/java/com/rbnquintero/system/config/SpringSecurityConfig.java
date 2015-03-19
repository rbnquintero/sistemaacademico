package com.rbnquintero.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.rbnquintero.system.config.security.CustomAuthenticationFailureHandler;
import com.rbnquintero.system.config.security.CustomAuthenticationSuccessHandler;
import com.rbnquintero.system.config.security.CustomLogoutHandler;
import com.rbnquintero.system.config.security.CustomUsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/login").access("permitAll()").antMatchers("/").access("isFullyAuthenticated()")
				.antMatchers("/**").access("isFullyAuthenticated()").and().formLogin().loginPage("/login").and().logout()
				.logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID").invalidateHttpSession(true).and()
				.addFilter(customAuthenticationFilter()).addFilter(logoutFilter());
	}

	@Bean
	public CustomUsernamePasswordAuthenticationFilter customAuthenticationFilter() {
		CustomUsernamePasswordAuthenticationFilter customFilter = new CustomUsernamePasswordAuthenticationFilter();
		customFilter.setAuthenticationFailureHandler(failureHandler());
		customFilter.setAuthenticationSuccessHandler(successHandler());
		customFilter.setAuthenticationManager(getAuthenticationManager());
		customFilter.setUsernameParameter("username");
		customFilter.setUsernameParameter("password");
		return customFilter;
	}
	
	public LogoutFilter logoutFilter(){
		LogoutHandler[] handlers = new LogoutHandler[2];
		handlers[0] = new SecurityContextLogoutHandler();
		handlers[1] = new CustomLogoutHandler();
		LogoutFilter logoutFilter = new LogoutFilter("http://localhost:8180/web/", handlers);
		return logoutFilter;
	}

	@Bean
	public CustomAuthenticationFailureHandler failureHandler() {
		CustomAuthenticationFailureHandler failureHandler = new CustomAuthenticationFailureHandler();
		failureHandler.setDefaultFailureUrl("/login?error");
		return failureHandler;
	}

	@Bean
	public CustomAuthenticationSuccessHandler successHandler() {
		CustomAuthenticationSuccessHandler successHandler = new CustomAuthenticationSuccessHandler();
		successHandler.setDefaultTargetUrl("/login");
		return successHandler;
	}

	@Bean
	public AuthenticationManager getAuthenticationManager() {
		AuthenticationManager auM = null;
		try {
			auM = authenticationManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auM;
	}

}
