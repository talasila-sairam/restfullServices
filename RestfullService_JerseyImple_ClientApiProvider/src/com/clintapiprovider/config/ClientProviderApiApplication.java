package com.clintapiprovider.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/*Incase of matric paramter we have to use resteasy 
 * implimentation so url is /api
 * Jersey wont support matrix paramters incase of this url pattern is /api/*  
 */
@ApplicationPath("/api/*")
public class ClientProviderApiApplication extends Application {
	public ClientProviderApiApplication() {
		System.out.println("inside Application class constructor");
	}

}
