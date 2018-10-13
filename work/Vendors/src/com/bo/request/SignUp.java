package com.bo.request;

import java.sql.ResultSet;
import java.util.LinkedHashMap;

import com.bo.commons.constants.BoConstants;
import com.bo.commons.core.BoAPI;
import com.bo.commons.core.Commons;
import com.bo.commons.holder.ComplexField;
import com.bo.commons.holder.DataHolder;
import com.bo.commons.holder.Field;
import com.bo.commons.holder.ListField;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;

public class SignUp implements BoAPI {

	@Override
	public DataHolder Invoke(DataHolder inDataHolder) throws Exception {
		// TODO Auto-generated method stub
		DBContext dbcontext=new DBContext();
		DBUtil dbutil=dbcontext.createUtilInstance();
		String query;
		DataHolder outdataholder = new DataHolder();
		String dbPass=null;
		outdataholder.setValue(BoConstants.Status, BoConstants.Success);
		try{
			LinkedHashMap<String, Field> loginMap=inDataHolder.getFieldData();
		    ComplexField loginData =(ComplexField) loginMap.get(BoConstants.User);
			String userId=loginData.get(BoConstants.id).toString();
			String name=loginData.get(BoConstants.name).toString();
			String passWord=loginData.get(BoConstants.password).toString();
			String email=loginData.getValue(BoConstants.email).toString();
			String phone=loginData.getValue(BoConstants.phone).toString();
			String dob=loginData.getValue(BoConstants.dob).toString();
			String role=loginData.get(BoConstants.role).toString();
			passWord=new String(Commons.hashPassword(passWord));
			query ="insert into users (USER_ID,USER_NAME,STATUS,ROLE_CODE,DOB,EMAIL_ID,MOBILE_NUMBER,SALT_PIN,SIGNUP_DATE)values (?,?,'A',?,TO_DATE(?,'DD-MM-YYYY'),?,?,?,SYSDATE)";
	        dbutil.setSql(query);
	        dbutil.setString(1, userId);
	        dbutil.setString(2, name);
	        dbutil.setString(3, role);
	        dbutil.setString(4, dob);
	        dbutil.setString(5, email);
	        dbutil.setString(6, phone);
	        dbutil.setString(7, passWord);
	        dbutil.executeUpdate();
	       /* while(rs.next()){
	        	dbPass=rs.getString(1);
	        }*/
			}catch (Exception e){
				outdataholder.setValue(BoConstants.Status, BoConstants.Failure);
				e.printStackTrace();
			}
			return outdataholder;
			}
	

}
