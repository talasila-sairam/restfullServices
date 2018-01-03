package com.pathparameters.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/*")
public class PathParameterApplication extends Application {
 public PathParameterApplication() {
	 System.out.println("inside the Application class constructor");
}
}
