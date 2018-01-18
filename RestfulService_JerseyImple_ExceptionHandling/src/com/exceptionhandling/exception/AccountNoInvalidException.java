package com.exceptionhandling.exception;

public class AccountNoInvalidException extends RuntimeException {
	//Here you can take the attributes that you want to dispaly or else you can do it in Mapper also
  public AccountNoInvalidException() {
	  System.out.println("inside CustomException class constructor");
}
}
