package com.bo.process;

import javax.naming.InitialContext;

import com.bo.commons.holder.DataHolder;
import com.bo.process.ejb.interfaces.CommonDispatcher;
import com.bo.process.ejb.interfaces.CommonDispatcherHome;
import com.bo.process.transfer.VTObject;
import com.bo.service.ServiceNames;

public class CommonProcessManager {

	public ProcessResult delegate(VTObject inputDTO) {
		ProcessResult processResult = null;
		CommonDispatcherHome dispatcherHome = null;
		CommonDispatcher dispatcher = null;
		try {
			InitialContext initialContext = new InitialContext();
			Object o = null;
			o = initialContext.lookup(ServiceNames.COMMON_DISPATCHER);
			dispatcherHome = (CommonDispatcherHome) javax.rmi.PortableRemoteObject.narrow(o, CommonDispatcherHome.class);
			dispatcher = dispatcherHome.create();
			processResult = (ProcessResult) dispatcher.processRequest(inputDTO);
		} catch (Exception e) {
			e.printStackTrace();
			processResult = new ProcessResult();
			processResult.setErrorCode(ProcessErrorCodes.BEAN_LOOKUP_ERROR);
			String error = e.getLocalizedMessage();
			processResult.setAdditionalInfo(error);
			processResult.setProcessStatus(ProcessStatus.FAILURE);
		}
		return processResult;
	}
	
	public DataHolder delegate(DataHolder indataholder) {
		ProcessResult processResult = null;
		CommonDispatcherHome dispatcherHome = null;
		CommonDispatcher dispatcher = null;
		DataHolder outdataholder = null;
		try {
			InitialContext initialContext = new InitialContext();
			Object o = null;
			o = initialContext.lookup(ServiceNames.COMMON_DISPATCHER);
			dispatcherHome = (CommonDispatcherHome) javax.rmi.PortableRemoteObject.narrow(o, CommonDispatcherHome.class);
			dispatcher = dispatcherHome.create();
			outdataholder = dispatcher.processRequest(indataholder);
		} catch (Exception e) {
			e.printStackTrace();
			processResult = new ProcessResult();
			processResult.setErrorCode(ProcessErrorCodes.BEAN_LOOKUP_ERROR);
			String error = e.getLocalizedMessage();
			processResult.setAdditionalInfo(error);
			processResult.setProcessStatus(ProcessStatus.FAILURE);
		}
		return outdataholder;
	}

}
