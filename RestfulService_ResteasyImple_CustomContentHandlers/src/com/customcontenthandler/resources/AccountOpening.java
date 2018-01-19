package com.customcontenthandler.resources;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.customcontenthandler.dto.ApplicationForm;
import com.customcontenthandler.dto.ApplicationStatus;

@Path("/account")
public class AccountOpening {
	public AccountOpening() {
		System.out.println("inside AccountOpening class constructor");
	}
	@POST
	@Path("/create-account")
	@Consumes({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
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
