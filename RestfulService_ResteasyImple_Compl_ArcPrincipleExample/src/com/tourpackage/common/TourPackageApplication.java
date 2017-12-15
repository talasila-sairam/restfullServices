package com.tourpackage.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class TourPackageApplication extends Application {
	public TourPackageApplication() {
		System.out.println("inside the TourPackageApplication Constructor");
	}

}
