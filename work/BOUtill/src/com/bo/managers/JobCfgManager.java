package com.bo.managers;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.bo.bean.DispatcherConfigBean;
import com.bo.bean.EventsConfigBean;
import com.bo.bean.JobConfigBean;
import com.bo.bean.RecordProcessorConfigBean;
import com.bo.bean.WebServiceCfgBean;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;
import com.bo.thread.MiddlewareContext;

public class JobCfgManager {
	
	private static JobCfgManager jobCfgUtil=null;	
	private HashMap eventsConfigMap =  new HashMap();
	private HashMap dispatchConfigMap = new HashMap();
	private HashMap recProcConfigMap = new HashMap();
	private HashMap otherJobsConfigMap = new HashMap();
	private HashMap ftpConfigMap =  new HashMap();
	private HashMap ftpDispConfigMap =  new HashMap();
	private HashMap envConfigMap = new HashMap();
	private HashMap webServiceConfigMap =  new HashMap();
	
	private JobCfgManager(){
		
	}
	
	public static JobCfgManager getInstance()throws Exception {
		
		if(jobCfgUtil==null) {
			jobCfgUtil = new JobCfgManager();
		}
		
		return jobCfgUtil;	
		
	}
	
	//Record Process Bean 
	public RecordProcessorConfigBean getRecordProcessorJobConfig(int entityNum,String jobCode)throws Exception {
			
			if(recProcConfigMap.get(jobCode)==null) {
				loadRecordProcessorJobConfig(entityNum,jobCode);
			}
			
			return (RecordProcessorConfigBean) recProcConfigMap.get(jobCode);
			
	}
	
	//Events Job Config Bean 
	public EventsConfigBean getEventsJobConfig(int entityNum,String jobCode)throws Exception {
		
		if(eventsConfigMap.get(jobCode)==null) {						
				loadEventsJobConfig(entityNum,jobCode);						
		}
		
		return (EventsConfigBean) eventsConfigMap.get(jobCode);
		
	}
	
	//Dispatcher Job Config Bean 
	public DispatcherConfigBean getDispatcherJobConfig(int entityNum,String jobCode)throws Exception {
		
		if(dispatchConfigMap.get(jobCode)==null) {						
				loadDispatcherJobConfig(entityNum,jobCode);						
		}
		
		return (DispatcherConfigBean) dispatchConfigMap.get(jobCode);
		
	}
	
	//Dispatcher Job Config Bean 
	public JobConfigBean getOtherJobConfig(int entityNum,String jobCode)throws Exception {
		
		if(otherJobsConfigMap.get(jobCode)==null) {						
				loadOtherJobConfig(entityNum,jobCode);						
		}
		
		return (JobConfigBean) otherJobsConfigMap.get(jobCode);
		
	}
	
	//Other Dispatcher Job Config Bean - SUSHMITA ADD ON 28-FEB-2017
	public DispatcherConfigBean getOtherDispatcherJobConfig(int entityNum,String jobCode, DBContext dbContext)throws Exception {
		
		if(dispatchConfigMap.get(jobCode)==null) {						
				loadOtherDispatcherJobConfig(entityNum,jobCode,dbContext);						
		}
		
		return (DispatcherConfigBean) dispatchConfigMap.get(jobCode);
		
	}
	
