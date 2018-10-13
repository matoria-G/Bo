package com.bo.commons.converters;

import java.util.LinkedHashMap;

import com.bo.commons.holder.DataHolder;
//import com.bo.utils.core.Templatedatabean;

public interface DataholderConverter {
	
	public DataHolder convertToDataholder(String message/*, Templatedatabean templatedatabean*/) throws Exception;

}
