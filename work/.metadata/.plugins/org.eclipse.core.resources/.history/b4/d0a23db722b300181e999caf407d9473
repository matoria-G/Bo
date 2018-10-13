package com.bo.process.transfer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * DTObject - Data Transfer Object. Stores the data Encapsulate the data to get
 * transfered across the tiers
 */

public class VTObject implements Serializable {

	private static final long serialVersionUID = -402685876967698341L;
	protected HashMap<String, Object> internalStore = new HashMap<String, Object>();
	public static final String ERROR = "error";

	private boolean error = false;

	public boolean hasError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String get(String key) {
		return (String) internalStore.get(key);
	}

	public void set(String key, String value) {
		internalStore.put(key, value);
	}

	public VTDObject getDTDObject(String KeyName) {
		return (VTDObject) internalStore.get(KeyName);
	}

	public void setDTDObject(String KeyName, VTDObject Value) {
		internalStore.put(KeyName, Value);
	}

	public String getDTDObject(String KeyName, int RowIndex, int ColIndex) {
		VTDObject objDtlInfo = (VTDObject) internalStore.get(KeyName);
		return objDtlInfo.getValue(RowIndex, ColIndex);
	}

	public void setDTDObject(String KeyName, int RowIndex, int ColIndex, String Value) {
		VTDObject objDtlInfo = (VTDObject) internalStore.get(KeyName);
		if (objDtlInfo == null) {
			objDtlInfo = new VTDObject();
			internalStore.put(KeyName, objDtlInfo);
		}
		objDtlInfo.setValue(RowIndex, ColIndex, Value);
	}

	public String getDTDObject(String KeyName, int RowIndex, String ColName) {
		VTDObject objDtlInfo = (VTDObject) internalStore.get(KeyName);
		return objDtlInfo.getValue(RowIndex, ColName);
	}

	public void setDTDObject(String KeyName, int RowIndex, String ColName, String Value) {
		VTDObject objDtlInfo = (VTDObject) internalStore.get(KeyName);
		if (objDtlInfo == null) {
			objDtlInfo = new VTDObject();
			internalStore.put(KeyName, objDtlInfo);
		}
		objDtlInfo.setValue(RowIndex, ColName, Value);
	}

	public String getXMLDTDObject(String KeyName) {
		VTDObject objDtlInfo = (VTDObject) internalStore.get(KeyName);
		return objDtlInfo.getXML();
	}

	public void setXMLDTDObject(String KeyName, String XmlString) throws Exception {
		VTDObject objDtlInfo = (VTDObject) internalStore.get(KeyName);
		if (objDtlInfo == null) {
			objDtlInfo = new VTDObject();
			internalStore.put(KeyName, objDtlInfo);
		}
		objDtlInfo.setXML(XmlString);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMap(String key) {
		return (Map<String, Object>) internalStore.get(key);
	}

	public void setMap(String key, HashMap<String, Object> value) {
		internalStore.put(key, value);
	}

	public Map<String, Object> getInternalMap() {
		return internalStore;
	}

	public boolean containsKey(String key) {
		return internalStore.containsKey(key);
	}

	public boolean containsValue(String key) {
		return internalStore.containsValue(key);
	}

	public void reset() {
		internalStore.clear();
		error = false;
	}

	public void remove(String key) {
		if (internalStore.containsKey(key))
			internalStore.remove(key);
	}

	public void setObject(String key, Object value) {
		internalStore.put(key, value);
	}

	public Object getObject(String key) {
		return internalStore.get(key);
	}

	public Set<String> getKeys() {
		return internalStore.keySet();
	}

	public String toXML() {
		StringBuffer buffer = new StringBuffer();
		Set<String> keyNames = getKeys();
		for (String keyName : keyNames) {
			if (!keyName.equals(ERROR)) {
				try {
					buffer.append("<" + keyName + ">");
					buffer.append("<![CDATA[");
					if (getObject(keyName) instanceof String) {
						if (get(keyName) != null) {
							buffer.append(get(keyName).toString());
						} else {
							buffer.append("");
						}

					}
					buffer.append("]]>");
					buffer.append("</" + keyName + ">");
				} catch (Exception e) {
					buffer.setLength(0);
				} finally {
				}
			}
		}
		return buffer.toString();
	}
}
