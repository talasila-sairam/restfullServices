package com.client.consumer.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

//This class acts as ClientService and it will invoke Restresource method and it will fetch back the response
public class CookieParamPayTmMoneyTransferInvoker {
	
	private final String JERSEY_BASE_URI = "http://localhost:8998/RestfullService_JerseyImple_ClientApiProvider/api";
	private final String RESTEASY_BASE_URI = "http://localhost:7667/RestfullService_JerseyImple_ClientApiProvider/api";
 
   public CookieParamPayTmMoneyTransferInvoker() {
	   System.out.println("inside CookieParamPayTmMoneyTransfer constructor");
}
	  public String sendBalance( String mobileNo ,int amount) {
		  System.out.println("inside sendBalance method ");
		  //This one is the longest or more code we can reduce it into one line of code lot of 
		  //shortcut methods are there in each of build method
		  String message = null;
		  ClientBuilder clientBuilder = ClientBuilder.newBuilder();
		  Client client = clientBuilder.build();
		  WebTarget target = client.target(JERSEY_BASE_URI).path("/paytm").path("/transfer").queryParam("amount" ,amount);
		  Invocation.Builder invocationBuilder = target.request();
		  invocationBuilder.cookie("mobileNo", mobileNo);
		  Invocation invocation = invocationBuilder.buildGet();
		  Response response = invocation.invoke();
		  System.out.println("target url : "+target.toString());
		  if(response.getStatus() == 200) {
			  System.out.println("inside if block");
			  message = response.readEntity(String.class);
		  }
		 return message;
	  }
}



