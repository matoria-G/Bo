package com.bo.job.core;

import javax.servlet.ServletContext;

public class ContextReference {

	private static ServletContext globalServletContext = null;

	public static void setContext(ServletContext context) {
		globalServletContext = context;
	}

	public static ServletContext getContext() {
		return globalServletContext;
	}
}