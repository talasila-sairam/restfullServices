package com.tourpackage.resources;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.StreamingOutput;

import com.tourpackage.common.TourPackageApplicationStreamingOutput;

/*This is nothing but RootResource class HttpDispatcherServlet/ServletContainer of jax-rs implementation is forward the request to
 * resource class by looking at the @Path annotation url pattern. Bcz as it non j2ee component it can not directly recieve the request
 * */
@Path("/tour")
public class TourManager {
	
	
	/*This is the HttpMethodDesignator we have to bind this to our specific method based on the functionality of our resource method
	 * we have to annotate with either of the HttpMethodDesignators so that it will start behaving as Resource Method
	 * 
	 * Still we can provide @Path annotation at method level because user can send the url pattern upto method specific level and if you have 
	 * two post methods are there with in the same resource class you differentiate them by using this Method level @Path annotation
	 * 
	 * @Produces Annotation is used to produce the outcome outof this method it could be any this so that browser will understand by looking at
	 * this response headder. and it will read out the data in proper format
	 * 
	 * In this case we are asking the Jax-rs runtime to provide inputStream not any QueryParameter and also we are not mentioning any Consumes type
	 * so Jax-rs runtime will read the entire request object and conert it into input Stream and passes as parameter to our post request.
	 * To send response to the member we need output Stream but we dont have outputStram object. here there are two ways we can devlop this kind of applications
	 * one way is we have to ask the person who had this output stream object to perform this operation or else give your task to the person ask him to finish this 
	 * task this is nothing but callback function.
	 * 
	 * Here inputStream we are getting and we need to send our own outputStrem object insted of depending on runtime prepared one. Bcz there are this situations 
	 * you can go for Our own outputStream rather than Runtime Provided one. when you want to encrypt the data and when you want zip the file this things will not
	 * done by Default OutputStrem writer
	 * 
	 * If you want to write your own outputStrem Jax-rs runtime will not give you the OutputStream object to you bcz you can miss use it or else you can
	 * close this object, after this if it wants to perform some operations that object will not availeble once closed.
	 * 
	 * To avoid such kind of problems it is provided one contractual method means one interface if you over ride that method by implementing this it will call ths 
	 * method automatically when ever it is free by passing outputstream as argument 
	 * 
	 * First Case is the Writing our own OutputStrem object we need to tell to the Jax-rs runtime by sending the Contract interface implemented class object to it
	 * That interface is called StreamingOutput is the interface
	 * */
	@POST
	@Path("/package1")
	@Produces("image/jpeg")
	public StreamingOutput bookPackage1(InputStream inputStream){
		System.out.println("inside the bookPackage method");
		return new TourPackageApplicationStreamingOutput("xyz");
	}
	
	/*In this case what ever the logic we have written inside that Stramingoutput implemented class in this case we are wrting inside to this method and returning 
	 * This byte[] object to it */
	@POST
	@Path("/package2")
	@Produces("image/jpeg")
	public byte[] bookPackage2(InputStream inputStream){
		System.out.println("inside the bookPackage method");
		  File file = new File("C:\\Users\\t05053\\Downloads\\appstek.jpg");
		  FileInputStream fileInputStream = null;
		  ByteArrayOutputStream buffer  = null;
		try {
			fileInputStream = new FileInputStream(file);
		  buffer = new ByteArrayOutputStream();
		  int nRead = 0;
		  byte[] data = new byte[(int)file.length()];
			while ((nRead = fileInputStream.read(data, 0, data.length)) != -1) {
				System.out.println("inside while loop");
			    buffer.write(data, 0, nRead);
			buffer.flush();
			}
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally {
			 return buffer.toByteArray();
		}
	}

}
