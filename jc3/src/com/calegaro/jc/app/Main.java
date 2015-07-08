package com.calegaro.jc.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.calegaro.jc.init.cfg.AppConfig;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		App app = context.getBean(App.class);
		app.run();
	}

}