	public synchronized void loadOtherJobConfig(int entityNum,String jobCode)throws Exception {
		
		 MiddlewareContext mwContext = null;
		 DBContext dbContext = null; 
		 DBUtil dbUtil = null;
		 ResultSet lrs=null;
		 JobConfigBean jobConfigBean = new JobConfigBean();
		 StringBuffer queryBuffer = null;
		 
		 try {
			 
			 if(otherJobsConfigMap.get(jobCode)!=null) {
				 return;
			 }
			 
			 mwContext =MiddlewareContext.getInstance();
			 dbContext=mwContext.getDatabaseContext();
			 dbUtil=dbContext.createUtilInstance();
			 dbUtil.reset();
			 
			 queryBuffer = new StringBuffer();
			 queryBuffer.append("SELECT JM.ENTITY_CODE,JM.JOB_CODE,JM.JOB_CATEGORY,JM.MAX_PARALLEL_INST,JM.SYSTEM_CODE,JM.JOB_NAME,JM.BUCKET_ASSIGNED,JO.CLASSNAME ");
			 queryBuffer.append(" FROM CMNJOBMAST JM,CMNJOBOTHCFG JO WHERE JM.ENTITY_CODE=JO.ENTITY_CODE AND JM.JOB_CODE=JO.JOB_CODE ");
			 queryBuffer.append("  AND  JM.ENTITY_CODE= ? AND JM.JOB_CODE = ?");			 
			 
			 dbUtil.setMode(DBUtil.PREPARED);
			 dbUtil.setSql(queryBuffer.toString());
			 dbUtil.setInt(1, entityNum);			 
			 dbUtil.setString(2, jobCode);			 
			 lrs=dbUtil.executeQuery();
			 
			 if(lrs.next()){
				 
				 jobConfigBean = new RecordProcessorConfigBean();
				 jobConfigBean.setEntityNum(lrs.getInt("ENTITY_CODE"));				 				 				 
				 jobConfigBean.setJobCategory(lrs.getString("JOB_CATEGORY"));
				 jobConfigBean.setJobCode(lrs.getString("JOB_CODE"));
				 jobConfigBean.setJobName(lrs.getString("JOB_NAME"));
				 jobConfigBean.setMaxParallelInstances(lrs.getInt("MAX_PARALLEL_INST"));				 
				 jobConfigBean.setSystemCode(lrs.getString("SYSTEM_CODE"));
				 jobConfigBean.setClassName(lrs.getString("CLASSNAME"));
				 jobConfigBean.setBucketNum(lrs.getString("BUCKET_ASSIGNED"));
				 
				 otherJobsConfigMap.put(jobCode,jobConfigBean);
				 
			 }
			 					 	
		} 
		 catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			dbUtil.reset();
		}
		
		
	}
	
	public synchronized void loadRecordProcessorJobConfig(int entityNum,String jobCode)throws Exception {
		
		 MiddlewareContext mwContext = null;
		 DBContext dbContext = null; 
		 DBUtil dbUtil = null;
		 ResultSet lrs=null;
		 RecordProcessorConfigBean recordProcessorConfigBean=null;
		 StringBuffer queryBuffer = null;
		 
		 try {
			 
			 if(recProcConfigMap.get(jobCode)!=null) {
				 return;
			 }
			 
			 mwContext =MiddlewareContext.getInstance();
			 dbContext=mwContext.getDatabaseContext();
			 dbUtil=dbContext.createUtilInstance();
			 dbUtil.reset();
			 
			 queryBuffer = new StringBuffer();
			 queryBuffer.append("SELECT JM.ENTITY_CODE,JM.JOB_CODE,JM.JOB_CATEGORY,JM.MAX_PARALLEL_INST,JM.SYSTEM_CODE,JM.JOB_NAME,JR.CONTROLLER");
			 queryBuffer.append(" ,JR.INVOKE_MODE,JR.MAX_RECORDS,JR.TABLE_PREFIX  FROM CMNJOBMAST JM,CMNJOBRECPROCCFG JR WHERE JM.ENTITY_CODE= ? ");
			 queryBuffer.append(" AND JR.ENTITY_CODE = JM.ENTITY_CODE AND JM.JOB_CODE = ? AND JR.JOB_CODE= ?");
			 
			 dbUtil.setMode(DBUtil.PREPARED);
			 dbUtil.setSql(queryBuffer.toString());
			 dbUtil.setInt(1, entityNum);			 
			 dbUtil.setString(2, jobCode);
			 dbUtil.setString(3, jobCode);
			 lrs=dbUtil.executeQuery();
			 
			 if(lrs.next()){
				 
				 recordProcessorConfigBean = new RecordProcessorConfigBean();
				 recordProcessorConfigBean.setEntityNum(lrs.getInt("ENTITY_CODE"));
				 recordProcessorConfigBean.setController(lrs.getString("CONTROLLER"));
				 recordProcessorConfigBean.setInvokeMode(lrs.getString("INVOKE_MODE"));
				 recordProcessorConfigBean.setJobCategory(lrs.getString("JOB_CATEGORY"));
				 recordProcessorConfigBean.setJobCode(lrs.getString("JOB_CODE"));
				 recordProcessorConfigBean.setJobName(lrs.getString("JOB_NAME"));
				 recordProcessorConfigBean.setMaxParallelInstances(lrs.getInt("MAX_PARALLEL_INST"));
				 recordProcessorConfigBean.setMaxRecordsToProcess(lrs.getInt("MAX_RECORDS"));
				 recordProcessorConfigBean.setSystemCode(lrs.getString("SYSTEM_CODE"));
				 recordProcessorConfigBean.setTablePrefix(lrs.getString("TABLE_PREFIX"));
				 
				 recProcConfigMap.put(jobCode,recordProcessorConfigBean);
				 
			 }
			 		
		} 
		 catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			dbUtil.reset();
		}
		
		
	}
					
	public synchronized void loadEventsJobConfig(int entityNum,String jobCode)throws Exception {
		
		 MiddlewareContext mwContext = null;
		 DBContext dbContext = null; 
		 DBUtil dbUtil = null;
		 ResultSet lrs=null;
		 EventsConfigBean eventsConfigBean = null;
		 StringBuffer queryBuffer = null;
		 
		 try {
			 
			 if(eventsConfigMap.get(jobCode)!=null)
				 return;
			 
			 mwContext =MiddlewareContext.getInstance();
			 dbContext=mwContext.getDatabaseContext();
			 dbUtil=dbContext.createUtilInstance();
			 
			 dbUtil.reset();
			 
			 queryBuffer = new StringBuffer();
			 queryBuffer.append("SELECT JM.ENTITY_CODE,JM.JOB_CODE,JM.JOB_CATEGORY,JM.MAX_PARALLEL_INST,JM.SYSTEM_CODE,JM.JOB_NAME,JR.CONTROLLER");			 
			 queryBuffer.append(" ,JR.INVOKE_MODE,JR.MAX_RECORDS,JM.BUCKET_ASSIGNED,JM.CHANNEL_CODE FROM CMNJOBMAST JM,CMNJOBEVENTPROCCFG JR WHERE JM.ENTITY_CODE= ?");
			 queryBuffer.append(" AND JR.ENTITY_CODE = JM.ENTITY_CODE AND JM.JOB_CODE = ? AND JR.JOB_CODE = ?");
			 
			 dbUtil.setMode(DBUtil.PREPARED);
			 dbUtil.setSql(queryBuffer.toString());
			 dbUtil.setInt(1, entityNum);			 
			 dbUtil.setString(2, jobCode);
			 dbUtil.setString(3, jobCode);
			 lrs=dbUtil.executeQuery();
			 
			 if(lrs.next()){
				 
				 eventsConfigBean = new EventsConfigBean();
				 eventsConfigBean.setEntityNum(lrs.getInt("ENTITY_CODE"));
				 eventsConfigBean.setController(lrs.getString("CONTROLLER"));
				 eventsConfigBean.setInvokeMode(lrs.getString("INVOKE_MODE"));
				 eventsConfigBean.setJobCategory(lrs.getString("JOB_CATEGORY"));
				 eventsConfigBean.setJobCode(lrs.getString("JOB_CODE"));
				 eventsConfigBean.setJobName(lrs.getString("JOB_NAME"));
				 eventsConfigBean.setMaxParallelInstances(lrs.getInt("MAX_PARALLEL_INST"));
				 eventsConfigBean.setMaxRecordsToProcess(lrs.getInt("MAX_RECORDS"));
				 eventsConfigBean.setSystemCode(lrs.getString("SYSTEM_CODE"));
				 eventsConfigBean.setBucketNum(lrs.getString("BUCKET_ASSIGNED"));//SUSHMITA ADD 8/FEB/2016
				 eventsConfigBean.setChannelCode(lrs.getString("CHANNEL_CODE"));
				 eventsConfigMap.put(jobCode,eventsConfigBean);
				 
			 }
			 		
		} 
		 catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
				
			if(dbUtil!=null)
			dbUtil.reset();			
			
			}				
	}
	
	public synchronized void loadDispatcherJobConfig(int entityNum,String jobCode)throws Exception {
		
		 MiddlewareContext mwContext = null;
		 DBContext dbContext = null; 
		 DBUtil dbUtil = null;
		 ResultSet lrs=null;
		 DispatcherConfigBean  dispatchConfigBean = null;
		 StringBuffer sqlBuff=null;
		 
		 try {
			 
			 if(dispatchConfigMap.get(jobCode)!=null)
				 return;
			
			 mwContext =MiddlewareContext.getInstance();
			 dbContext=mwContext.getDatabaseContext();
			 dbUtil=dbContext.createUtilInstance();
			 dbUtil.reset();
			 
			 sqlBuff=new StringBuffer();
			 sqlBuff.append("SELECT JM.JOB_CODE ,JM.JOB_CATEGORY,JM.MAX_PARALLEL_INST,JM.SYSTEM_CODE,JM.JOB_NAME,JR.ENTITY_CODE,JR.BULK_COMMIT_COUNT,JR.MAX_RECORDS,JR.QUEUE_CODE");
			 sqlBuff.append(" FROM CMNJOBMAST JM,CMNJOBRECDISPATCHCFG JR WHERE JM.ENTITY_CODE=? AND JR.ENTITY_CODE = JM.ENTITY_CODE AND JM.JOB_CODE=? AND JR.JOB_CODE = JM.JOB_CODE");
			 
			 dbUtil.setSql(sqlBuff.toString());
			 dbUtil.setInt(1,entityNum);
			 dbUtil.setString(2, jobCode);
			 lrs=dbUtil.executeQuery();
			 
			 if(lrs.next()){
				 
				 dispatchConfigBean = new DispatcherConfigBean();
				 dispatchConfigBean.setBulkCommitCount(lrs.getInt("BULK_COMMIT_COUNT"));
				 dispatchConfigBean.setJobCategory(lrs.getString("JOB_CATEGORY"));
				 dispatchConfigBean.setJobCode(lrs.getString("JOB_CODE"));
				 dispatchConfigBean.setJobName(lrs.getString("JOB_NAME"));
				 dispatchConfigBean.setMaxParallelInstances(lrs.getInt("MAX_PARALLEL_INST"));
				 dispatchConfigBean.setMaxRecords(lrs.getInt("MAX_RECORDS"));
				 dispatchConfigBean.setSystemCode(lrs.getString("SYSTEM_CODE"));				 
				 dispatchConfigBean.setEntityNum(entityNum);
				 dispatchConfigBean.setQueueCode(lrs.getString("QUEUE_CODE"));
			
				 dispatchConfigMap.put(jobCode,dispatchConfigBean);
				 
			 }
			
		} 
		 catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			dbUtil.reset();
		}
	}
	
