package com.client.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


public class MerchantInvoker {
	private final String  BASE_URI = "http://localhost:7887/RestfullService_JerseyImple_ContentHandlers/api/merchant/address";
   public MerchantInvoker() {
	   System.out.println("inside merchant address invoker class constructor");
}
   public String getMerchantAddressByName(String merchantName){
	   System.out.println("inside MerchantInvoker class getMerchantAddressByName method");
	   ClientBuilder clientBuilder = ClientBuilder.newBuilder();
	   Client client = clientBuilder.build();
	   WebTarget target =  client.target(BASE_URI);
	   target.queryParam("mechant-name", merchantName);
	   return null;
   }
}
