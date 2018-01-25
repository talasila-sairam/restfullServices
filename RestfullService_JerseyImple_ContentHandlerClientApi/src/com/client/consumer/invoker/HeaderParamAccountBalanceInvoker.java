package com.client.consumer.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class HeaderParamAccountBalanceInvoker {
	/*These are the base uris means address where our resources are running 
	 * Here we have to consider up to resource class bcz for one resource we have to create one client 
	 * and what ever the methods we have in service class or restfull service class same should be there inside 
	 * of ClientApi classes also it seems like our client class only composing the value.
	 * For Every Resource Method may or MayNot Annotated with path so insuch a case we have take a the different
	 *  methods inside the client service class those are representing the rest services classes in each and every class
	 *  we need to construct the specific path to the specific sub resource method. for all these resource method 
	 *  common is base uri so we are providing at top it it gets modified only one place we need to modify 
	 *  
	 * */
	private final String JERSEY_BASE_URI = "http://localhost:8998/RestfullService_JerseyImple_ClientApiProvider/api";
	private final String RESTEASY_BASE_URI = "http://localhost:7667/RestfullService_JerseyImple_ClientApiProvider/api";
  public HeaderParamAccountBalanceInvoker() {
	  System.out.println("inside HeaderAndCookieParamInvoker class constructor");
  }
  /*This method is used to fetch the balance information of a account
   * And this parameter should be passes as Header parameter
   * */
  public String getBalance(String accountNo ,String bank) {
	  ClientBuilder clientBuilder = ClientBuilder.newBuilder();
	  String message = null;
	 //creating empty Client
	  Client client = clientBuilder.build();  
	  WebTarget target = client.target(JERSEY_BASE_URI).path("/account").path("/balance").queryParam("bank", bank);
	  System.out.println("base uri "+target.toString());
	  Invocation.Builder invocationBuilder = target.request();
	  invocationBuilder.header("accountNo",accountNo);
	  /*After creation of invocation Builder Object we need to pass header or cookie parameter values to it 
	   * There are Two parts of the request is there
	   * 1)Address part or WebAddress(Url with query and path and matrix paramters available)
	   * 2)Request Part
	   *    Again it was divided into two more parts 
	   *     1)Cokkie or Requesty Headers 
	   *     2)Request Body(Here you can pass your own object or text or any thing as Entity class)
	   * ## Once after completion of request object means after providing the webaddress to it we can able to send the 
	   * Header Parameters and cookie parameters to it 
	   * 
	   * Here Invocation invocation = invocationBuilder.build("GET");
	   *                          or
	   *      Invocation invocation = invocationBuilder.buildGet();
	   * Then invocation.invoke()  or invocation.invoke(ClassType) so that it will invoke the target class resource 
	   * 
	   * or 
	   *      Response response = invocationBuilder.get() 
	   *      Here This class contains one builder method that internally creates Invoke object and and it will invoke on it and 
	   *      it will return Response to us directly
	   * 
	   *      
	   * */
	  Invocation invocation = invocationBuilder.buildGet();
	  Response response = invocation.invoke();
	  if(response.getStatus() == 200) {
		  System.out.println("inside if block");
		  response.bufferEntity();  //To strore in buffer before closing outputstream 
		  message  = response.readEntity(String.class);
	  }
	  return message;
  }
}
