package com.subresource.resoucrces;

import javax.ws.rs.Path;

@Path("/care")
public class SamsungCare {
  public SamsungCare() {
	  System.out.println("inside SamsungCare resource class constructro");
}
  @Path("/mobile")
  public MobileCare mobileCare() {
	  MobileCare mobileCare = null;
	  mobileCare = new MobileCare();
	  return mobileCare;
  }
  
  @Path("/home-appliences")
  public HomeApplieancesCare homeApplliencesCare() {
	  HomeApplieancesCare homeApplieancesCare = null;
	  homeApplieancesCare = new HomeApplieancesCare();
			  return homeApplieancesCare;
  }
  
  @Path("/hardwere-components")
  public HardwereComponentsCare hardwereComponentsCare() {
	  HardwereComponentsCare hardwereComponentsCare =null;
	  hardwereComponentsCare = new HardwereComponentsCare();
	  return hardwereComponentsCare;
  }
}
