package com.pathparameters.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/track")
public class FlipkartTrackingResources {

	public FlipkartTrackingResources() {
		System.out.println("inside the flipkart resource class constructor");
	}
	@GET
	/*This is nothing but SubResource */
	//@Path("/product")
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{orderId}/{loginId}")
    public String trackProduct(@PathParam("orderId") String orderId ,@PathParam("loginId") String loginId) {
		System.out.println("inside the FlipkartTracking Resources  ");
		System.out.println("orderId   "+orderId+"    and loginId   "+loginId);
	return "your Product is ready to deliver";
   }
}
