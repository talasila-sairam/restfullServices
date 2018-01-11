package com.injections.cookieparam.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/*")
public class CookieParamApplication extends Application {
   public CookieParamApplication() {
	   System.out.println("inside the CookieApplication class");
  }
}
