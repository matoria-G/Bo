package com.bo.bean;

public class HandlerInfoBean {
	
	private String handlerFullName;
	private boolean entryLogRequired;
	private boolean exitLogRequired;	
	private String procName;
	private String generateLog;
	private String pgmID;
	
	/**
	 * @param handlerFullName the handlerFullName to set
	 */
	public void setHandlerFullName(String handlerFullName) {
		this.handlerFullName = handlerFullName;
	}
	/**
	 * @return the handlerFullName
	 */
	public String getHandlerFullName() {
		return handlerFullName;
	}
	/**
	 * @param entryLogRequired the entryLogRequired to set
	 */
	public void setEntryLogRequired(boolean entryLogRequired) {
		this.entryLogRequired = entryLogRequired;
	}
	/**
	 * @return the entryLogRequired
	 */
	public boolean isEntryLogRequired() {
		return entryLogRequired;
	}
	/**
	 * @param exitLogRequired the exitLogRequired to set
	 */
	public void setExitLogRequired(boolean exitLogRequired) {
		this.exitLogRequired = exitLogRequired;
	}
	/**
	 * @return the exitLogRequired
	 */
	public boolean isExitLogRequired() {
		return exitLogRequired;
	}
	/**
	 * @param procName the procName to set
	 */
	public void setProcName(String procName) {
		this.procName = procName;
	}
	/**
	 * @return the procName
	 */
	public String getProcName() {
		return procName;
	}
	public void setGenerateLog(String generateLog) {
		this.generateLog = generateLog;
	}
	public String getGenerateLog() {
		return generateLog;
	}
	public void setPgmID(String pgmID) {
		this.pgmID = pgmID;
	}
	public String getPgmID() {
		return pgmID;
	}
	
}
