package com.rbnquintero.system.config.security;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener {
	
	@SuppressWarnings("unused")
	private ServletContext context = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		this.context = null;
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		this.context = event.getServletContext();
	}

}
