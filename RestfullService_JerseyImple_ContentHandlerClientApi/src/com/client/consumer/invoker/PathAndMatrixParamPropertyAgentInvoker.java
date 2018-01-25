package com.client.consumer.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/*we have to deploy this application in wildfly server bcz jersey will not support matrix paramters 
 * and the root application path modified from /api/* to /api incase of wildfly server
 * */
public class PathAndMatrixParamPropertyAgentInvoker {
 
	private final String JERSEY_BASE_URI = "http://localhost:8998/RestfullService_JerseyImple_ClientApiProvider/api";
	private final String RESTEASY_BASE_URI = "http://localhost:7667/RestfullService_JerseyImple_ClientApiProvider/api";
	public PathAndMatrixParamPropertyAgentInvoker() {
	  System.out.println("inside PathAndMatrixParamProperyAgentInvoke class constructor");
	  }
	public String search(String location ,String type ,String areaName ,String flatType , double minBudget , double maxBudget) {
		System.out.println("inside search method");
		String message = null;
		ClientBuilder builder = ClientBuilder.newBuilder();
		
		/* builder.register("some.class") 
		 * -->This is used to register any MessageBodyReader and MessageBodyWriter to the client
		 *    Bcz Invoker will asks client for MesaageBodyReaders or Writers inorder to convert it into specific format
		 * 
		 * builder.property("connection-timeout", 3600); 
		 * --> This is used to set any property like connection timeouts
		 * -->Not only this we can set SSL Certificates as well
		 * #### All these methods are Not Only Applicable at global level that is At ClientBuilder class also available at Client and
		 * WebTarget level also bcz All These are implementing common interface so
		 * In some cases you may want some Client timeout will less when compared with other in such a case you can over ride it 
		 * At the WebTarget level also you can apply means if you want to apply at a particulatr method level means you want one 
		 * particular method wants to take more time in such a case you can do it 
		 * 
		 * If you want to create Client with pre populated data you can use this method or This Builder class it self contain 
		 * one factory method that will return empty client object 
		 * --> Clent client = ClientBuilder.newClient();
		 * */
		
		  Client client = builder.build();
		  
		  /*Here every class follows Here Builder Design Pattern.This is the modern way of approach. insted of going for factory 
		   * we can use builderFactory in order to create the Object with pre populated data.if you go for factory it will 
		   * create the object as empty.if we want we can do it by passing as constructor but it is difficult to pass and remember also
		   * in such a case we can go for builder her what ever the attributes we have builderFactory will contain the same methods no 
		   * more setters you can call one method on onther it will return the same class object with populating data on to it.
		   * when you call build method it will return target object here it is Client.
		   * */
		  
		  WebTarget target = client.target(RESTEASY_BASE_URI).path("/agent").path("{location}").resolveTemplate("location", location).path("search").path(type).path("{areaName}").resolveTemplate("areaName", areaName).matrixParam("flatType", flatType).queryParam("minBudget", minBudget).queryParam("maxBudget", maxBudget);
		 
		  
		  /*You can construct the target based on QueryParams or PathParams or MatrixParams also they way you configure is your wish
		   * Bcz if you have a path param /type/
		   *  -->this you can resolve either of ways
		   *  1)Directly path(type) value you can provide or 
		   *  2)First provide it as path param then resolve it  as  path({type}).resolveTemplate("type" ,type) value you can assign it
		   *  These things you have to design based on the cline documentation. in between if you have any matrix paramters you can 
		   *  place them inside the path paramter you want to send this
		   * */
		  
		  System.out.println("requested url  "+target.toString());
      
		   Builder invocationBuilder =  target.request();
		   
		   Invocation invocation = invocationBuilder.buildGet();
		   
		   Response response = invocation.invoke();
		  
		   
		   /*Here as it follows builder design pattern one will helps as builder to another inorder to create the object
		    * ClientBuilder
		    *    |- Client
		    *        |-WebTarget
		    *            |-InvocationBuilder
		    *                   |-Invocation
		    *  
		    * --> You can directly call get or post or delete or put those methods on InvocationBuilder object internal implimentation
		    *  of these methods are creating Invocation object on this object they are calling get or post what whever we are calling
		    *  Api is Providing Boiler Plate Logic
		    *  
		    *  Response response = target.request().get();
		    *  
		    * --> This InvocationBuilder contains some over loaded methods.for the request method if you pass the response class type
		    *     directly it will convert it into response this will reduce one more step in your coding
		    *     --> Response response = target.request().get();
		    *     --> invocationBuilder.build("GET") or with this you can pass Entity class as well
		    *     -->  invocationBuilder.post(Entity.xml(""));
		    *     
		    *     Entity is the class there lot of predefined formats are there. so you just pass the entity object it will return the
		    *     response object as return value. Means if your providers is consuming XML the aboe methods will send the given data or 
		    *     object as request body in xml formatt to the client in xml format
		    *     
		    * --> If you want you can do it by manually also both will work perfectly incase of this we need to write the three line of the code
		    *    
		    *    Builder invocationBuilder =  target.request();
		    *    Invocation invocation = invocationBuilder.buildGet();
		    *    Response response = invocation.invoke();
		    * */
		 
		   if(response.getStatus() == 200) {
			   message  = response.readEntity(String.class);
			   System.out.println("inside if block ");
		   }
		   
		   /*It will return the Response Object it is comming from jax-rs api you can multiple methods on this object like
		    * getStatusCode and readEntity this method is more usefull. you can provide the class type of return value so that
		    * jax-rs runtime will convert the response entity or response data or response body to Provided class type
		    * so we no need to convert it in our client class it will convert it inti xml or json or our own class objects as well 
		    * if it finds any MessageBodyReaders or MessageBody Writers
		    * 
		    * #####   response.bufferEntity();
		    * This method is more important bcz once you red the data from response body using readEntity if you call one more time
		    * it will throw exception saying illegalThreadStateException Bcz after completing of this method it will close the outputstream 
		    * on closing outputstream you will get illegal thread state exception so if you use bufferEntity() method it will read and places 
		    * entire response inside buffer when ever you ask for response  it will give it from here
		    * */
		return message;
	}
}
