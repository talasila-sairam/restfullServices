package com.exceptionhandling.resources;

import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.exceptionhandling.dto.Acknowledgement;
import com.exceptionhandling.exception.AccountNoInvalidException;

@Path("/account")
public class AccountManagement {

	public AccountManagement() {
		System.out.println("inside AccountManagement Constructor");
	}
	
	@POST
	@Path("/contact/{accNo}/{mobileNo}")
	@Produces({MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public Acknowledgement updateContact(@PathParam("accNo") String accNo ,@PathParam("mobileNo") String mobileNo) {
		Acknowledgement acknowledgement = null;
		try {
		if(accNo.length() != 13) {
			System.out.println("inside if block");
			throw new SQLException();
		}
		}catch (SQLException e) {
			System.out.println("inside catch block");
			throw new AccountNoInvalidException();
		}
		acknowledgement = new Acknowledgement();
		acknowledgement.setAccountNo(accNo);
		acknowledgement.setMobileNo(mobileNo);
		acknowledgement.setStatus("SUCESS");
		return acknowledgement;
	}
}
