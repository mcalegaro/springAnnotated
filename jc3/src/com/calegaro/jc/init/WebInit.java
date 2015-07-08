package com.calegaro.jc.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.calegaro.jc.init.cfg.AppConfig;
import com.calegaro.jc.init.cfg.SecurityConfigExt;
import com.calegaro.jc.init.cfg.WebMvcConfig;

public class WebInit extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class, SecurityConfigExt.class 
				};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
}