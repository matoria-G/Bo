package com.bo.job.core;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

import com.bo.bean.EventsConfigBean;
import com.bo.constants.InterfaceConstants;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;
import com.bo.facade.bean.EventBean;
import com.bo.thread.MiddlewareContextImpl;

public class PooledEventsProcessor {

	public void processEvents(EventsConfigBean eventsConfigBean) {

		MiddlewareContextImpl mwContext = null;
		DBContext databaseContext = null;
		DBUtil dbUtil1 = null, dbUtil2 = null, dbUtil3 = null;
		ResultSet lrs1 = null;
		StringBuffer queryBuff = new StringBuffer("");
		String peListQuery = "", lockQuery = "", statusUpdateQuery = "", deleteQuery = "";
		HashMap eventMap = null;
		LinkedList peList = new LinkedList();
		int entityNum = 0, noOfRecs = 0;
		String channelCode = "", eventCode = "",systemCode="";
		long eventID = 0;
		boolean lockAcquired = false;
		String sourceKey = "", sourceTable = "";
		String bucket_num ="";//Sushmita 8/Feb/2016 add

		try {
			
			if(eventsConfigBean.getLogReqd()==1){
				System.out.println("Executing Pooled Events Job : "+ eventsConfigBean.getJobName());
			}

			lockQuery = "SELECT * FROM EVTNTFNPE E WHERE E.ENTITY_CODE=? AND E.EVENT_ID=? AND E.CHANNEL_CODE=? FOR UPDATE NOWAIT";
			statusUpdateQuery = "UPDATE EVTNTFN  E SET E.STATUS=? WHERE E.ENTITY_CODE=? AND E.EVENT_ID=? AND E.CHANNEL_CODE=?";
			deleteQuery = "DELETE FROM EVTNTFNPE E WHERE E.ENTITY_CODE=? AND E.EVENT_ID=? AND E.CHANNEL_CODE=?";

			databaseContext = new DBContext();
			databaseContext.setAutoCommit(false);
			dbUtil1 = databaseContext.createUtilInstance();
			mwContext = new MiddlewareContextImpl();
			mwContext.setDatabaseContext(databaseContext);
			mwContext.init();

			entityNum = eventsConfigBean.getEntityNum();
			noOfRecs = eventsConfigBean.getMaxRecordsToProcess();
			systemCode = eventsConfigBean.getSystemCode();
			channelCode = eventsConfigBean.getChannelCode();
			bucket_num = eventsConfigBean.getBucketNum();//Sushmita 8/Feb/2016 add

			queryBuff.append("SELECT E1.EVENT_ID,E3.EVENT_CODE,E3.SOURCE_TABLE,E3.SOURCE_KEY FROM EVTNTFNPE E1,EVTNTFN E2,EVTSLOG E3");
			queryBuff.append(" WHERE E1.ENTITY_CODE=? AND E1.CHANNEL_CODE=? AND E1.ENTITY_CODE=E2.ENTITY_CODE AND ");
			queryBuff.append(" E1.EVENT_ID=E2.EVENT_ID AND E1.ENTITY_CODE=E3.ENTITY_CODE AND E1.EVENT_ID=E3.EVENT_ID "); 
			queryBuff.append(" AND E2.BUCKET_NUM = E1.BUCKET_NUM AND E1.BUCKET_NUM=?"); //Sushmita 8/feb/2016 add
			queryBuff.append(" AND ROWNUM<=? ORDER BY E2.UPTD_ON");

			peListQuery = queryBuff.toString();

			dbUtil1.setMode(DBUtil.PREPARED);
			dbUtil1.setSql(peListQuery);
			dbUtil1.setInt(1, entityNum);
			dbUtil1.setString(2, channelCode);			
			dbUtil1.setInt(3, Integer.parseInt(bucket_num));			
			dbUtil1.setInt(4, noOfRecs);

			lrs1 = dbUtil1.executeQuery();

			while (lrs1.next()) {

				eventMap = new HashMap();
				eventMap.put("EVENT_ID", lrs1.getLong("EVENT_ID"));
				eventMap.put("EVENT_CODE", lrs1.getString("EVENT_CODE"));
				eventMap.put("SOURCE_KEY", lrs1.getString("SOURCE_KEY"));
				eventMap.put("SOURCE_TABLE", lrs1.getString("SOURCE_TABLE"));
				eventMap.put("ENTITY_NUM", entityNum);
				peList.add(eventMap);

			}

			lrs1.close();
			dbUtil1.reset();
			dbUtil1.setSql(lockQuery);

			dbUtil2 = databaseContext.createUtilInstance();
			dbUtil2.setSql(statusUpdateQuery);
			dbUtil3 = databaseContext.createUtilInstance();
			dbUtil3.setSql(deleteQuery);
			
			//Commented, since it is never read 18/05/2015 ThreadGroup threadGroup = new ThreadGroup("FacadeThreadGroup");

			for (int li = 0; li < peList.size(); li++) {

				eventMap = (HashMap) peList.get(li);
				eventID = (Long) eventMap.get("EVENT_ID");
				eventCode = (String) eventMap.get("EVENT_CODE");
				sourceKey = (String) eventMap.get("SOURCE_KEY");
				sourceTable = (String) eventMap.get("SOURCE_TABLE");
				dbUtil1.setInt(1, entityNum);
				dbUtil1.setLong(2, eventID);
				dbUtil1.setString(3, channelCode);

				// Get the lock for the event id
				try {
					lockAcquired = true;
					lrs1 = dbUtil1.executeQuery();
				} catch (Exception e) {
					lockAcquired = false;
				}

				// If lock acquired
				if (lockAcquired && lrs1.next()) {

					// Update status in eventntfn
					dbUtil2.setInt(1, InterfaceConstants.STATUS_CONSUMED);
					dbUtil2.setInt(2, entityNum);
					dbUtil2.setLong(3, eventID);
					dbUtil2.setString(4, channelCode);
					dbUtil2.executeUpdate();

					// Delete record from eventntfnpe
					dbUtil3.setInt(1, entityNum);
					dbUtil3.setLong(2, eventID);
					dbUtil3.setString(3, channelCode);
					dbUtil3.executeUpdate();

					EventBean eventBean = new EventBean();
					eventBean.setEntityNum(entityNum);
					eventBean.setEventID(eventID);
					eventBean.setEventCode(eventCode);
					eventBean.setChannelCode(channelCode);
					eventBean.setSystemCode(systemCode);
					eventBean.setSourceKey(sourceKey);
					eventBean.setSourceTable(sourceTable);

					// Allot EventFacade						
					updateEventTime("1", eventBean,databaseContext);
					
					try {
					PooledEventController formatController  = new PooledEventController(eventBean);
					ExecutorService threadPool=ThreadPoolManager.getInstance().getThreadPool(systemCode+"|"+channelCode,eventsConfigBean.getMaxParallelInstances());
					threadPool.execute(formatController);	
					System.out.println("Allocating Pooled Event thread for :"+eventID);
					//updateEventTime("2", eventBean, databaseContext);
					databaseContext.commit();
					} catch (RejectedExecutionException re) {
						if(eventsConfigBean.getLogReqd()==1){
							System.out.println("Reject Execution Called for Job Code : "+ eventsConfigBean.getJobName()+" Event Code :  "+eventCode+" Event Id : "+eventID);
						}
						databaseContext.rollback();
						break;
					}
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil1.reset();
			dbUtil2.reset();
			dbUtil3.reset();
			databaseContext.close();
		}

	}
	
	private void updateEventTime(String flag,EventBean eventBean,DBContext dbContext) throws Exception{
		
		DBUtil dbUtil = null;
		StringBuffer queryBuff = null;
		
		try {
			
			queryBuff = new StringBuffer();
			if(flag.equalsIgnoreCase("1")){
				queryBuff.append("UPDATE EVTNTFN E SET E.PICKED_ON=SYSDATE WHERE E.ENTITY_CODE=? AND E.EVENT_ID=? AND E.CHANNEL_CODE=?");
			}else if(flag.equalsIgnoreCase("2")){
				queryBuff.append("UPDATE EVTNTFN E SET E.EXECUTED_ON=SYSDATE WHERE E.ENTITY_CODE=? AND E.EVENT_ID=? AND E.CHANNEL_CODE=?");
			}
			
			dbUtil = dbContext.createUtilInstance();
			dbUtil.reset();
			dbUtil.setMode(DBUtil.PREPARED);
			dbUtil.setSql(queryBuff.toString());
			dbUtil.setInt(1,eventBean.getEntityNum());
			dbUtil.setLong(2, eventBean.getEventID());
			dbUtil.setString(3, eventBean.getChannelCode());
			dbUtil.executeUpdate();
			
			
		} catch (Exception e) {
			throw e ;
		}finally{
			if(dbUtil!=null)
				dbUtil.reset();
		}
		
	}

}
