package com.clientapiprovider.formparam.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Path("/product")
public class ProductDetails {
  public ProductDetails() {
	  System.out.println("inside ProductDtails class constructor");
  }
  
  @POST
  @Path("/add")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String addProduct(MultivaluedMap<String, String> formData) {
	       System.out.println("inside addProduct Method");
			 StringBuffer sb = null;
			 sb = new StringBuffer();
			 for(String key : formData.keySet()){
				 System.out.println("key   :"+key+"   and Value  :   "+ formData.getFirst(key));
				 String data = "key   :"+key+"   and Value  :   "+ formData.getFirst(key);
				 sb.append(data);
			 }
			 return sb.toString();
  } 
}
