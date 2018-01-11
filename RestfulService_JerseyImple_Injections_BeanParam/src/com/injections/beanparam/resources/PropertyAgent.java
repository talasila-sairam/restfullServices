package com.injections.beanparam.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/agent/{location}")
public class PropertyAgent {
 public PropertyAgent() {
	 System.out.println("inside the property agent class constructor");
 }
 
 @GET
 @Path("/search")
 @Produces(MediaType.TEXT_PLAIN)
 public String search(@BeanParam Apartment apartment) {
	 System.out.println("inside the search method of ProperyAgent class");
	 return apartment.toString();
 }
}
