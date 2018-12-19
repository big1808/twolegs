package com.tedu.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -8305427733971300997L;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
