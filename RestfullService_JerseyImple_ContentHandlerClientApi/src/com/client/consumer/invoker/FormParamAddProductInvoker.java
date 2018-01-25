package com.client.consumer.invoker;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;

//This class acts as ClientService class and it will invoke the Restfull Resoucrce class method
public class FormParamAddProductInvoker {
	
	private final String JERSEY_BASE_URI = "http://localhost:8998/RestfullService_JerseyImple_ClientApiProvider/api";
	private final String RESTEASY_BASE_URI = "http://localhost:7667/RestfullService_JerseyImple_ClientApiProvider/api";
 
	
   public FormParamAddProductInvoker() {
	   System.out.println("inside FormParamAddProductInvoker class constructor");
    }
   
   public String addProduct() {
	   System.out.println("inside addProduct method from client side");
	   //Here you can path / symobl also it's ok if you not pass it will pass by itself
	   WebTarget target = ClientBuilder.newClient().target(JERSEY_BASE_URI).path("/product").path("/add");
	   System.out.println("targrt url is : "+target.toString());
	   /*MultivaluedMap  multiValuedMap = new MultivaluedMap<K, V>();
	    * It is An interface so we can not create the object but if you want to send form data this object we required
	    * Insted of that we can create form object and we can send this also
	    * */
	   Form formData = new Form();
	   formData.param("authorName", "KrishnaReddy");
	   formData.param("booktype", "Let Us C");
	   formData.param("Price", "500");
	   formData.param("Edition", "5th");
	   
	   /*Then Send this book as part of request Body for this they have provided some predefined methods inthe form of Entity class*/
	   String message = target.request().post(Entity.form(formData)).readEntity(String.class);
	   return message;
   }
}
