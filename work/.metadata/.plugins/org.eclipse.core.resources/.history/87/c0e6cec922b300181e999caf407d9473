package com.bo.utils;

import java.sql.ResultSet;
import java.sql.Types;

import com.bo.bean.ExceptionBean;
import com.bo.bean.StageStatusBean;
import com.bo.constants.ExceptionConstants;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;
import com.bo.file.constants.FileConstants;


public class ExceptionUtil {

	public String UpdateException(ExceptionBean exceptionBean) {
		
		DBContext dbContext = null;
		DBUtil dbUtil = null,dbUtil2=null;
		StringBuffer queryBuffer = null;
		String exceptionID=null;
		
		try{
			
			dbContext = new DBContext();
			dbUtil = dbContext.createUtilInstance();
			dbUtil.reset();
			
			dbUtil2 = dbContext.createUtilInstance();
			dbUtil2.reset();
			
			
			queryBuffer=new StringBuffer();
			exceptionID=getExceptionID(dbContext);
			
			queryBuffer.append("INSERT INTO EXCPLOG(ENTITY_NUM,EXCEPTION_ID,EXCEPTION_CODE,EXCEPTION_SOURCE,SOURCE_REFRENCE_NUM,SOURCE_TABLE,SOURCE_KEY,LOGGED_TIME,ACTION,REMARKS) values(?,?,?,?,?,?,?,sysdate,?,?)");			

			dbUtil.setMode(DBUtil.PREPARED);
			dbUtil.setSql(queryBuffer.toString());
			dbUtil.setString(1,exceptionBean.getEntity());
			dbUtil.setString(2,exceptionID);			
			dbUtil.setString(3,exceptionBean.getExceptionCode());
			dbUtil.setString(4,exceptionBean.getExceptionSrc());	
			dbUtil.setString(5,exceptionBean.getSrcRefNum());
			dbUtil.setString(6,exceptionBean.getSrcTable());
			dbUtil.setString(7,exceptionBean.getSrcKey());	
			dbUtil.setString(8,exceptionBean.getAction());			
			dbUtil.setString(9,exceptionBean.getRemarks());
			dbUtil.executeQuery();
			
			//Added By Saravanavel on 27th Jan2017
			
			dbUtil2.setMode(DBUtil.PREPARED);
			dbUtil2.setSql("INSERT INTO EXCPPE(ENTITY_NUM,EXCEPTION_ID) VALUES(?,?)");
			dbUtil2.setString(1,exceptionBean.getEntity());
			dbUtil2.setString(2,exceptionID);		
			dbUtil2.executeQuery();
			
			//dbContext.commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(dbUtil!=null)
				dbUtil.reset();
					if(dbUtil2!=null)
			dbUtil2.reset();
				if(dbContext!=null)
				dbContext.close();
			}
		
		return exceptionID;
	}

	public String updateStageException(ExceptionBean exceptionBean) {
		
		String exceptionID = null;
		StageStatusBean stageStatusBean = null;
		//IFSUtil ifsUtil = null;
		
		
		try {
			
			exceptionID=UpdateException(exceptionBean);
			stageStatusBean = new StageStatusBean();
			stageStatusBean.setEntity(exceptionBean.getEntity());
			stageStatusBean.setExcpCode(exceptionBean.getExceptionCode());
			stageStatusBean.setExcpId(exceptionID);
			stageStatusBean.setSrcKey(exceptionBean.getSrcKey());
			stageStatusBean.setSrcTable(exceptionBean.getSrcTable());
			stageStatusBean.setStageID(ExceptionConstants.EXCEPTION_STAGE);
			stageStatusBean.setStageStaus(ExceptionConstants.REJECTED);
		/*	ifsUtil = new IFSUtil();
			ifsUtil.updateStageStatus(stageStatusBean);*/
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return exceptionID;
	}
	
public String getExceptionID(DBContext dbContext) {
		
		DBUtil dbUtil = null;	
		String inv_number="";
		try {
			
			dbUtil = dbContext.createUtilInstance();
			
			dbUtil.reset();
			String query = "SELECT FN_GET_EXCEPTION_ID inv_number FROM DUAL";
			dbUtil.setMode(DBUtil.PREPARED);
			dbUtil.setSql(query);
			ResultSet rs = dbUtil.executeQuery();
			if (rs.next()) {
				inv_number=rs.getString("inv_number");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(dbUtil!=null)
				dbUtil.reset();
			}
		
		return inv_number;
	}

}
