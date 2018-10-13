package com.bo.commons.holder;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Set;

public class ComplexField implements Field, Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private LinkedHashMap<String,Field> complexData = new LinkedHashMap<>();
	
	public LinkedHashMap<String,Field> getComplexData() {
		return complexData;
	}
	
	public void setComplexData(LinkedHashMap<String,Field> complexData) {
		this.complexData = complexData;
	}
	
	public void setValue(String key,String value) {		
		complexData.put(key, new SimpleField(value));
	}
	
	public void setValue(String key,Field value) {		
		complexData.put(key, value);
	}
	
	public Field getValue(String key) {
		return complexData.get(key);
	}
	
	public String get(String key)throws Exception {
		
		SimpleField tempField = null;		
		if(complexData.containsKey(key)){
			tempField = (SimpleField) complexData.get(key);
			if(tempField != null && !(tempField instanceof SimpleField)) {
				throw new Exception();
			}
			return ((SimpleField) tempField).getValue();
		}else{
			return null;
		}
						
	}
	
	public String get(int index,String key)throws Exception {
		
		ListField tempField = null;		
		tempField = (ListField) complexData.get(key);
		if(!(tempField instanceof ListField)) {
			throw new Exception();
		}
		
		return tempField.getValue(index);
						
	}
	
	public Set<String> getKeys() {
		Set<String> keys = null;
		keys = complexData.keySet();
		return keys;
	}
	
	public void reset() {
		complexData.clear();
	}

	
}
