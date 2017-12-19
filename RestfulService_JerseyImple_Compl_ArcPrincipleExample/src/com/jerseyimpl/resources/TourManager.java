package com.jerseyimpl.resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jerseyimpl.common.TourPackageDetailsStreamingOutput;
import com.tourdetails.dto.NewPackage;

@Path("/tour")
public class TourManager {
	
   private Map<String , Object> tourPackageDetails;
	public TourManager() {
		System.out.println("inside the constructor");
		tourPackageDetails = new ConcurrentHashMap<String, Object>();
	}
	
	@SuppressWarnings("finally")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput createPackage(InputStream inputStream) {
		NewPackage newPackage = null;;
		System.out.println("inside the POST method");
		try {
			newPackage= createNewPackage(inputStream);
			String orderId = UUID.randomUUID().toString();
			newPackage.setOrderId(orderId);
			newPackage.setStatus("Package HasBeen Approved");
			
			tourPackageDetails.put(orderId,newPackage);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("just before returning Streaming Output Object  "+tourPackageDetails);
			return new TourPackageDetailsStreamingOutput(newPackage);	
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput updatePackage(InputStream inputStream) {
		System.out.println("inside the PUT Method");
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput cancelPackage(@QueryParam("orderId") String orderId) {
		System.out.println("inside the GET Method");
		NewPackage newPackage = (NewPackage)tourPackageDetails.get(orderId);
		
		return new TourPackageDetailsStreamingOutput(newPackage);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getPackageDetails(InputStream inputStream) {
		System.out.println("inside the DELETE Method");
		return null;
	}
	
	private NewPackage createNewPackage(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {

		NewPackage newPackage = null;
		DocumentBuilderFactory documentBuilderFactory = null;
		DocumentBuilder documentBuilder = null;
		Document document = null;
		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilder = documentBuilderFactory.newDocumentBuilder();
		document = documentBuilder.parse(inputStream);
		NodeList nodeList = document.getFirstChild().getChildNodes();
		newPackage = new NewPackage();
		for(int i=0;i<nodeList.getLength();i++) {
			Node node = nodeList.item(i);
			System.out.println("Node Name is  "+node.getNodeName() +"and value is  "+node.getTextContent());
			if(node.getNodeName().equalsIgnoreCase("name")) {
				newPackage.setName(node.getTextContent());
			}else if(node.getNodeName().equalsIgnoreCase("email")) {
				newPackage.setEmail(node.getTextContent());
			}else if(node.getNodeName().equalsIgnoreCase("mobile")) {
				newPackage.setMobile(node.getTextContent());
			}else if(node.getNodeName().equalsIgnoreCase("members")) {
				newPackage.setMembers(Integer.parseInt(node.getTextContent()));
			}
		}
		System.out.println("after returning");
		return newPackage;
	}
}
