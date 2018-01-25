package com.clientapiprovider.queryparam.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/*This is the RootRequestResource class based on this Address only it will identify and delivers the resource
 * This is also called as RootResourceclass. This will be done by providing @Path annotation on it 
 * */
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
