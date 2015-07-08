package com.calegaro.jc.domain;

public enum Authorities {
	USER("USER");

	private String id;

	Authorities(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
