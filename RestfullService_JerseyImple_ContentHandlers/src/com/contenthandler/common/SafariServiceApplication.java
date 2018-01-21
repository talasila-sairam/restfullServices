package com.contenthandler.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
/*This is Application class*/
@ApplicationPath("/api/*")
public class SafariServiceApplication extends Application{
  public SafariServiceApplication() {
	  System.out.println("inside Application class constructor");
}
}
