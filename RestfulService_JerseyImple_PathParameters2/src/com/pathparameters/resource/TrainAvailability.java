package com.pathparameters.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/avialability")
public class TrainAvailability {
	public TrainAvailability() {
		System.out.println("inside the TrainAvailability Constructor");
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/trains/{source}/{destination}")
	public String getTrains(@PathParam("source") String source ,@PathParam("destination") String destination) {
		System.out.println("inside the getTrains method");
		
		return "<train-info><trains><train>"+source+"  "+destination+"</train></trains></train-info>";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/seats")
	//Here Tomcat and wildfly people are handling the convertion logics
	public String getSeats(@QueryParam("noseats") int noseats) {
		System.out.println("inside the getSeats method");
		String noOfSeats = "";
		return "<train-info><trains><seats>"+noseats+"</seats></trains></train-info>";
	}
}
