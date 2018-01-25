package com.client.consumer.invoker;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.client.consumer.dto.AccountForm;
import com.client.consumer.dto.AccountStatus;

//This class acts as ClientService and it will invoke Restresource method and it will fetch back the response
public class ContentHandlerAccountOpeningInvoker {

	private final String JERSEY_BASE_URI = "http://localhost:8998/RestfullService_JerseyImple_ClientApiProvider/api";
	private final String RESTEASY_BASE_URI = "http://localhost:7667/RestfullService_JerseyImple_ClientApiProvider/api";
	
	public ContentHandlerAccountOpeningInvoker() {
		System.out.println("inside ContentHandlerAccountOpeningInvoker class constructor");
	}
	/*In this usecase we are directly sending the Our CustomObject in request body(AccountForm) and we are reciving the
	 * Custom Object(AccountStatus) in response body by using Message Body Readers and MessageBody Writers 
	 * Here we are just sending and reciving as XML and we can send and recieve as JSON also but we need jackson jars in case of
	 * jersey implementation it will take internally kackson support to convert and retrive the JSON into java Object form
	 * Incase of RestEasy we no need to add anything wildfly it self will have those jars
	 * This is the best practice that every one will follw bcz we are communicationg with the java objects only not with any
	 * other technologies like XML or JSON bcz with the help of MessageBodyReaders and Writers support we can achieve this
	 * So if the restservice is modified and sending some other format of data or recieving some other format of data we no need to change
	 * our code inside the clientservice just we need to provide one more MessageBodyReaders and MessageBodyWriters Thats the Advantage of
	 * going with the MessageBodyReaders and MessageodyWriters
	 * */
	public AccountStatus openAccount(AccountForm accountForm) {
		AccountStatus status = null;
		System.out.println("AccountForm Object is : "+accountForm);
		WebTarget target = ClientBuilder.newClient().target(JERSEY_BASE_URI).path("/account").path("/create-account");
		System.out.println("target Url is : "+target.toString());
		/*This is to send and recieve the data in the form of xml 
		 * Response response = target.request().post(Entity.xml(accountForm));
		if(response.getStatus() == 200) {
			System.out.println("inside if block");
			status = response.readEntity(AccountStatus.class);
		}
		System.out.println("AccountStatus Object is "+status);
		return status;*/
		
		/*This code is to send and recieve the data in the form of json but the problem is
		 * we need some more jars at client side to convert it into json and read from json to java object as well
		 * Here we have accept header which is usefull for content negotiation purpose
		 * client wants only specific format of data but in server side resource is
		 * able to send multiple formats of data you can do it by providing accept request header
		 * */
		Response response = target.request().header("Content-Type", "application/xml").accept(MediaType.APPLICATION_JSON).post(Entity.xml(accountForm));
		if(response.getStatus() == 200) {
			System.out.println("response header  "+response.getHeaderString("Content-Type"));
			System.out.println("inside if block ");
			status = response.readEntity(AccountStatus.class);
		}
		return status;
	}
}
