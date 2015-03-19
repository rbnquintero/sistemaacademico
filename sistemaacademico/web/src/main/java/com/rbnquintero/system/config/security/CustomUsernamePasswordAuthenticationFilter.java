package com.rbnquintero.system.config.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rbnquintero.system.util.ConstantesWeb;

/**
 * Filtro de autenticación para Spring Security
 * 
 * @author JWM - Ruben Quintero
 *
 */
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private static final Logger _log = LoggerFactory.getLogger(CustomUsernamePasswordAuthenticationFilter.class);

	@Autowired
	private AuthenticationProvider authProvider;
	
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

		boolean isValidUsername = StringUtils.isNotBlank(username) && username.length() > 3;
		boolean isValidPassword = StringUtils.isNotBlank(password);

		if (!isValidUsername || !isValidPassword) {
			throw new InsufficientAuthenticationException(ConstantesWeb.SS_CREDENCIALES_INVALIDAS);
		}
		
		Authentication authentication = null;
		try {
			authentication = authProvider.authenticateByDB(username, password, request.getSession());
		} catch (AuthenticationException ae) {
			throw ae;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationServiceException(ConstantesWeb.SS_ERROR_INTERNO, e);
		}
		
		if (authentication.isAuthenticated()) {
			Cookie cookie = new Cookie(ConstantesWeb.CS_COOKIE_NAME, String.valueOf(System.currentTimeMillis()));
			cookie.setPath("/");
			response.addCookie(cookie);
		}

		return authentication;
	}
	
	@Override
	public String obtainUsername(HttpServletRequest request){
		return request.getParameter("username");
	}
	
	@Override
	public String obtainPassword(HttpServletRequest request){
		return request.getParameter("password");
	}

}