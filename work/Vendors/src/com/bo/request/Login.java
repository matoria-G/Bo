package com.bo.request;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.ResultSet;
import java.util.LinkedHashMap;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.bo.commons.constants.BoConstants;
import com.bo.commons.core.BoAPI;
import com.bo.commons.core.Commons;
import com.bo.commons.holder.ComplexField;
import com.bo.commons.holder.DataHolder;
import com.bo.commons.holder.Field;
import com.bo.commons.holder.ListField;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;


public class Login implements BoAPI {

	@Override
	public DataHolder Invoke(DataHolder inDataHolder) throws Exception {
		DBContext dbcontext=new DBContext();
		DBUtil dbutil=dbcontext.createUtilInstance();
		String query;
		StringBuffer items=new StringBuffer();
		ListField vendors=new ListField();
		DataHolder outdataholder = new DataHolder();
		String dbPass=null;
		outdataholder.setValue(BoConstants.Status, BoConstants.Success);
		try{
		LinkedHashMap<String, Field> loginMap=inDataHolder.getFieldData();
	    ComplexField loginData =(ComplexField) loginMap.get(BoConstants.User);
		String userId=loginData.get(BoConstants.id).toString();
		String passWord=loginData.get(BoConstants.password).toString();
		String role=loginData.get(BoConstants.role).toString();
		query ="SELECT SALT_PIN FROM USERS U WHERE U.USER_ID =? AND U.ROLE_CODE=?";
        dbutil.setSql(query);
        dbutil.setString(1, userId);
        dbutil.setString(2, role);
       // dbutil.setString(1, requestItem);
        ResultSet rs=dbutil.executeQuery();
        while(rs.next()){
        	dbPass=rs.getString(1);
        }
        Commons common=new Commons();
        passWord = new String(common.hashPassword(passWord));
        System.out.println(passWord);
        if(!passWord.equals(dbPass))
        {
        	outdataholder.setValue(BoConstants.Status, BoConstants.Failure);
        }
		}catch (Exception e){
			e.printStackTrace();
		}
		return outdataholder;
	}
	

}
