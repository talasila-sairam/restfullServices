package com.jersey.automatictypecon.resources;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/*")
public class ProductApplication extends Application {
public ProductApplication() {
	System.out.println("constructor of application class");
}
}
