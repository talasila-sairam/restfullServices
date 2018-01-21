package com.exceptionhandling.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
@ApplicationPath("/api")
public class ExceptionHandlingApplication extends Application {
  public ExceptionHandlingApplication() {
	  System.out.println("inside application class constructor");
}
}
