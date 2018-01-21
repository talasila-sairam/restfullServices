package com.subresource.resoucrces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class MobileCare {
	public MobileCare() {
		System.out.println("mobile care class constructor");
	}
	@GET
	@Path("/repair")
	@Produces(MediaType.TEXT_PLAIN)
   public String repair() {
    System.out.println("inside repair method of MobileCare");	
	return "It will take few days to repair";
   }
}
