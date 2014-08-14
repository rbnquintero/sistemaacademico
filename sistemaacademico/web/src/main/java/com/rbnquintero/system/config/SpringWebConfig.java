package com.rbnquintero.system.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySource(value = { "classpath:webapp.properties" })
public class SpringWebConfig {
	
	@Bean(name = "props")
	public PropertiesFactoryBean mapper() {
	    PropertiesFactoryBean bean = new PropertiesFactoryBean();
	    bean.setLocation(new ClassPathResource("webjsp.properties"));
	    return bean;
	}
}