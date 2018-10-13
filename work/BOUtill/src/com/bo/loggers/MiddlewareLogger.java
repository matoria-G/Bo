package com.bo.loggers;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MiddlewareLogger {

	static {
		Properties properties = new Properties();
		try {
			properties.load(MiddlewareLogger.class.getResourceAsStream("/com/bo/loggers/mwlog4j.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(properties);

	}

	private Logger logger;
	private static MiddlewareLogger instance;
	private String loggerName = null;

	private MiddlewareLogger(String loggerName) {
		this.loggerName = loggerName;
		logger = Logger.getLogger("customerlog");
	}

	public static MiddlewareLogger getInstance(String loggerName) {
		instance = new MiddlewareLogger(loggerName);
		return instance;
	}

	private Logger getLogger() {
		return logger;
	}

	public void logFatal(String message) {
		getLogger().fatal("[" + loggerName + "] " + message);
	}

	public void logError(String message) {
		getLogger().error("[" + loggerName + "] " + message);
	}

	public void logDebug(String message) {
		getLogger().debug("[" + loggerName + "] " + message);
	}

	public void logInfo(String message) {
		getLogger().info("[" + loggerName + "] " + message);
	}

}
