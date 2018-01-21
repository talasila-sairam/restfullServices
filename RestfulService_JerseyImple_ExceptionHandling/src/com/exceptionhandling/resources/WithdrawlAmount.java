package com.exceptionhandling.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.exceptionhandling.dto.AccountDetails;
import com.exceptionhandling.dto.ErrorResponse;
import com.exceptionhandling.dto.Reciept;
import com.exceptionhandling.exception.AccountNoInvalidException;


@Path("/atm")
public class WithdrawlAmount {
	public WithdrawlAmount() {
		System.out.println("inside withdrawl amount constructor");
	}
	
	@PUT
	@Path("/withdrawl")
	@Consumes({MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public Response amountWithdrawl(AccountDetails accountDetails) {
		System.out.println("inside amountWithdrawl method");
		try {
		    if(accountDetails.getAccountNo() == null || accountDetails.getAccountNo().length() == 0) {
			  System.out.println("inside if condition");
			/*
			 * case-1
			 *   -->throw new RuntimeException();
			 * here we have to throw the exception but if we throw directly
			 * Jax-Rs default exception handling mechanism will occur insted of that we need to handle it
			 * Inthis case return type is Reciept only.here we are adding step by step to this usecase
			 * 
			 * 
			 * case -2
			 *   -->throw new SQLException();
			 *   Here it seems like correct in case of client or end user prospective but it is not correct incase of codeing
			 *   prospective means it is not matching the symantics of the java we are performing the alternate path of the excecution
			 *   we are not throwing the exception rather we are performing the alternate path exceution even in case of 
			 *   exception also we are sucessfully returning the sucess response to the enduser but it is not seems like correct
			 *   
			 *   
			 *   
			 * case -3
			 *    ---> throw new SQLException();
			 *    Some how some where some SQL Exception is raised bcz of invalid AccountNo or some thind it will raise exception
			 *    weather it is checked exception or runtime exception we are handling it by means of try and catch
			 *    inside catch earlier we are performing the alternate path of the excecution.in case of case 3 we are agin rethrowing the 
			 *    webapplication exception so that jax-rs runtime will understand that he want to throw webapplication exception by constructiong
			 *    all his details in it and it will extract and it will dispaly to end user.and this will be fulfilling the symantics of the java also
			 *    This is one type of handling the exceptions in the rest services.if you have multiple services and you have requirement to check account no 
			 *    in multiple services so you have to write the same logic in multiple services to throw the same exception this will duplicate the exception logic
			 *    in all the services.in such case you have go for global exceptions in case 4
			 *    
			 *     
			 * case -4
			 *     ---> throw new SQLException();
			 *     if we have multiple resources with same logic.if we follow case 3 it will leads to duplicate the logic across all the methods
			 *     insted of that write any class that extends fron runtime or throwable and thorows this exception where ever you want to
			 *     throw the same exception.and write one more class that is Exception Mapper inside this class write the logic to send client 
			 *     understandable message.
			 * */
			  throw new SQLException();
		    }
		}catch (SQLException e) {
			/*
			   Remove this Three lines of code case 4.should avail for case 2 and 3
			   ErrorResponse errorResponse = new ErrorResponse();
			   errorResponse.setCode("001");
			   errorResponse.setDescription("Please Provide Correct Details");
		   */
			
			/* case -2  return Response.status(Status.BAD_REQUEST).entity(errorResponse).build();*/
			/* case -3  throw new WebApplicationException(e ,Response.status(Status.BAD_REQUEST).entity(errorResponse).build());*/
			
			throw new AccountNoInvalidException();
			
		}
		Reciept reciept = null;
		reciept = new Reciept();
		reciept.setAccountNo(accountDetails.getAccountNo());
		reciept.setRemaingBalance(500.35);
		reciept.setStatus("SUCCESS");
		return Response.status(Status.OK).entity(reciept).build();
		
	}
}
