package com.clientapiprovider.contenthandler.service;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.clientapiprovider.contenthandler.dto.ApplicationForm;
import com.clientapiprovider.contenthandler.dto.ApplicationStatus;


/*Incase of xml format of data recieved is Xml or json you can take any number of formats every 
 *format will convert into Java Objects by using MessageBodyWriters and You can send Any data as response 
 *what you we have to do is return java object it will convert into Required format so we no need to dependent
 *on anything just we have to provide MessageBodyReaders and MessageBodyWriters it will convert automatically
 *We have to send the response backto the client he amy want to recieve the specific format only that 
 *he will send as part of the RequestHeaders as Accept with that jax-rs runtime will understand and convert 
 *it into that specific format and send back to the client this is called content negotiation
 *
 * Request Data incase of xml is 
  <application-form>
	  <first-name>talasila</first-name>
	  <last-name>sairam</last-name>
	  <address>warangal</address>
	  <mobile-no>9701136377</mobile-no>
	  <pincode>506344</pincode>
  </application-form>
  
  Response form the resource is 
  <application-status>
    <account-no>edb7724f-14c4-4b02-889c-71af28d6a638</account-no>
    <status>SUCCESS</status>
    <balance>1265.23</balance>
    <name>Sairam Talasila</name>
</application-status>

Request Data incase is Json is 
{
  "first-name" : "talasila" ,
  "last-name"  : "sairam" ,
  "address"    : "warangal" ,
  "mobile-no"  : "9701136377" ,
  "pincode"    : "506344"
}

Response Data incase of json is
{
    "status": "SUCCESS",
    "balance": 1265.23,
    "name": "Sairam Talasila",
    "account-no": "7f1f7da7-9d37-4e1d-8718-a3c9e597f7c6"
}
 * */
@Path("/account")
public class AccountOpening {
	public AccountOpening() {
		System.out.println("inside AccountOpening class constructor");
	}
	@POST
	@Path("/create-account")
	@Consumes({MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public ApplicationStatus createAccount(ApplicationForm appForm) {
		System.out.println("inside createAccount method");
		System.out.println("output from applicatioform  "+appForm);
		ApplicationStatus applicationStatus = null;
		applicationStatus = new ApplicationStatus();
		applicationStatus.setAccountNo(UUID.randomUUID().toString());
		applicationStatus.setBalance(1265.23);
		applicationStatus.setName("Sairam Talasila");
		applicationStatus.setStatus("SUCCESS");
		System.out.println("output from applicatioform  "+applicationStatus);
		return applicationStatus;
	}
}