//Added By Balaguru for FTP Start
	
		
	public Map<String,String> loadJobEnvCfgMap(int entityNum,String jobCode)throws Exception {
		
		Map<String,String> envMap = new HashMap<String,String>(); 
		MiddlewareContext mwContext = null;
		DBContext dbContext = null; 
		DBUtil dbUtil = null;
		
		try {
			
			mwContext =MiddlewareContext.getInstance();
			dbContext=mwContext.getDatabaseContext();
			dbUtil=dbContext.createUtilInstance();
			dbUtil.reset();
			
			String query = "SELECT JOBENVCFG_KEY,JOBENVCFG_VALUE FROM JOBENVCFG WHERE JOBENVCFG_ENTITY_NUM=? AND JOBENVCFG_JOB_CODE=?";
			dbUtil.setSql(query);			
			dbUtil.setInt(1,entityNum);
			dbUtil.setString(2,jobCode);
			ResultSet lrs = dbUtil.executeQuery();
			
			while(lrs.next()) {
				envMap.put(lrs.getString("JOBENVCFG_KEY"),lrs.getString("JOBENVCFG_VALUE"));
			}						
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbUtil.reset();
		}
		
		return envMap;
		
	}
	
public JobConfigBean getWebServiceJobConfig(int entityNum,String jobCode)throws Exception {
		
		if(webServiceConfigMap.get(jobCode)==null) {						
			loadWebServiceJobConfig(entityNum,jobCode);				
		}
		
		return (JobConfigBean) webServiceConfigMap.get(jobCode);
		
	}

