package com.exceptionhandling.exceptionmappper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.exceptionhandling.dto.ErrorResponse;
import com.exceptionhandling.exception.AccountNoInvalidException;

/*We need to register this with jax-rs runtime with the help of providers
 * Providers are important in jax-rs those are introduced in 2.0 we can identified with help of ext package
 * MessageBodyReader Provider
 * MessageBodyWrite  Provider
 * ExceptionMapper   Provider
 * CustomTypeConverters  Provider
 * ContextResolver   Provider
 * */
@Provider
public class AccountNoInavlidExceptionMapper implements ExceptionMapper<AccountNoInvalidException> {
  //Genric is mandatory.so that it will identify and injects the class with required set of data 
	public AccountNoInavlidExceptionMapper() {
		System.out.println("inside AccountNoInvalidExceptionMapper class constructor");
	}
	@Override
	public Response toResponse(AccountNoInvalidException accNoInvalidException) {
		System.out.println("inside toResponse");
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode("001");
		errorResponse.setDescription("Please Provide the Correct AccountNumber");
		return Response.status(Status.BAD_REQUEST).entity(errorResponse).build();
	}

}
