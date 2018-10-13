package com.bo.listeners;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

//import javax.ws.rs.core.Application;


public class RestfulApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public RestfulApplication() {

		singletons.add(new RestApiGateway());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}


