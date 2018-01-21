package com.subresource.resoucrces;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class HomeApplieancesCare {
public HomeApplieancesCare() {
	System.out.println("inside HomeApplieancesCare constructor");
}

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String service() {
	System.out.println("inside service method from HomeAppliencescare class");
	return "service is completed ready to deliver";
  }
}
