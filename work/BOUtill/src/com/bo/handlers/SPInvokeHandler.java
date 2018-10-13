package com.bo.handlers;

import com.bo.bean.ExceptionBean;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;
import com.bo.exception.ValidationException;
import com.bo.facade.bean.EventBean;
import com.bo.facade.bean.MessageBean;
import com.bo.facade.bean.NotificationBean;
import com.bo.job.core.BaseTransactionHandler;
import com.bo.portal.pojo.NotificationPayload;
import com.bo.portal.pojo.RequestPayload;
import com.bo.portal.pojo.ResponsePayload;
import com.bo.process.transfer.VTObject;

public class SPInvokeHandler extends BaseTransactionHandler
{
  public SPInvokeHandler() {}
  
  public NotificationBean handleEventMessage(EventBean eventBean)
    throws Exception
  {
    DBUtil dbUtil = null;
    ExceptionBean exceptionBean = new ExceptionBean();
    try {
      String callQuery = "{CALL " + eventBean.getProcName() + "(?,?,?,?,?,?,?,?,?,?,?)}";
      dbUtil = getDBContext().createUtilInstance();
      dbUtil.reset();
      dbUtil.setMode(false);
      dbUtil.setSql(callQuery);
      dbUtil.setInt(1, eventBean.getEntityNum());
      dbUtil.setLong(2, eventBean.getEventID());
      dbUtil.setString(3, eventBean.getEventCode());
      dbUtil.setString(4, eventBean.getSourceTable());
      dbUtil.setString(5, eventBean.getSourceKey());
      dbUtil.registerOutParameter(6, 12);
      dbUtil.registerOutParameter(7, 12);
      dbUtil.registerOutParameter(8, 12);
      dbUtil.registerOutParameter(9, 12);
      dbUtil.registerOutParameter(10, 12);
      dbUtil.registerOutParameter(11, 12);
      dbUtil.execute();
      
      String errorCode = dbUtil.getString(6);
      String excpCode = dbUtil.getString(7);
      if (errorCode.equalsIgnoreCase("000")) {
        if (!excpCode.equalsIgnoreCase("000")) {
          throw new ValidationException(excpCode, dbUtil.getString(8));
        }
        

        if (dbUtil.getString(9) != null) {
          setProgramID(dbUtil.getString(9));
          setSourceTable(dbUtil.getString(10));
          setSourceKey(dbUtil.getString(11));
        }
        
        setCommit(true);
      }
      else {
        throw new ValidationException(excpCode, dbUtil.getString(8));
      }
    } catch (ValidationException ve) {
      ve.printStackTrace();
      setCommit(true);
      exceptionBean.setEntity(Integer.toString(eventBean.getEntityNum()));
      exceptionBean.setExceptionCode(ve.getErrorCode());
      exceptionBean.setExceptionSrc("E");
      exceptionBean.setSrcTable(eventBean.getSourceTable());
      exceptionBean.setSrcKey(eventBean.getSourceKey());
      exceptionBean.setRemarks(ve.getErrorMsg());
      exceptionBean.setSrcRefNum(new Long(eventBean.getEventID()).toString());
      raiseStageException(exceptionBean);
    } catch (Exception e) {
      e.printStackTrace();
      rollbackToSavePoint();
      setCommit(true);
      exceptionBean.setEntity(Integer.toString(eventBean.getEntityNum()));
      exceptionBean.setExceptionCode("EXCP9999");
      exceptionBean.setExceptionSrc("E");
      exceptionBean.setSrcTable(eventBean.getSourceTable());
      exceptionBean.setSrcKey(eventBean.getSourceKey());
      exceptionBean.setRemarks(e.getLocalizedMessage());
      exceptionBean.setSrcRefNum(new Long(eventBean.getEventID()).toString());
      raiseStageException(exceptionBean);
    } finally {
      dbUtil.reset(); } dbUtil.reset();
    
    return null;
  }

@Override
public MessageBean handleServiceMessage(MessageBean inMessageBean)
		throws Exception {
	// TODO Auto-generated method stub
	return null;
}

/*@Override
public NotificationBean (EventBean inEventBean)
		throws Exception {
	// TODO Auto-generated method stub
	return null;
}*/

@Override
public VTObject handleMessage(VTObject inputVTO) throws Exception {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ResponsePayload handlePortalMessage(RequestPayload requestPayload)
		throws Exception {
	// TODO Auto-generated method stub
	return null;
}

@Override
public NotificationPayload handlePortalEvent(EventBean eventBean)
		throws Exception {
	// TODO Auto-generated method stub
	return null;
}

@Override
public NotificationBean handleMessage(EventBean eventBean) throws Exception {
	// TODO Auto-generated method stub
	return null;
}
}