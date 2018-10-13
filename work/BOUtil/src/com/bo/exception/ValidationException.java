package com.bo.exception;


public class ValidationException extends Exception{
	
	
	
	private static final long serialVersionUID = -7375446487375359106L;
	
	private String ErrorCode = null;
	
	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	
	public ValidationException(String errorCode) {
		super(errorCode);
		ErrorCode = errorCode;
	}

	private String ErrorMsg = "";
	
	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}

	public ValidationException(String errorCode,String errorMsg) {
		ErrorCode = errorCode;
		ErrorMsg = errorMsg;
	}

}
