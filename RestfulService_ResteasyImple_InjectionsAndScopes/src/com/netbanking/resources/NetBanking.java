package com.netbanking.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/netBanking/{accountNo}")
public class NetBanking {
	//@PathParam("accountNo")
	private String attrAccountNo;
	
	private String accountNo;
	 public NetBanking(@PathParam("accountNo") String accountNo) {
		 this.accountNo = accountNo;
		 System.out.println("constructor level injection "+accountNo);
		 System.out.println("Attribute injection  "+attrAccountNo);
		 System.out.println("inside the constructor");
	}
	@GET
	@Path("/balance")
	@Produces(MediaType.TEXT_PLAIN)
	//Parameter Level Injection  @PathParam("accountNo") String accountNo
public float getBalance() {
		System.out.println("attribute injection checking from getBalance "+accountNo);
		System.out.println("inside getBalance method  cons  "+accountNo);
		System.out.println("inside getBalance method attr "+attrAccountNo);
	return 123.62f;
}
	@GET
	@Path("/payee")
	@Produces(MediaType.APPLICATION_XML)
	//Parameter Level Injection  @PathParam("accountNo") String accountNo
	public String getPayee() {
		System.out.println("inside GetPayee method parameter injection "+accountNo);
		System.out.println("inside getBalance method  cons  "+accountNo);
		System.out.println("inside getBalance method attr "+attrAccountNo);
		return "<payees><payee> "+accountNo+" </payee></payees>";
	}
}
