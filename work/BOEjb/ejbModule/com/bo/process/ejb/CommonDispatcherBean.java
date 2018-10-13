package com.bo.process.ejb;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.transaction.UserTransaction;

import com.bo.commons.constants.BoConstants;
import com.bo.commons.core.BoAPI;
import com.bo.commons.holder.DataHolder;
import com.bo.database.utils.DBContext;
import com.bo.facade.bean.EventBean;
import com.bo.facade.bean.MessageBean;
import com.bo.job.core.BaseTransactionHandler;
import com.bo.portal.pojo.RequestPayload;
import com.bo.process.ProcessErrorCodes;
import com.bo.process.ProcessResult;
import com.bo.process.ProcessStatus;
import com.bo.process.transfer.VTObject;
import com.bo.service.Constants;

/**
 * XDoclet-based session bean. The class must be declared public according to
 * the EJB specification.
 * 
 * To generate the EJB related files to this EJB: - Add Standard EJB module to
 * XDoclet project properties - Customize XDoclet configuration for your
 * appserver - Run XDoclet
 * 
 * Below are the xdoclet-related tags needed for this EJB.
 * 
 * @ejb.bean name="CommonDispatcher" display-name="Name for CommonDispatcher"
 *           description="Description for CommonDispatcher"
 *           jndi-name="ejb/middleware/CommonDispatcher" type="Stateless"
 *           view-type="remote"
 */
public class CommonDispatcherBean implements SessionBean {

	private static final long serialVersionUID = -6221076673012085438L;
	/** The session context */
	private SessionContext context;
	private UserTransaction userTransaction;
	private DBContext dbContext;

	public CommonDispatcherBean() {
		super();
	}

	/**
	 * Set the associated session context. The container calls this method after
	 * the instance creation.
	 * 
	 * The enterprise bean instance should store the reference to the context
	 * object in an instance variable.
	 * 
	 * This method is called with no transaction context.
	 * 
	 * @throws EJBException
	 *             Thrown if method fails due to system-level error.
	 * 
	 */
	public void setSessionContext(SessionContext newContext) throws EJBException {
		context = newContext;
	}

	public void ejbRemove() throws EJBException, RemoteException {

	}

	public void ejbActivate() throws EJBException, RemoteException {

	}

	public void ejbPassivate() throws EJBException, RemoteException {

	}

	/**
	 * An ejbCreate method as required by the EJB specification.
	 * 
	 * The container calls the instance?s <code>ejbCreate</code> method whose
	 * signature matches the signature of the <code>create</code> method invoked
	 * by the client. The input parameters sent from the client are passed to
	 * the <code>ejbCreate</code> method. Each session bean class must have at
	 * least one <code>ejbCreate</code> method. The number and signatures of a
	 * session bean?s <code>create</code> methods are specific to each session
	 * bean class.
	 * 
	 * @throws CreateException
	 *             Thrown if method fails due to system-level error.
	 * 
	 * 
	 * @ejb.create-method
	 * 
	 */
	public void ejbCreate() throws CreateException {

	}

