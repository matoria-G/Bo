package com.bo.process;

import java.io.Serializable;

import com.bo.facade.bean.MessageBean;
import com.bo.facade.bean.NotificationBean;
import com.bo.portal.pojo.NotificationPayload;
import com.bo.portal.pojo.ResponsePayload;
import com.bo.process.transfer.VTObject;

public class ProcessResult implements Serializable {

	private static final long serialVersionUID = 1L;

	public ProcessStatus getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(ProcessStatus processStatus) {
		this.processStatus = processStatus;
	}

	public String getErrorCode() {
		return errorCode == null ? "" : errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Object getAdditionalInfo() {
		return additionalInfo == null ? "" : additionalInfo;
	}

	public void setAdditionalInfo(Object additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public MessageBean getMessageBean() {
		return (MessageBean) additionalInfo;
	}

	public NotificationBean getNotificationBean() {
		return (NotificationBean) additionalInfo;
	}
	
	public ResponsePayload getPortalResponsePayload() {
		return (ResponsePayload) additionalInfo;
	}
	
	public NotificationPayload getPortalNotificationPayload() {
		return (NotificationPayload) additionalInfo;
	}

	public VTObject getVTObject() {
		return (VTObject) additionalInfo;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public void setEnvironmentObject(VTObject environmentObject) {
		this.environmentObject = environmentObject;
	}

	public VTObject getEnvironmentObject() {
		return environmentObject;
	}

	private ProcessStatus processStatus;
	private String errorCode;
	private String errorDescription;
	private Object additionalInfo;
	private VTObject environmentObject;
	
	
}
