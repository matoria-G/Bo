package com.bo.commons.holder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class DataHolder implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LinkedHashMap<String,Field> fieldData = new LinkedHashMap<>();
	
	public LinkedHashMap<String, Field> getFieldData() {
		return fieldData;
	}

	public void setFieldData(LinkedHashMap<String, Field> fieldData) {
		this.fieldData = fieldData;
	}

	public void setValue(String key,String value) {		
		fieldData.put(key, new SimpleField(value));
	}
	
	public void setField(String key,Field field) {		
		fieldData.put(key, field);
	}
	
	public void setValue(String key,Field value) {		
		fieldData.put(key, value);
	}
	
	public Field getValue(String key) {
		return fieldData.get(key);
	}
	
	public Boolean containsKey(String key) {
		return fieldData.containsKey(key);
	}
	
	public String get(String key)throws Exception {
				
		SimpleField tempField = null;		
		if(fieldData.containsKey(key)){
			tempField = (SimpleField) fieldData.get(key);
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
		tempField = (ListField) fieldData.get(key);
		if(!(tempField instanceof ListField)) {
			throw new Exception();
		}
		
		return tempField.getValue(index);
						
	}
	
	public Iterator<String> getIterator(){
		Iterator<String> itr=fieldData.keySet().iterator();
		return itr;
		
	}
	
	
	public Field getField(String contextPath,String delimiter)
	{
		Field field=null;
		try {
			
			if(contextPath!=null){				
				String[] temp = contextPath.split("["+delimiter+"]");
				if(temp.length>1){					
					for(String key : temp)
					{
						if(key.equalsIgnoreCase("Root"))
							{								
								field=new ComplexField();
								((ComplexField) field).setComplexData(fieldData);								
							}
						else
							{
								field=((ComplexField) field).getValue(key);							
							}						
					}
				}else
				{
					field=new SimpleField(contextPath);
				}
			}
						
		} catch (Exception e) {
			System.out.println("Error in context data : "+contextPath);
			e.printStackTrace();
		}
		
		return field;		
	}
	
	public Field getField(String contextPath,String delimiter,HashMap<String,LinkedHashMap<String,Field>> instrdataMap)
	{
		Field field=null;
		try {
			
			if(contextPath!=null){				
				String[] temp = contextPath.split("["+delimiter+"]");
				if(temp.length>=1){
					StringBuffer sb=new StringBuffer();
					String currtext="";
					for(String key : temp)
					{
						sb.append(key).append(delimiter);
						
						if((currtext.length()>0))
							currtext=new StringBuffer(sb).deleteCharAt(sb.length()-1).toString();
						else
							currtext=key;
						
						if(currtext.equalsIgnoreCase("Root"))
								{
								if(instrdataMap.get(currtext)==null)
								{
									instrdataMap.put(currtext, fieldData);
								}
								
								field=new ComplexField();
								((ComplexField) field).setComplexData(fieldData);
								
								}
						else if(fieldData.containsKey(currtext))
						{
							field=fieldData.get(currtext);
						}
						else //if(instrdataMap.get(currtext)==null)
								{
									
									//currkey=currtext.substring(currtext.lastIndexOf(delimiter)+1,currtext.length());
									Field currField=null;
									
									if(field instanceof MatrixField)
									{
										currField=(instrdataMap.get(currtext.substring(0,currtext.lastIndexOf(delimiter)))).get(key);
									}
									else if(field instanceof ComplexField)
									{
										currField=((ComplexField) field).getValue(key);
									}
									
									
									if(currField instanceof ComplexField){
										instrdataMap.put(currtext, ((ComplexField) field).getComplexData());
										field=currField;
									}
									else {
										field=currField;
									}
									
								}						
						/*else
						{
							//currkey=currtext.substring(currtext.lastIndexOf(delimiter)+1,currtext.length());
							field=((ComplexField) field).getValue(key);							
						}*/
						
													
					}
				}				
			}
			
			
		} catch (Exception e) {
			System.out.println("Error in context data : "+contextPath);
			e.printStackTrace();
			return null;
		}
		
		return field;		
	}
	
	public String getData(String contextPath,String delimiter)
	{
		Field field=null;
		String data="";
		try {
			
			if(contextPath!=null){				
				String[] temp = contextPath.split("["+delimiter+"]");
				if(temp.length>=1){
					for(String key : temp)
					{
						if(key.equalsIgnoreCase("Root"))
							{								
								field=new ComplexField();
								((ComplexField) field).setComplexData(fieldData);								
							}
						else if(fieldData.containsKey(key))
						{
							if(fieldData.get(key)!=null)
							data=((SimpleField)fieldData.get(key)).getValue();
						}
						else
							{
								if(field instanceof ComplexField)
									field=((ComplexField) field).getValue(key);
								else if(field instanceof SimpleField)
									data=((SimpleField) field).getValue();
															
							}						
					}
					
					
				}				
			}
			
			
			
						
		} catch (Exception e) {
			System.out.println("Error in context data : "+contextPath);
			e.printStackTrace();
		}
		
		return data;		
	}
	
public String getData(String contextPath,String delimiter,HashMap<String,LinkedHashMap<String,Field>> instrdataMap){
		
		String returnData="";		
		Field field=null;
		//String currkey="";
		try {
			
			if(contextPath!=null){				
				String[] temp = contextPath.split("["+delimiter+"]");
				if(temp.length>=1){
					StringBuffer sb=new StringBuffer();
					String currtext="";
					for(String key : temp)
					{
						sb.append(key).append(delimiter);
						
						if((currtext.length()>0))
							currtext=new StringBuffer(sb).deleteCharAt(sb.length()-1).toString();
						else
							currtext=key;
						
						if(currtext.equalsIgnoreCase("Root"))
								{
								if(instrdataMap.get(currtext)==null)
								{
									instrdataMap.put(currtext, fieldData);
								}
								
								field=new ComplexField();
								((ComplexField) field).setComplexData(fieldData);
								
								}
						else if(fieldData.containsKey(currtext))
						{
							if(fieldData.get(key)!=null)
								returnData=((SimpleField)fieldData.get(key)).getValue();
						}
						else //if(instrdataMap.get(currtext)==null)
								{
									Field currField=null;
									//currkey=currtext.substring(currtext.lastIndexOf(delimiter)+1,currtext.length());
									
									if(field instanceof MatrixField)
									{
										currField=(instrdataMap.get(currtext.substring(0,currtext.lastIndexOf(delimiter)))).get(key);
									}
									else if(field instanceof ComplexField)
									{
										currField=((ComplexField) field).getValue(key);
									}
									
									
									
																		
									if(currField instanceof ComplexField){
										instrdataMap.put(currtext, ((ComplexField) currField).getComplexData());
										field=currField;
									}
									else if (currField instanceof MatrixField){
										field=currField;
									}
									else if (currField instanceof SimpleField){
										returnData=((SimpleField) currField).getValue();
									}
									
								}						
						/*else 
						{
							//currkey=currtext.substring(currtext.lastIndexOf(delimiter)+1,currtext.length());
							
							
							
							field=((ComplexField) field).getValue(key);
						}*/
						
													
					}
				}				
			}
			
			
		} catch (Exception e) {
			//e.printStackTrace();
			//throw e;
			returnData = null;
		}
		
		return returnData;		
	}
	
	
	public void setdata(String ContextPath,Field targetfield,String delimiter,HashMap<String,LinkedHashMap<String,Field>> instrdataMap)
	{
		
		String targetPath="",currPath="",key="",rootKey="";
		try
		{
			
			if(ContextPath.contains(delimiter))
			{
			rootKey=ContextPath.substring(0,ContextPath.indexOf(delimiter));
			targetPath=ContextPath.substring(ContextPath.indexOf(delimiter)+1);
			}
			else
			{
				rootKey=ContextPath;
				targetPath=ContextPath;
			}
			
			if(targetPath.contains(delimiter))
			{				
				key=targetPath.substring(0,targetPath.indexOf(delimiter));
			}	
			else
			{
				key=targetPath;
			}
			
			currPath=rootKey+delimiter+key;
			parseField(targetPath,currPath,fieldData,instrdataMap,targetfield,delimiter);	


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private LinkedHashMap<String,Field> parseField(String ContextPath,String rootPath,LinkedHashMap<String,Field> dataMap , HashMap<String,LinkedHashMap<String,Field>> instrdataMap, Field field,String delimiter)
	{
		
		LinkedHashMap<String,Field> returnHashMap=new LinkedHashMap<String,Field>();
		String childPath="",currPath="",currkey="",childKey="";
		Field currfield =null;
		try
		{
			
			if(ContextPath.contains(delimiter))
			{
			currkey=ContextPath.substring(0,ContextPath.indexOf(delimiter));
			childPath=ContextPath.substring(ContextPath.indexOf(delimiter)+1);
			
			System.out.println(childPath);
			
				if(childPath.contains(delimiter))
				{
					childKey=childPath.substring(0,childPath.indexOf(delimiter));
				}
				else					
				childKey=childPath;
				currPath=rootPath+delimiter+childKey;
			}
			else
			{
				currkey=ContextPath;
			}
			
			
			currfield = dataMap.get(currkey);
			
			if(currfield instanceof ComplexField)
			{
				
				if(currkey.equalsIgnoreCase(ContextPath))
					{						
						dataMap.put(currkey,field);
					}
				else
					{
						returnHashMap=parseField(childPath,currPath,((ComplexField) currfield).getComplexData(),instrdataMap,field,delimiter);
						((ComplexField) currfield).setComplexData(returnHashMap);
						dataMap.put(currkey,currfield);
					}
			}
			else if(currfield instanceof MatrixField)
			{
				if(currkey.equalsIgnoreCase(ContextPath))
				{						
					dataMap.put(currkey,field);
				}
				else
				{
					returnHashMap=parseField(childPath,currPath,instrdataMap.get(rootPath),instrdataMap,field,delimiter);
					instrdataMap.put(rootPath, returnHashMap);
				}	
			}
			else if(currfield instanceof SimpleField)
			{
				dataMap.put(currkey,field);
			}
			else if(currfield == null )
			{	
				if(currkey.equalsIgnoreCase(ContextPath))
				{
					dataMap.put(currkey,field);
				}
				else
				{
					currfield=new ComplexField();
					returnHashMap=parseField(childPath,currPath,((ComplexField) currfield).getComplexData(),instrdataMap,field,delimiter);
					((ComplexField) currfield).setComplexData(returnHashMap);
					dataMap.put(currkey,currfield);
				}
				
			}
			
			returnHashMap=dataMap;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return returnHashMap;
		
	}
	
		
	
	public static void main(String args[])
	{
		String contextPath ="Root.Payload.trandtls";
		String targetPath="",currPath="";
		targetPath=contextPath.substring(contextPath.indexOf(".")+1);
		DataHolder dataholder=new DataHolder();
		dataholder.setValue("KEY", "123");
		dataholder.setValue("PARAM", "ACB");

		System.out.println(dataholder.getField("KEY", ".", null) );
		System.out.println(dataholder.getData("KEY", ".", null) );

	}
	

}