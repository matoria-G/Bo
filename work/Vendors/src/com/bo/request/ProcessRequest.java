package com.bo.request;

import java.sql.ResultSet;
import java.util.ArrayList;


import java.util.LinkedHashMap;
import java.util.LinkedList;

import com.bo.commons.constants.BoConstants;
import com.bo.commons.core.BoAPI;
import com.bo.commons.core.Commons;
import com.bo.commons.holder.ComplexField;
import com.bo.commons.holder.DataHolder;
import com.bo.commons.holder.Field;
import com.bo.commons.holder.ListField;
import com.bo.commons.holder.MatrixField;
import com.bo.commons.holder.SimpleField;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;

public class ProcessRequest implements BoAPI {
	@Override
	public DataHolder Invoke(DataHolder indataholder) throws Exception{
		DBContext dbcontext=new DBContext();
		DBUtil dbutil=dbcontext.createUtilInstance();
		DBUtil dbutil2=dbcontext.createUtilInstance();
		String query;
		StringBuffer items=new StringBuffer();
		String iteminput;
		MatrixField vendors=new MatrixField();
		DataHolder outdataholder = new DataHolder();
		outdataholder.setValue(BoConstants.Status, BoConstants.Success);
		try{
		ComplexField userdata=(ComplexField) indataholder.getValue("User");
		ListField itemslist=(ListField) indataholder.getValue("items");
		double usrlat=Double.parseDouble(userdata.get("latitude").toString());
		double usrlon=Double.parseDouble(userdata.get("lognitude").toString());
		//itemslist.getValues()
		Commons common=new Commons();
		for(String itm:itemslist.getValues()){
			items.append("'"+itm+"',");
		}
		iteminput=items.substring(0,items.length()-1);
	      // query ="SELECT DISTINCT(P.VENDOR_ID), COUNT(P.ITEM_CODE) FROM VENDORITEMS P WHERE P.ITEM_CODE IN ("+iteminput+") GROUP BY P.VENDOR_ID";
	       query="SELECT DISTINCT (P.VENDOR_ID), COUNT(P.ITEM_CODE) FROM VENDORITEMS P,vendor K WHERE P.ITEM_CODE IN ("+iteminput+")"
           +"AND P.VENDOR_ID=K.VENDOR_ID AND K.CITY='CH' GROUP BY P.VENDOR_ID ";
	        dbutil.setSql(query);
	       // dbutil.setString(1, requestItem);
	        ResultSet rs=dbutil.executeQuery();
	        while(rs.next()){
	        	dbutil2.reset();
	        	String query_dist="SELECT K.LATITUDE,K.LOGNITUDE,K.AREACOVERD FROM VENDORSHIPPING K WHERE K.VENDOR_ID = ?";
	        	dbutil2.setSql(query_dist);
	        	dbutil2.setString(1, rs.getString("VENDOR_ID"));
	        	ResultSet dis=dbutil2.executeQuery();
	        		if(dis.next()){
	        			Double venlat=Double.parseDouble(dis.getString("LATITUDE"));
	        			Double venlon=Double.parseDouble(dis.getString("LOGNITUDE"));
	        			int dist=common.distance(usrlat, venlat, usrlon, venlon, 0, 0);
	        			if(dist<=Integer.parseInt(dis.getString("AREACOVERD"))){
	        				LinkedHashMap<String ,Field> data=new LinkedHashMap<String, Field>();
	        			  data.put(BoConstants.vendor, new SimpleField(rs.getString(1)));
	        			  data.put(BoConstants.noOfItems,new SimpleField(rs.getString(2)));
	        				
	        				vendors.addRow(data);
	        			}
	        			
	        		}
	        	//vendors.add(rs.getString(1));
	        }
	        outdataholder.setField("Vendors", vendors);	        
		}
		
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return outdataholder;
		
	}

	/*@Override
	public DataHolder Invoke(DataHolder inDataHolder) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/
	

}
