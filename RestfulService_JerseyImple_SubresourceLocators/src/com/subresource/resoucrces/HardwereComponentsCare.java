package com.subresource.resoucrces;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class HardwereComponentsCare {
 public HardwereComponentsCare() {
	 System.out.println("inside HardwereComponentsCare class constructor");
}
 @GET
 @Produces(MediaType.TEXT_PLAIN)
 public String hardwereCare() {
	 System.out.println("inside hardwereCare method from HardWereComponents Care ");
	return "Parts has to replace!"; 
 } 
}
