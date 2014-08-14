package com.rbnquintero.system.config;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.rbnquintero.system.util.Properties;

@Configuration
@ComponentScan({ "com.rbnquintero.system.service.impl" })
@PropertySource(value = { "classpath:application.properties" })
public class SpringConfig {
	@Autowired
	Properties customProperties;
	
	@Bean
	public Properties properties() {
		return new Properties();
	}
	
	@Bean
	public SimpleDateFormat dateFormat(){
		return new SimpleDateFormat("dd-MM-yyyy");
	}
}
