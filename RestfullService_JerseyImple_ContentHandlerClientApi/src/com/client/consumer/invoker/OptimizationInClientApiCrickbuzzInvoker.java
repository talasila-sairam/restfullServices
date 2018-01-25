package com.client.consumer.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

//This class will acts as Invoker

public class OptimizationInClientApiCrickbuzzInvoker {
	ClientBuilder clientBuider = null;
	Client  client = null;
	WebTarget target = null;
	

	private final String JERSEY_BASE_URI = "http://localhost:8998/RestfullService_JerseyImple_ClientApiProvider/api";
	private final String RESTEASY_BASE_URI = "http://localhost:7667/RestfullService_JerseyImple_ClientApiProvider/api";
	
	/*Incase of crickbuzz or every time fetching updated kind of requests
	 * we should not create the ClientBuilder and Client and WebTargets are not required 
	 * Bcz The request to which we want to acess the resource is constant always
	 * for repeated requests . in such case  we should create those objects in method level 
	 * create them at constructor level and try to accsess them inside the method
	 * so we can avoid repeated creating of objects 
	 * */
	
  public OptimizationInClientApiCrickbuzzInvoker() {
	  System.out.println("inside performenceOptimization invoker class constructor");
	  clientBuider = ClientBuilder.newBuilder();
	  client = ClientBuilder.newClient();
	  target = client.target(JERSEY_BASE_URI);
	  System.out.println(target.toString());
	  
 }
  //In side this methos we no need to create all those objects
  public String updateScore(int matchNo , int innings) {
	  System.out.println("inside scoreUpdate method of invoker class");
	  target =target.path("/cricket").path("/score").path("/{matchNo}").resolveTemplate("matchNo", matchNo).path("/{innings}").resolveTemplate("innings", innings);
	  System.out.println("targeted url is : "+target.toString());
	  return target.request().get(String.class);
  }
}
