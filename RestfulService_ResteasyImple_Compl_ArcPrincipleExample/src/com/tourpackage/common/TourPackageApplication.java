package com.tourpackage.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

/*This is Third way of BootStraping the RestEasy Container and this is last way also incase of ResyEasy Implementaion
 * first two ways are deprecated alsmost those we can configure through Configuring in web.xml.
 * If you write like this automatically it will create resource objects as request scope.Every Implementation will provide the support to this annotation 
 * this annotation is coming from Api not from either of the implementation so if you are working with this annotation it is independent of implementation vendor 
 * */
@ApplicationPath("/rest")
public class TourPackageApplication extends Application {
	public TourPackageApplication() {
		System.out.println("inside the TourPackageApplication Constructor");
	}

}
