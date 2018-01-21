package com.contenthandler.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/*This class is writing for ContentHandlerrClientApi will purpose bcz as that is Client Api
 * it will try to acess this resource 
 * */
@Path("/merchant")
public class Merchant {

	public Merchant() {
		System.out.println("inside Merchant class constructor");
   }
	@GET
	@Path("/address")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMerchantAddress(@QueryParam("mechantName")String mechantName){
		System.out.println("inside resource class getMerchantAddress method");
		return null;
	}
}
