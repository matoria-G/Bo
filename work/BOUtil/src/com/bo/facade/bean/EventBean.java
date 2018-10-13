package com.bo.facade.bean;

import java.io.Serializable;

public class EventBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private long   eventID;
	private String eventCode;
	private String channelCode;
	private String systemCode;
	private int	   entityNum;
	private	String sourceKey;
	private String sourceTable;
	private String procName;
	
	/**
	 * @param eventID the eventID to set
	 */
	public void setEventID(long eventID) {
		this.eventID = eventID;
	}
	/**
	 * @return the eventID
	 */
	public long getEventID() {
		return eventID;
	}
	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}
	/**
	 * @param channelCode the channelCode to set
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	/**
	 * @return the channelCode
	 */
	public String getChannelCode() {
		return channelCode;
	}
	/**
	 * @param systemCode the systemCode to set
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	/**
	 * @return the systemCode
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * @param entityNum the entityNum to set
	 */
	public void setEntityNum(int entityNum) {
		this.entityNum = entityNum;
	}
	/**
	 * @return the entityNum
	 */
	public int getEntityNum() {
		return entityNum;
	}
	/**
	 * @param sourceKey the sourceKey to set
	 */
	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}
	/**
	 * @return the sourceKey
	 */
	public String getSourceKey() {
		return sourceKey;
	}
	/**
	 * @param sourceTable the sourceTable to set
	 */
	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}
	/**
	 * @return the sourceTable
	 */
	public String getSourceTable() {
		return sourceTable;
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

}
