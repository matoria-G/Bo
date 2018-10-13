package com.bo.commons.converters;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bo.commons.holder.ComplexField;
import com.bo.commons.holder.DataHolder;
import com.bo.commons.holder.Field;
import com.bo.commons.holder.ListField;
import com.bo.commons.holder.MatrixField;
/*import com.bo.commons.loggers.ApplicationLogger;
import com.intellect.utils.core.Templatedatabean;
*/
public class jsonToDataholderConverter implements DataholderConverter{

	//ApplicationLogger applicationLogger=null;
	
	@Override
	public DataHolder convertToDataholder(String message/*, Templatedatabean templatedatabean*/) throws Exception {
		DataHolder dataholder=null;
		ComplexField complexField=null;
		JSONObject inputJson=null;
		LinkedHashMap<String,Object> orderMap=null;
		try
		{
			
			inputJson=new JSONObject(message);			
			dataholder=new DataHolder();
			/*applicationLogger=ApplicationLogger.getInstance("JsonToDataholderConverter");*/
			
			/*
			if(templatedatabean==null)
				orderMap=new LinkedHashMap<String,Object>();
			else
				orderMap=templatedatabean.getOrderMap();
			*/
			
			
			/*applicationLogger.logInfo("Json  "+inputJson);
			applicationLogger.logInfo("orderMap"+orderMap);*/
			
			complexField=parseJson("Root",inputJson,orderMap);
			
			LinkedHashMap<String,Field> dataMap = complexField.getComplexData();
			dataholder.setFieldData(dataMap);		
		}
		catch(Error e)
		{
			e.printStackTrace();
		}		
		return dataholder;
	}
	
	public ComplexField parseJson(String elementKey,JSONObject inputJson, LinkedHashMap<String,Object> orderMap)
	{
		ComplexField complexField =null;
		ComplexField jsonField=null;
		MatrixField grid = new MatrixField();
		Iterator<Object> jsonIterator=null;
		ListField listfield=new ListField();
		JSONObject jsonRow=null;
		Set<String> Keyset=null ;
		try
		{

			
			if(orderMap!=null && !orderMap.isEmpty())
				Keyset=orderMap.keySet();
			else
				Keyset=inputJson.keySet();
			
			complexField = new ComplexField();  

			for(String key : Keyset){
				
				
				 if(!inputJson.has(key))
					 continue;
				

				 
				  Object value=inputJson.get(key);
				  
				  if(value instanceof JSONObject){
					  jsonField = new ComplexField();  
					  jsonField=parseJson(key,(JSONObject) value,/*(LinkedHashMap<String, Object>) orderMap.get(key)*/null);
					  complexField.setValue((String)key, jsonField);
				  }
				  else if(value instanceof JSONArray){
					  
					  grid = new MatrixField();
						jsonIterator=((JSONArray) value).iterator();
						Object object=null;
						while(jsonIterator.hasNext())
						{
							
							object=jsonIterator.next();
							
							
							if(object instanceof JSONObject)							
							{	
								jsonRow=(JSONObject) object;						
								jsonField = new ComplexField();							
								jsonField=parseJson(key,jsonRow,(LinkedHashMap<String, Object>) orderMap.get(key));							
								grid.addRow(jsonField.getComplexData());
							}
							else 
							{
								listfield.addValue((String) object);
							}
							
							
						}
						if(object instanceof JSONObject) 
							complexField.setValue((String)key, grid);
							else
							complexField.setValue((String)key, listfield);
							
						
				  }
				  else if(value instanceof  String){
					  complexField.setValue((String)key,(String) value );
					  }				  
				  else if(value instanceof  Integer){
					  complexField.setValue((String)key,Integer.toString((Integer)value)  );
					  }
				 				  			  			  
			  }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return complexField;
	}
	

}
