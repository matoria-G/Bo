package com.bo.database.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Vector;

import com.bo.loggers.MiddlewareLogger;
import com.bo.service.ServiceLocator;

public final class DBContext {
	private MiddlewareLogger logger = null;

	private Connection conn = null;
	private Vector<DBUtil> utilList = new Vector<DBUtil>();
	private boolean autoCommit;
	private boolean explicitSetting = false;

	public DBContext() {
		logger = MiddlewareLogger.getInstance("INFTLOGGER");
		//logger.logDebug("#()");
	}

	public final Connection openConnection() throws SQLException {
		//logger.logDebug("openConnection()");
		if (conn != null) {
			return conn;
		}
		conn = ServiceLocator.getInstance().getDataSource().getConnection();
		if (explicitSetting) {
			if (autoCommit)
				conn.setAutoCommit(true);
			else
				conn.setAutoCommit(false);
		}
		return conn;
	}

	protected final void closeConnection() throws SQLException {
		//logger.logDebug("closeConnection()");
		if (conn != null) {
			conn.close();
		}
	}

	public final void close() {
		//logger.logDebug("close()");
		for (DBUtil util : utilList) {
			util.reset();
		}
		utilList.clear();
		try {
			closeConnection();
		} catch (Exception e) {
		}
	}

	public DBUtil createUtilInstance() {
		//logger.logDebug("createUtilInstance()");
		DBUtil util = new DBUtil(this) {
		};
		utilList.add(util);
		return util;
	}

	public void commit() throws Exception {
		//logger.logDebug("commit()");
		try {
			if (conn != null)
				conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError("commit() - " + e.getLocalizedMessage());
			throw e;
		}
	}

	public void rollback() throws Exception {
		//logger.logDebug("rollback()");
		try {
			if (conn != null)
				conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError("rollback() - " + e.getLocalizedMessage());
			throw e;
		}
	}

	/**
	 * @param autoCommit
	 *            the autoCommit to set
	 */
	public void setAutoCommit(boolean autoCommit) {
		this.autoCommit = autoCommit;
		explicitSetting = true;
	}

	/**
	 * @return the autoCommit
	 */
	public boolean isAutoCommit() {
		return autoCommit;
	}
	
	public Savepoint setSavepoint() throws Exception {
		//logger.logDebug("setSavepoint()");
		return conn.setSavepoint();
	}

	public Savepoint setSavepoint(String name) throws Exception {
		//logger.logDebug("setSavepoint(name)");
		return conn.setSavepoint(name);
	}

	public void releaseSavepoint(Savepoint savepoint) throws Exception {
		//logger.logDebug("releaseSavepoint(savepoint)");
		conn.releaseSavepoint(savepoint);
	}

	public void rollback(Savepoint savepoint) throws Exception {
		//logger.logDebug("rollback(savepoint)");
		try {
			if (conn != null)
				conn.rollback(savepoint);
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError("rollback() - " + e.getLocalizedMessage());
			throw e;
		}
	}
	
}
