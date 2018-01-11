package com.injections.headerparam.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/*")
public class HeaderParamApplication extends Application {
	public HeaderParamApplication() {
		System.out.println("inside the HeaderParam Application class constructro");
	}
}
