package com.bo.job.core;

import com.bo.bean.HandlerInfoBean;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;
import com.bo.facade.bean.EventBean;
import com.bo.facade.bean.MessageBean;
import com.bo.facade.bean.NotificationBean;
import com.bo.managers.EventConfigManager;
import com.bo.process.CommonProcessManager;
import com.bo.process.ProcessResult;
import com.bo.process.ProcessStatus;
import com.bo.process.transfer.VTObject;
import com.bo.service.Constants;
import com.bo.thread.MiddlewareContextImpl;

public class PooledEventController implements Runnable {
	
	EventBean eventBean = null ; 
	
	public PooledEventController(EventBean eventBean){
		this.eventBean = eventBean;
	}

	@Override
	public void run() {

		
		MiddlewareContextImpl mwContext = null;
		DBContext databaseContext = null;

		try {
			
			databaseContext = new DBContext();
			databaseContext.setAutoCommit(false);
			mwContext = new MiddlewareContextImpl();
			mwContext.setDatabaseContext(databaseContext);
			mwContext.init();
			
			NotificationBean notificationBean = null;
			String eventCode = eventBean.getEventCode();
			int entityNumber = eventBean.getEntityNum();
			String channelCode = eventBean.getChannelCode();
			HandlerInfoBean handlerInfoBean = new HandlerInfoBean();
			
			updateEventTime("3", eventBean, databaseContext);
			databaseContext.commit();
			// Get the handler for the input system code, event code.		
			handlerInfoBean = EventConfigManager.getNtfnHandlerBean(entityNumber,channelCode, eventCode);
			String eventHandler = handlerInfoBean.getHandlerFullName();
					
			eventBean.setProcName(handlerInfoBean.getProcName());
			if (eventHandler == null) {
				System.out.println("Handler not available for the event code:" + eventCode);
				return;
			}

			CommonProcessManager commonProcessManager = new CommonProcessManager();
			VTObject inputVTO = new VTObject();
			inputVTO.set(Constants.BO_CLASS, eventHandler);
			inputVTO.setObject(Constants.BO_INPUT, eventBean);
			ProcessResult processResult = commonProcessManager.delegate(inputVTO);
			updateEventTime("2", eventBean, databaseContext);
			
			if (processResult.getProcessStatus().equals(ProcessStatus.FAILURE)) {
				// update error status
				System.out.println("Update error status for the message!!! " + processResult.getErrorCode());
				return;
			} else {
				notificationBean = processResult.getNotificationBean();
				if (notificationBean == null) {
					return;
				}
			}
			
		} catch (Exception e) {
			if(databaseContext!=null){
				try {
					databaseContext.rollback();;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
		}finally {
			if(databaseContext!=null){
				try {
					databaseContext.commit();
					databaseContext.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
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
			}else if(flag.equalsIgnoreCase("3")){
				queryBuff.append("UPDATE EVTNTFN E SET E.INVOKED_ON=SYSDATE WHERE E.ENTITY_CODE=? AND E.EVENT_ID=? AND E.CHANNEL_CODE=?");
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
