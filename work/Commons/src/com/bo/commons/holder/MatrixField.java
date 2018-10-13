package com.bo.commons.holder;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class MatrixField implements Field, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<LinkedHashMap<String,Field>> matrixData = new LinkedList<>();

	public LinkedList<LinkedHashMap<String, Field>> getMatrixData() {
		return matrixData;
	}

	public void setMatrixData(LinkedList<LinkedHashMap<String, Field>> matrixData) {
		this.matrixData = matrixData;
	}
	
	public void addRow(LinkedHashMap<String,Field> row){
		matrixData.add(row);
	}
	
	public int getRowCount(){
		return matrixData.size();
	}
	
	public Field getValue(int row, String colName){
		return matrixData.get(row).get(colName);
	}
	
	public void setValue(int row, String colName, Field value){
		matrixData.get(row).put(colName, value);
	}
}
