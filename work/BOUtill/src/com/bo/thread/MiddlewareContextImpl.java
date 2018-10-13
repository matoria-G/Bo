package com.bo.thread;

import com.bo.database.utils.DBContext;

public class MiddlewareContextImpl extends MiddlewareContext {

	private static final long serialVersionUID = -9208968922016854405L;

	private DBContext databaseContext;

	public void init() {
		MiddlewareContext.setInstance(this);
	}

	public void setDatabaseContext(DBContext databaseContext) {
		this.databaseContext = databaseContext;
	}

	public DBContext getDatabaseContext() {
		return databaseContext;
	}

}
