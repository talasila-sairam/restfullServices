package com.injections.context.resources;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/*")
public class PropertyAgentApplication extends Application {
  public PropertyAgentApplication() {
	  System.out.println("inside PropertyAgent Application constructor");
}
}
