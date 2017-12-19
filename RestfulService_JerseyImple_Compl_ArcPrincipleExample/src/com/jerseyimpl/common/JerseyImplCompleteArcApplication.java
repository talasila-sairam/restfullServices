package com.jerseyimpl.common;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.jerseyimpl.resources.TourManager;

@ApplicationPath("/api/*")
public class JerseyImplCompleteArcApplication extends Application{
	private Set singletons;
   public JerseyImplCompleteArcApplication() {
	   singletons = new HashSet();
	   singletons.add(new TourManager());
	   System.out.println("inside Application class constructor");
   }
   @Override
public Set<Object> getSingletons() {
	return singletons;
}
   
}
