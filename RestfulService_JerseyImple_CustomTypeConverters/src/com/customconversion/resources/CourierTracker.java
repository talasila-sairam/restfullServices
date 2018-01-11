package com.customconversion.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.customconversion.othresour.AirwayBillNo;

@Path("/courier")
public class CourierTracker {
  public CourierTracker() {
	  System.out.println("inside CourierTracker resource class constructor");
}
  @GET
  @Path("/track/{trackNo}")
  @Produces(MediaType.APPLICATION_XML)
  public String courierTracker(@PathParam("trackNo") AirwayBillNo arbn) {
	  System.out.println("inside the courierTracker method");
	  return "<arbno><trackId>"+arbn.getTracKId()+"</trackId><reference-id>"+arbn.getReferenceCode()+"</reference-id></arbno>";
  }
}