public synchronized void loadWebServiceJobConfig(int entityNum,String jobCode)throws Exception {
	
	 MiddlewareContext mwContext = null;
	 DBContext dbContext = null; 
	 DBUtil dbUtil = null;
	 ResultSet lrs=null;
	 WebServiceCfgBean wsConfigBean = null;
	 StringBuffer queryBuffer = null;
	 
	 try {
		 
		 if(webServiceConfigMap.get(jobCode)!=null)
			 return;
		 
		 mwContext =MiddlewareContext.getInstance();
		 dbContext=mwContext.getDatabaseContext();
		 dbUtil=dbContext.createUtilInstance();
		 dbUtil.reset();
		 
		 queryBuffer = new StringBuffer();
		 queryBuffer.append("SELECT E.EXTSERVERS_SYSTEM_CODE,J.JOBWSCFG_ENTITY_NUM,J.JOBWSCFG_JOB_CODE, J.JOBWSCFG_SERVER_CODE, J.JOBWSCFG_WSCLIENT ");
		 queryBuffer.append("  FROM EXTSERVERS E, JOBWSCFG J  WHERE E.EXTSERVERS_ENTITY_NUM = J.JOBWSCFG_ENTITY_NUM  AND J.JOBWSCFG_ENTITY_NUM=? ");
		 queryBuffer.append(" AND E.EXTSERVERS_SERVER_CODE = J.JOBWSCFG_SERVER_CODE AND E.EXTSERVERS_ENABLED = 1 AND J.JOBWSCFG_JOB_CODE=?");
		 
		 dbUtil.setMode(DBUtil.PREPARED);
		 dbUtil.setSql(queryBuffer.toString());
		 dbUtil.setInt(1, entityNum);			 
		 dbUtil.setString(2, jobCode);			 
		 lrs=dbUtil.executeQuery();
		 
		 if(lrs.next()){
			 
			 wsConfigBean = new WebServiceCfgBean();
			 wsConfigBean.setEntity(lrs.getString("JOBWSCFG_ENTITY_NUM"));
			 wsConfigBean.setJobCode(lrs.getString("JOBWSCFG_JOB_CODE"));				 
			 wsConfigBean.setServerCode(lrs.getString("JOBWSCFG_SERVER_CODE"));
			 wsConfigBean.setServerClient(lrs.getString("JOBWSCFG_WSCLIENT"));
			 wsConfigBean.setSystemCode(lrs.getString("EXTSERVERS_SYSTEM_CODE"));
			 webServiceConfigMap.put(jobCode,wsConfigBean);
			 
		 }
		 
	lrs.close();
		 		
	} 
	 catch (Exception e) {
		e.printStackTrace();
		throw e;
	}
	finally {
		dbUtil.reset();
	}
	}
	
	//SUSHMITA ADD ON 28-FEB-2017
	public synchronized void loadOtherDispatcherJobConfig(int entityNum,String jobCode, DBContext dbContext)throws Exception {
		DBUtil dbUtil = null;
		ResultSet lrs=null;
		DispatcherConfigBean  dispatchConfigBean = null;
		StringBuffer sqlBuff=null;
		 
		try {
			 
			if(dispatchConfigMap.get(jobCode)!=null)
				return;
			 
			dbUtil=dbContext.createUtilInstance();
			dbUtil.reset();
			 
			sqlBuff=new StringBuffer();
			sqlBuff.append("SELECT JM.JOB_CODE ,JM.JOB_CATEGORY,JM.MAX_PARALLEL_INST,JM.SYSTEM_CODE,JM.JOB_NAME,JR.ENTITY_CODE,JR.BULK_COMMIT_COUNT,JR.MAX_RECORDS,JR.QUEUE_CODE");
			sqlBuff.append(" FROM CMNJOBMAST JM,CMNJOBRECDISPATCHCFG JR WHERE JM.ENTITY_CODE=? AND JR.ENTITY_CODE = JM.ENTITY_CODE AND JM.JOB_CODE=? AND JR.JOB_CODE = JM.JOB_CODE");
			 
			dbUtil.setSql(sqlBuff.toString());
			dbUtil.setInt(1,entityNum);
			dbUtil.setString(2, jobCode);
			lrs=dbUtil.executeQuery();
			
			if(lrs.next()){
				 
				dispatchConfigBean = new DispatcherConfigBean();
				dispatchConfigBean.setBulkCommitCount(lrs.getInt("BULK_COMMIT_COUNT"));
				dispatchConfigBean.setJobCategory(lrs.getString("JOB_CATEGORY"));
				dispatchConfigBean.setJobCode(lrs.getString("JOB_CODE"));
				dispatchConfigBean.setJobName(lrs.getString("JOB_NAME"));
				dispatchConfigBean.setMaxParallelInstances(lrs.getInt("MAX_PARALLEL_INST"));
				dispatchConfigBean.setMaxRecords(lrs.getInt("MAX_RECORDS"));
				dispatchConfigBean.setSystemCode(lrs.getString("SYSTEM_CODE"));				 
				dispatchConfigBean.setEntityNum(entityNum);
				dispatchConfigBean.setQueueCode(lrs.getString("QUEUE_CODE"));
			
				dispatchConfigMap.put(jobCode,dispatchConfigBean);
				 
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(dbUtil != null){
				dbUtil.reset();
			}
		}
	}



		
}