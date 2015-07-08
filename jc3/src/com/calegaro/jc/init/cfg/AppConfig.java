package com.calegaro.jc.init.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.calegaro.jc.app.App;

@Configuration
@ComponentScan(basePackages = {"com.calegaro.jc.service.impl"})
@Import(JPAConfig.class)
public class AppConfig {

	@Bean
	public App getApp() {
		return new App();
	}
	
}
