package com.clientapiprovider.cookieparam.service;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/paytm")
public class PayTmMoneyTransfer {
  public PayTmMoneyTransfer() {
	  System.out.println("PayTm Money Transfer Constructor");
}
  @GET
  @Path("/transfer")
  @Produces(MediaType.APPLICATION_XML)
  public String sendBalance(@CookieParam("mobileNo") String mobileNo ,@QueryParam("amount") int amount) {
	 System.out.println("inside resource method of sendBalance");
	 return "<paytm><mobileno>"+mobileNo+"</mobileno><amount>"+amount+"</amount></paytm>";
  }
}
