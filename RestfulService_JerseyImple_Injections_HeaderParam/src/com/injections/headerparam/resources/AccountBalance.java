package com.injections.headerparam.resources;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountBalance {
	public AccountBalance() {
		System.out.println("inside the constructro of AccountBalance");
	}

	@GET
	@Path("/balance")
	@Produces(MediaType.APPLICATION_XML)
	public String getBalance(@HeaderParam("accountNo") String accountNo ,@QueryParam("bank") String bank){
		System.out.println("inside the HeaderParam Resource method");
		return "<balance><account-num>"+accountNo+"</account-num><bank>"+bank+"</bank></balance>";
	}
}
