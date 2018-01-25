package com.client.consumer.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/*it is invoker class*/
public class QueryParamMerchantInvoker {
	private final String  BASE_URI = "http://localhost:8998/RestfullService_JerseyImple_ClientApiProvider/api";
   public QueryParamMerchantInvoker() {
	   System.out.println("inside merchant address invoker class constructor");
}
   public void getMerchantAddressByName(String productName){
	   System.out.println("inside MerchantInvoker class getMerchantAddressByName method");
	   ClientBuilder clientBuilder = ClientBuilder.newBuilder();
	   Client client = clientBuilder.build();
	   WebTarget target =  client.target(BASE_URI);
	   target = target.path("/product");
	   target.queryParam("productName", productName);
	   Response response= target.request().get();
	   if(response.getStatus() == 200) {
		   System.out.println("inside if block response sucess");
		   int productId = 0;
		   productId = response.readEntity(Integer.class);
		   System.out.println("productId : "+productId);
	   }
   }
}
