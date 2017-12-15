package com.resteasyimpl.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/product")
public class ProductResource {
	public ProductResource() {
		System.out.println("This is ProductResource called");
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
 public int getProductDetails(@QueryParam("productName")String productName){
	 System.out.println("inside the getProductDetails method");
	 return this.hashCode();
 } {
	 
 }
}
