package com.calegaro.jc.service.impl;

import org.springframework.stereotype.Service;

import com.calegaro.jc.service.SomeService;

@Service
public class SomeServiceImpl implements
		SomeService {

	@Override
	public String getName() {
		return SomeServiceImpl.class.getName();
	}

}