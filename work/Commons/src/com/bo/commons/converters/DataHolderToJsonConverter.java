package com.bo.commons.converters;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bo.commons.holder.ComplexField;
import com.bo.commons.holder.DataHolder;
import com.bo.commons.holder.Field;
import com.bo.commons.holder.ListField;
import com.bo.commons.holder.MatrixField;
import com.bo.commons.holder.SimpleField;

public class DataHolderToJsonConverter {
	

	//ApplicationLogger applicationLogger=null;
	
	
	
	public JSONObject Process(DataHolder indataHolder) throws Exception
	{
		
		JSONObject outputjson=null;
		try
		{
			
			outputjson=new JSONObject();
			//applicationLogger=ApplicationLogger.getInstance("DataHolderToJsonConverter");
    		LinkedHashMap<String,Field> dataMap = indataHolder.getFieldData();			
			LinkedHashMap<String, Field> childHashMap=null;
			outputjson=parseField(dataMap);
			
			
		}		
	/*	catch(ServiceException se)
		{
			se.printStackTrace();
			throw se;
		}*/
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return outputjson;
	}
	
	private JSONObject parseField(LinkedHashMap<String, Field> parentHashMap) throws Exception{
		

		String key="";
		JSONObject resJson=null;
		Field field=null;
		try
		{
			
		resJson=new JSONObject();		
		
		for(Entry<String, Field> entry: parentHashMap.entrySet() )		
		{
			
			field=entry.getValue();
			key=entry.getKey();
		
		if(field instanceof SimpleField){
			if(key!=null)
			resJson.put(key, ((SimpleField) field).getValue());
			
			
		
		}else if(field instanceof ListField){
			ListField list = (ListField) field;
			JSONArray stringarray=new JSONArray();
			for(String value : list.getValues()){
				stringarray.put(value);
				
			}
			resJson.put(key, stringarray);
			
		}else if(field instanceof MatrixField){
			MatrixField matrix = (MatrixField) field; 
			JSONObject matrixrecordjson=null;
			JSONArray jsonarray=new JSONArray();
			if ((matrix.getMatrixData() != null) && !(matrix.getMatrixData().isEmpty()))
			{
			
			for(LinkedHashMap<String, Field> matrixRecordMap : matrix.getMatrixData()){
				matrixrecordjson=new JSONObject();
				matrixrecordjson=parseField(matrixRecordMap);
				jsonarray.put(matrixrecordjson);		
			}
			
			resJson.put(key, jsonarray);
			}
			
			
			
			
		}else if(field instanceof ComplexField){
				
				ComplexField complexField = (ComplexField) field;
				LinkedHashMap<String, Field> complexFieldMap=complexField.getComplexData();
				JSONObject complexjson=new JSONObject();
				if (complexFieldMap != null)
				{
				complexjson=parseField(complexFieldMap);
				resJson.put(key, complexjson);
				}
				
		}		
		
		}
		
		}
		/*catch(ServiceException se)
		{
			se.printStackTrace();
			throw se;
		}*/
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception(e.getLocalizedMessage());
		}
		return resJson;
		
	}
	

	


}
