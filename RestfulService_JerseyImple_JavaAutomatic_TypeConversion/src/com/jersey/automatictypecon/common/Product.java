package com.jersey.automatictypecon.common;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.automatictypecon.resources.ProductCode;

@Path("/product")
public class Product {
	
 public Product() {
	 System.out.println("inside Product class constructor");
}
@GET
@Path("/{productNo}")
@Produces(MediaType.TEXT_PLAIN)
 public String productInfo(@PathParam("productNo") ProductCode productCode) {
	 System.out.println("inside the resource class method");
	 return productCode.toString();
 }
}
