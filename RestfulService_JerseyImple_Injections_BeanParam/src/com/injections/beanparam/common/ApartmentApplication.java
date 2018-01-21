package com.injections.beanparam.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/* for jersey implimentation we need to provide * Mandataroy 
 * for resteasy implimentation we should not provide other 
 * wise it will not found requested url */

@ApplicationPath("/api")
public class ApartmentApplication extends Application {
public ApartmentApplication() {
	System.out.println("inside the Application class constructor");
}
}
