package com.test.redis.vo;

import java.io.Serializable;

public class Student implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1038446656709311572L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
