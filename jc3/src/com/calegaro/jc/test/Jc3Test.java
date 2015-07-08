package com.calegaro.jc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.calegaro.jc.init.cfg.AppConfig;
import com.calegaro.jc.service.SomeService;
import com.calegaro.jc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class Jc3Test {

	@Autowired
	private UserService userService;

	@Autowired
	private SomeService myService;
	
	@Test
	public void test() {
		Assert.notNull(userService);
		Assert.notNull(myService.getName());
	}

}