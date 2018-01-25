package com.clientapiprovider.crickbuzzoptimization.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cricket")
public class Crickbuzz {
  
	public Crickbuzz() {
	  System.out.println("inside crickbuzz resource class constructor");
    }
	
	@GET
	@Path("/score/{matchno}/{innings}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateScore(@PathParam("matchno") int matchno ,@PathParam("innings") int innings ) {
		System.out.println("inside updateScore method of resource class");
		System.out.println("MatchNo  : "+matchno +" , Innings : "+innings);
		return "345/6";
	}
}
