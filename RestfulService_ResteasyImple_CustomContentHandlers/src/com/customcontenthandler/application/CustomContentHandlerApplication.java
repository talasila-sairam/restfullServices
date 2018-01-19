package com.customcontenthandler.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class CustomContentHandlerApplication extends Application{
  public CustomContentHandlerApplication() {
	  System.out.println("inside ContentHandler class constructor");
}
}
