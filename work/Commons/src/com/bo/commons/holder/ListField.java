package com.bo.commons.holder;

import java.io.Serializable;
import java.util.LinkedList;

public class ListField implements Field, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<String> valueList = new LinkedList<>();
	
	public void addValue(String newValue) {				
		valueList.add(newValue);
	}
	
	public LinkedList<String> getValues() {
		return valueList;
	}
	
	public String getValue(int index) {
		return valueList.get(index);
	}

}