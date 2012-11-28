package org.web.test.vo;

import java.io.Serializable;

public class User implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = -1590279583947468950L;
	private int id;
	private String name;
	
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
