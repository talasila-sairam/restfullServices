package com.customconversion.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/*")
public class CourierTrackerApplication extends Application {
 public CourierTrackerApplication() {
	 System.out.println("CourierTrackerApplication class constructor");
}
}
