package com.jerseyinterfaceprogramming.common.interfaces;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

public interface BildeskProvider {
	
   @POST
   @Consumes(MediaType.APPLICATION_XML)
   @Produces(MediaType.APPLICATION_XML)
   public StreamingOutput pay(InputStream in);
}
