package com.bo.web.core;

import java.sql.ResultSet;

import com.bo.commons.constants.BoConstants;
import com.bo.commons.constants.ExceptionConstants;
import com.bo.commons.core.BoAPI;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;
import com.bo.process.CommonProcessManager;
import com.bo.process.ProcessResult;
import com.bo.commons.exception.ServiceException;
import com.bo.commons.holder.DataHolder;

public class BoApiController {
	
	
	public DataHolder Invoke(String requestType, DataHolder indataholder) throws Exception
	{
		DBUtil dbUtil=null;
		DBContext dbContext=null;
		BoAPI boAPI=null;
		Class<? extends Object> boClass = null;
		CommonProcessManager commonProcessManager = new CommonProcessManager();
		try
		{
			 indataholder.setValue(BoConstants.Status,BoConstants.Success);
			 dbContext = new DBContext();
			 dbUtil=dbContext.createUtilInstance();
				 dbUtil.reset();
				 dbUtil.setMode(DBUtil.PREPARED);
				 dbUtil.setSql("SELECT P.BOAPI_CLASS FROM BOAPI_BO P WHERE P.BOAPI_TYPE = ?");
				 dbUtil.setString(1, requestType);
				 ResultSet resultset2 =  dbUtil.executeQuery();
				 if(resultset2.next()){
					 boClass = Class.forName(resultset2.getString("BOAPI_CLASS"));
					 boAPI = (BoAPI) boClass.newInstance();
					 indataholder.setValue(BoConstants.API_CLASS,resultset2.getString("BOAPI_CLASS") );
					 indataholder = commonProcessManager.delegate(indataholder);
					 //indataholder=boAPI.Invoke(indataholder);
				 }else{
					 indataholder.setValue(BoConstants.Status,BoConstants.Failure);
					 indataholder.setValue(BoConstants.Err_code,ExceptionConstants.INVALID_REQ_TYPE);
					 indataholder.setValue(BoConstants.Err_msg,"Invalid Request type :"+requestType);
				 }
			 
			 
		}
		catch(Exception e)
		{
			indataholder.setValue(BoConstants.Status,BoConstants.Failure);
			indataholder.setValue(BoConstants.Err_code,ExceptionConstants.UNSPECIFIED_ERROR);
			indataholder.setValue(BoConstants.Err_msg,e.getLocalizedMessage());
		}
		finally
		{
			if(dbContext!=null)
				dbContext.close();
		}
		return indataholder;
	}
}
