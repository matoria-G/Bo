package com.bo.thread;

import java.io.Serializable;

import com.bo.database.utils.DBContext;

public abstract class MiddlewareContext implements Serializable {

	public abstract DBContext getDatabaseContext();

	private static final long serialVersionUID = -2828521186784559092L;
	private static final ThreadLocal<MiddlewareContext> context = new ThreadLocal<MiddlewareContext>();

	public static MiddlewareContext getInstance() {
		MiddlewareContext c = context.get();
		return c;
	}

	protected static void setInstance(MiddlewareContext c) {
		context.set(c);
	}
}
