package com.clientapi.consumer.test;

import com.client.consumer.dto.AccountForm;
import com.client.consumer.dto.AccountStatus;
import com.client.consumer.invoker.ContentHandlerAccountOpeningInvoker;
import com.client.consumer.invoker.OptimizationInClientApiCrickbuzzInvoker;
/*
 * This class acts as Servlet class bcz from an web application either
 *  a servlet or any Web component will call or invoker class
*/
public class Test {
	public static void main(String[] args) {
	
   /*QueryParamMerchantInvoker merchantInvoker = new QueryParamMerchantInvoker();
	merchantInvoker.getMerchantAddressByName("sairam");*/
	
   /* PathAndMatrixParamPropertyAgentInvoker pathAndAgetInvoker = new PathAndMatrixParamPropertyAgentInvoker();
    String message  = pathAndAgetInvoker.search("Hyderabad","flat","Kukatpally","2BHK", 120000.00, 1254692.00);
    System.out.println("message : "+message);*/
		
	/*HeaderParamAccountBalanceInvoker headerparamAccountBalanceInvoker = new HeaderParamAccountBalanceInvoker();
	String message = headerparamAccountBalanceInvoker.getBalance("SBIN003769", "StateBankOfIndia");
	System.out.println("message :  "+message);*/
	
	/*CookieParamPayTmMoneyTransfer cookieParamPayTmTransfer = new CookieParamPayTmMoneyTransfer();
	String message = cookieParamPayTmTransfer.sendBalance("9701136377", 1253);
	System.out.println("message : "+message);*/
		
	/*FormParamAddProductInvoker formParamAddProductInvoker = new FormParamAddProductInvoker();
	String message = formParamAddProductInvoker.addProduct();
	System.out.println("message : "+message);*/
		
	/*ContentHandlerAccountOpeningInvoker contentHandlerInvoker = new ContentHandlerAccountOpeningInvoker();
	AccountForm acccountForm = new AccountForm();
	acccountForm.setFirstName("sairam");
	acccountForm.setLastName("talasila");
	acccountForm.setAddress("govindaraopet");
	acccountForm.setMobileNo("9701136377");
	acccountForm.setPincode(506344);
	AccountStatus status =  contentHandlerInvoker.openAccount(acccountForm);
	System.out.println("status Object  :  "+status);*/
		
	/*OptimizationInClientApiCrickbuzzInvoker optimization = new OptimizationInClientApiCrickbuzzInvoker();
	String message = optimization.updateScore(52, 4);
	System.out.println("message : "+message);*/
		
	}
}
