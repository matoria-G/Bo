package com.bo.job.core;

import java.sql.Types;

import com.bo.bean.ExceptionBean;
import com.bo.bean.PgmLogBean;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;
import com.bo.facade.bean.EventBean;
import com.bo.facade.bean.MessageBean;
import com.bo.facade.bean.NotificationBean;
import com.bo.file.constants.FileConstants;
import com.bo.portal.pojo.NotificationPayload;
import com.bo.portal.pojo.RequestPayload;
import com.bo.portal.pojo.ResponsePayload;
import com.bo.process.transfer.VTObject;
import com.bo.utils.EventsUtil;
import com.bo.utils.ExceptionUtil;


public abstract class BaseTransactionHandler {

	private DBContext dbContext = null;
	private VTObject environmentObject = null;
	private String sourceTable = null;
	private String sourceKey = "";
	private String programID = "";
	private String entity = "";

	public VTObject getEnvironmentObject() {
		return environmentObject;
	}

	public void setEnvironmentObject(VTObject environmentObject) {
		this.environmentObject = environmentObject;
	}

	public DBContext getDBContext() {
		return dbContext;
	}

	public void setDBContext(DBContext dbContext) {
		this.dbContext = dbContext;
	}

	private boolean commit = false;

	public boolean isCommit() {
		return commit;
	}

	public void setCommit(boolean commit) {
		this.commit = commit;
	}

	public abstract MessageBean handleServiceMessage(MessageBean inMessageBean) throws Exception;
	public abstract NotificationBean handleEventMessage(EventBean inEventBean) throws Exception;	

	public abstract NotificationBean handleMessage(EventBean eventBean) throws Exception;	

	public abstract VTObject handleMessage(VTObject inputVTO) throws Exception;	

	public abstract ResponsePayload handlePortalMessage(RequestPayload requestPayload) throws Exception;

	public abstract NotificationPayload handlePortalEvent(EventBean eventBean) throws Exception;

	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}

	public String getSourceTable() {
		return sourceTable;
	}

	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}

	public String getSourceKey() {
		return sourceKey;
	}

	public void setProgramID(String programID) {
		this.programID = programID;
	}

	public String getProgramID() {
		return programID;
	}

	public void generateProgramLog() throws Exception {

		try {

			/*if (!environmentObject.get(InterfaceConstants.GENERATE_LOG).equalsIgnoreCase("1"))
				return;*/
			
			if(getSourceTable()==null) {
				return;
			}

			PgmLogBean pgmLogBean = new PgmLogBean();
			pgmLogBean.setProgramID(getProgramID());
			pgmLogBean.setSourceTable(getSourceTable());
			pgmLogBean.setSourceKey(getSourceKey());
			/*pgmLogBean.setTaskNo(0);
			pgmLogBean.setTbaKey(null);
			pgmLogBean.setMode("A");*/

			EventsUtil eventsUtil = new EventsUtil(getDBContext());
			eventsUtil.generateProgramLog(pgmLogBean, getEntity(),getDBContext());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getEntity() {
		return entity;
	}
	
	protected void beginSavePoint()throws Exception {
		
		String callQuery = "";
		String result;
		try {
			
			callQuery = "{CALL PKG_IFS_SAVEPOINT.SP_BEGIN_SAVEPOINT(?,?)}";
			DBUtil dbUtil = getDBContext().createUtilInstance();
			dbUtil.setMode(DBUtil.CALLABLE);
			dbUtil.setSql(callQuery);
			dbUtil.setString(1,"MW_SAVEPOINT");
			dbUtil.registerOutParameter(2,Types.VARCHAR);
			dbUtil.execute();
			result = dbUtil.getString(2);
			
			if(!result.equalsIgnoreCase("0000")) {
				throw new Exception();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			
		}
			
	}
	
	protected void raiseException(ExceptionBean exceptionBean) {
		ExceptionUtil exceptionUtil=null;
		String exceptionID = null;
		try{
			exceptionUtil= new ExceptionUtil();			
			exceptionID = exceptionUtil.UpdateException(exceptionBean);	
			
			setProgramID(FileConstants.EXCP_PGMID);
			setSourceKey(exceptionID);
			setSourceTable(FileConstants.EXCP_SRCTABLE);
			generateProgramLog();
			
		}catch(Exception e){
			System.out.println("Exception e"+e);
		}
		
		
	}
	
	protected void raiseStageException(ExceptionBean exceptionBean) {
		ExceptionUtil exceptionUtil=null;
		String exceptionID = null;
		try{
			exceptionUtil= new ExceptionUtil();			
			exceptionID = exceptionUtil.updateStageException(exceptionBean);	
			
			setProgramID(FileConstants.EXCP_PGMID);
			setSourceKey(exceptionID);
			setSourceTable(FileConstants.EXCP_SRCTABLE);
			generateProgramLog();
			
		}catch(Exception e){
			System.out.println("Exception e"+e);
		}
		
		
	}
	
	protected void rollbackToSavePoint()throws Exception {
		
		String callQuery = "";
		String result;
		try {
			
			callQuery = "{CALL PKG_IFS_SAVEPOINT.SP_ROLLBACK_SAVEPOINT(?,?)}";
			DBUtil dbUtil = getDBContext().createUtilInstance();
			dbUtil.setMode(DBUtil.CALLABLE);
			dbUtil.setSql(callQuery);
			dbUtil.setString(1,"MW_SAVEPOINT");
			dbUtil.registerOutParameter(2,Types.VARCHAR);
			dbUtil.execute();
			result = dbUtil.getString(2);
			
			if(!result.equalsIgnoreCase("0000")) {
				throw new Exception();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			
		}
			
	}

}
