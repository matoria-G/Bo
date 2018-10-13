package com.bo.commons.holder;

import java.io.Serializable;

public class SimpleField implements Field, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;
	
	public SimpleField(String value) {
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
	
	@Override
	public String toString(){
		return this.value;
	}

}
