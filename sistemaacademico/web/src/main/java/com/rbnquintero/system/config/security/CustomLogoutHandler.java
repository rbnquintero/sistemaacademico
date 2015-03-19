package com.rbnquintero.system.config.security;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.rbnquintero.system.util.ConstantesWeb;
import com.rbnquintero.system.util.Properties;

public class CustomLogoutHandler implements LogoutHandler {

	@Autowired
	Properties properties;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		Cookie cookie = new Cookie(ConstantesWeb.CS_COOKIE_NAME, null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		try {
			response.sendRedirect("http://localhost:8180/web/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}