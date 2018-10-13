package com.bo.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.bo.loggers.MiddlewareLogger;

public class ServiceLocator {
	// singleton private instance
	private static ServiceLocator serviceLocator;
	private InitialContext initialContext = null;
	private Map<String, Object> mapCache;
	private MiddlewareLogger logger = null;
	/**
	 * static block to create a new instance of ServiceLocator at the time of
	 * class loading
	 */
	static {
		serviceLocator = new ServiceLocator();
	}

	/**
	 * Private Constructor to implement Singleton Design pattern
	 */
	private ServiceLocator() {
		super();

		try {
			initialContext = new InitialContext();
			mapCache = Collections.synchronizedMap(new HashMap<String, Object>());
		} catch (NamingException e) {
			e.printStackTrace();
		}
		logger = MiddlewareLogger.getInstance(this.getClass().getSimpleName());
		logger.logInfo("#()");

	}

	/**
	 * To get the instance of ServiceLocator
	 * 
	 * @return ServiceLocator
	 */
	static public ServiceLocator getInstance() {
		return serviceLocator;
	}

	/**
	 * getDataSource() - To get the DataSource
	 * 
	 * @return DataSource
	 * @throws SQLException
	 */
	public DataSource getDataSource() {
		DataSource dataSource = null;
		if (mapCache.containsKey(ServiceNames.DATA_SOURCE)) {
			dataSource = (DataSource) mapCache.get(ServiceNames.DATA_SOURCE);
			if (dataSource != null) {
				return dataSource;
			}
		}
		if (initialContext == null) {
			try {
				initialContext = new InitialContext();
			} catch (NamingException e) {
				logger.logError("Unable to obtain Initial Context :: " + e.getLocalizedMessage());
			}
		}
		if (initialContext != null) {
			try {
				dataSource = (DataSource) initialContext.lookup(ServiceNames.DATA_SOURCE);
				mapCache.put(ServiceNames.DATA_SOURCE, dataSource);
			} catch (NamingException e) {
				logger.logError("Unable to obtain DataSource :: " + e.getLocalizedMessage());
			}
		}
		return dataSource;
	}

	public Object getCommonDipatcher(String jndiHomeName) {
		Object commonDispatcherHome = null;
		if (mapCache.containsKey(ServiceNames.COMMON_DISPATCHER)) {
			commonDispatcherHome = mapCache.get(ServiceNames.COMMON_DISPATCHER);
			if (commonDispatcherHome != null) {
				return commonDispatcherHome;
			}
		}
		if (initialContext == null) {
			try {
				initialContext = new InitialContext();
			} catch (NamingException e) {
			}
		}
		if (initialContext != null) {
			try {
				commonDispatcherHome = initialContext.lookup(ServiceNames.COMMON_DISPATCHER);
				mapCache.put(ServiceNames.COMMON_DISPATCHER, commonDispatcherHome);
			} catch (NamingException e) {
			}
		}
		return commonDispatcherHome;
	}

	@SuppressWarnings("unchecked")
	public Class<? extends Object> getInterceptor(String interceptorName) {
		Class<? extends Object> interceptorClassReference = null;
		if (mapCache.containsKey(interceptorName)) {
			interceptorClassReference = (Class<? extends Object>) mapCache.get(interceptorName);
			if (interceptorClassReference != null) {
				return interceptorClassReference;
			}
		}
		try {
			interceptorClassReference = Class.forName(interceptorName);
			mapCache.put(interceptorName, interceptorClassReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return interceptorClassReference;
	}

}