	private void beginTransaction() throws Exception {
		try {
			userTransaction = context.getUserTransaction();
			userTransaction.begin();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * An example business method
	 * 
	 * @ejb.interface-method view-type = "remote"
	 * 
	 * @throws EJBException
	 *             Thrown if method fails due to system-level error.
	 * 
	 */
	public ProcessResult processRequest(VTObject inputDTO) {
		
		ProcessResult processResult = null;
		String boName = null;
		String serviceType = Constants.COLUMN_DISABLE;
		Class<? extends Object> boClass = null;
		Object boInstance = null;
		Object boInput = null;

		boName = inputDTO.get(Constants.BO_CLASS);
		serviceType = inputDTO.get(Constants.BO_SERVICE_TYPE);

		if (boName == null) {
			if (processResult == null) {
				processResult = new ProcessResult();
			}
			processResult.setErrorCode(ProcessErrorCodes.HANDLER_LOOKUP_ERROR);
			processResult.setProcessStatus(ProcessStatus.FAILURE);
			return processResult;
		}

		try {
			boClass = Class.forName(boName);
			boInstance = boClass.newInstance();
		} catch (Exception e) {
			if (processResult == null) {
				processResult = new ProcessResult();
			}
			String errorMessage = e.getLocalizedMessage();
			processResult.setErrorCode(ProcessErrorCodes.HANDLER_INIT_ERROR);
			processResult.setAdditionalInfo(errorMessage);
			processResult.setProcessStatus(ProcessStatus.FAILURE);
			return processResult;
		}

		boInput = inputDTO.getObject(Constants.BO_INPUT);
		if (boInput == null) {
			if (processResult == null) {
				processResult = new ProcessResult();
			}
			processResult.setErrorCode(ProcessErrorCodes.HANDLER_INPUT_NULL);
			processResult.setProcessStatus(ProcessStatus.FAILURE);
			return processResult;
		}

		if (!(boInput instanceof MessageBean) && !(boInput instanceof EventBean) && !(boInput instanceof VTObject) && !(boInput instanceof RequestPayload)) {
			if (processResult == null) {
				processResult = new ProcessResult();
			}
			processResult.setErrorCode(ProcessErrorCodes.HANDLER_INPUT_INVALID);
			processResult.setProcessStatus(ProcessStatus.FAILURE);
			return processResult;
		}

		try {

			beginTransaction();
			dbContext = new DBContext();
			BaseTransactionHandler businessObject = (BaseTransactionHandler) boInstance;
			businessObject.setEnvironmentObject(inputDTO);
			businessObject.setDBContext(dbContext);
			businessObject.setEntity(inputDTO.get(Constants.ENTITY));
			Object handlerReturnObject = null;
			if (boInput instanceof MessageBean)
				handlerReturnObject = businessObject.handleServiceMessage((MessageBean) boInput);
				//handlerReturnObject = businessObject.handleMessage((MessageBean) boInput);
			else if (boInput instanceof EventBean) {
				// pras 24012012 begin
				EventBean eventBean = (EventBean) boInput;
				if (eventBean.getSystemCode().equals("PORTAL")) {
					handlerReturnObject = businessObject.handlePortalEvent((EventBean) boInput);
				} else {
					//handlerReturnObject = businessObject.handleMessage((EventBean) boInput);
					handlerReturnObject = businessObject.handleEventMessage((EventBean) boInput);
				}
				// pras 24012012 end
			} else if (boInput instanceof VTObject) {
				handlerReturnObject = businessObject.handleMessage((VTObject) boInput);
			} else if (boInput instanceof RequestPayload) {
				
				RequestPayload requestPayload = (RequestPayload) boInput;
				if(requestPayload!=null&&requestPayload.getEntity()==null){
					requestPayload.setEntity(inputDTO.get(Constants.ENTITY));
				}
				// pras 24012012 begin
				handlerReturnObject = businessObject.handlePortalMessage(requestPayload);
				// pras 24012012 end
			}

			if (processResult == null)
				processResult = new ProcessResult();
			processResult.setEnvironmentObject(businessObject.getEnvironmentObject());
			if (businessObject.isCommit() || serviceType.equals(Constants.SERVICE_TYPE_ENQUIRY)) {
				processResult.setProcessStatus(ProcessStatus.SUCCESS);
				processResult.setAdditionalInfo(handlerReturnObject);
				commitTransaction();				
			} else {
				processResult.setAdditionalInfo(handlerReturnObject);
				throw new Exception("Set Rollback by Handler");
			}

		} catch (Exception e) {
			if (processResult == null) {
				processResult = new ProcessResult();
			}
			rollbackTransaction();
			String error = e.getLocalizedMessage();
			processResult.setErrorDescription(error);
			processResult.setErrorCode(ProcessErrorCodes.HANDLER_SET_ROLLBACK);
			processResult.setProcessStatus(ProcessStatus.FAILURE);
		} finally {
			if (dbContext != null)
				dbContext.close();
		}
		return processResult;
	}

	private void commitTransaction() throws Exception {
		userTransaction.commit();		
	}

	private void rollbackTransaction() {
		try {
			userTransaction.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DataHolder processRequest(DataHolder indataholder) {
		//Class<?> boClass = Class.forName(indataholder.get(BoConstants.API_CLASS));
		try{
		BoAPI boAPI = (BoAPI) Class.forName(indataholder.get(BoConstants.API_CLASS)).newInstance();
	  indataholder=boAPI.Invoke(indataholder);
		}catch(Exception e){
			System.out.println(e);
		}
		return indataholder;
	}
	
}
