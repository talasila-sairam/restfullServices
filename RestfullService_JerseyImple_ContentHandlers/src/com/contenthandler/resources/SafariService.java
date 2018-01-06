package com.contenthandler.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.StreamingOutput;

@Path("/safari")
public class SafariService {
 public SafariService() {
	 System.out.println("inside Service class constructor");
}
        /*Allowable Request And Response Parameter Types That Jax-Rs runtime Supports
         *        <------------------Request-------------->
         * -->InputStream
         * -->Reader
         * -->String
         * -->byte[]
         * -->MultiValueMap
         * -->Source
         * -->File
         * 
         * <------------------Response-------------->
         * -->String
         * -->StreamingOutPut
         * -->byte[]
         * -->File
         * */
          /*This is for taking inputstream as parameter Returning String*/
		 @POST
		 @Path("/book")
		 @Consumes(MediaType.TEXT_PLAIN)
		 @Produces(MediaType.TEXT_PLAIN)
		 public String addBook(InputStream inputStream) throws IOException{
			 System.out.println("inside addBookMethod");
			 StringBuffer sb = null;
			 try{
			 sb = new StringBuffer();
			 int c = 0;
			 while( (c = inputStream.read())!= -1){
				 sb.append((char)c);	 
			 }
			 }finally{
				 inputStream.close();
			 }
			 return sb.toString();
		 }

		 /*This is for Taking Reader as parameter Returning String*/
		 @POST
		 @Path("/author")
		 @Consumes(MediaType.APPLICATION_XML)
		 @Produces(MediaType.TEXT_PLAIN)
		 public String addAuthor(Reader reader) throws IOException{
			 System.out.println("inside addAuthor method");
			 int c = 0;
			 StringBuffer sb = null;
			 try{
			 sb = new StringBuffer();
			 while((c=reader.read())!= -1){
				 sb.append((char)c);
				 System.out.println((char)c);
			 }
			 }finally{
				reader.close(); 
			 }
			 return sb.toString();
			 
		 }
		 
		 /*This is for taking String as parameter and Returning String*/
		 @POST
		 @Path("/review")
		 @Consumes(MediaType.TEXT_PLAIN)
		 @Produces(MediaType.TEXT_PLAIN)
		 public String reviewBook(String comment){
			 System.out.println("inside reviewBook method");
			 return comment; 
		 }
		 
		 /*This is for sending response as file for given PataParameters*/
		 @GET
		 @Produces(MediaType.MULTIPART_FORM_DATA)
	     @Path("/download/{isbn/{authorName}}")
		 public File downloadBook(String isbn ,String authorName){
			 System.out.println("inside downloadBook method");
			 File  file = new File("location");
			 return file;
		 }
		 
		 /*This is for Reading MultiValuedMap from form submition from jsp or html */
		 @POST
		 @Path("/book/form")
		 @Produces(MediaType.TEXT_PLAIN)
		 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		 public String formData(MultivaluedMap<String, String> formData){
			 System.out.println("inside forData Method");
			 StringBuffer sb = null;
			 sb = new StringBuffer();
			 for(String key : formData.keySet()){
				 System.out.println("key   :"+key+"   and Value  :   "+ formData.getFirst(key));
				 String data = "key   :"+key+"   and Value  :   "+ formData.getFirst(key);
				 sb.append(data);
			 }
			 return sb.toString();
			 
		 }
		 
		 /*This is for taking File(MultiPartData)as input to our Resource and retuning byte[] as Return type*/
		 @POST
		 @Path("/upload/{authorName}/{title}")
		 @Produces(MediaType.TEXT_PLAIN)
		 @Consumes(MediaType.MULTIPART_FORM_DATA)
		 public byte[] bookUpload(@PathParam("authorName")String authorName ,@QueryParam("description")String description ,@PathParam("title")String title ,byte[] shortnte ,File file) throws IOException{
			 System.out.println("inside upload file method");
			 StringBuffer sb = null;
			 int c =0;
			 sb = new StringBuffer();
			 InputStream inputStream = null;
			 try{
			 inputStream = new FileInputStream(file);
			 while((c = inputStream.read())!= -1){
				 System.out.println("inside while loop");
				 sb.append((char)c);
			 }
			 sb.append("   ,description :  ").append(description).append("  ,  title  :  ").append(title).append(" ,    authorName   :   ").append(authorName).append("  ,   bodyContent  :   ");
			 for(byte data :shortnte ){
				 System.out.println("inside foreach loop");
				 sb.append((char)data);
			 }
			 }finally{
				 inputStream.close();
			 }
			 return sb.toString().getBytes();
		 }
		 
		 /*This is for taking byte[] and some path parameters and Returning StreamingOutput*/
		 
		 @PUT
		 @Path("chapter/{isbn}/{chpterDetails}")
		 public StreamingOutput updateBook(@PathParam("isbn")String isbn ,@PathParam("chpterDetails")String chpterDetails ,byte[]  bookContent){
			 System.out.println("inside updateBook method");
			 StringBuffer sb = null;
			 sb = new StringBuffer();
			 for(byte content : bookContent){
				 System.out.println("inside foreach loop");
				 sb.append((char)content);
			 }
			 sb.append(" ,   isbn :  ").append(isbn).append("  ,  chpterDetails  :  ").append(chpterDetails);
			 return new BookStreamingOutput(sb.toString());
		 }
		 private final class BookStreamingOutput implements StreamingOutput{
			 private String  content;
			 public BookStreamingOutput(String  content) {
				 System.out.println("inside the constructor of StreamingOutput class");
				 this.content = content;
			}
				@Override
				public void write(OutputStream outputStream) throws IOException, WebApplicationException {
	                				System.out.println("inside the writee method");
	                				outputStream.write(content.getBytes());
				}
			}
}
