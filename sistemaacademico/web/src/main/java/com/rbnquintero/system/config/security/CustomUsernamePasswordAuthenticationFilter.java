package com.rbnquintero.system.config.security;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Filtro de autenticación para Spring Security
 * 
 * @author JWM - Ruben Quintero
 *
 */
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private static final Logger _log = LoggerFactory.getLogger(CustomUsernamePasswordAuthenticationFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * UsernamePasswordAuthenticationFilter
	 * #attemptAuthentication(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = obtainUsername(request);
		String password = obtainPassword(request);

		_log.debug("Autenticando usuario: " + username);

		Authentication authentication = new UsernamePasswordAuthenticationToken(username, password, new ArrayList<GrantedAuthority>());

		return authentication;
	}

}