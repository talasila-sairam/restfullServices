package com.subresource.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/*")
public class SamsungCareApplication extends Application {
 public SamsungCareApplication() {
	 System.out.println("inside Samsung Application Class constructor");
}
}
