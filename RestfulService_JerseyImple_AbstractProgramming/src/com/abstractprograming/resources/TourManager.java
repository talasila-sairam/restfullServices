package com.abstractprograming.resources;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.abstractprograming.dto.NewPackage;
import com.abstractprograming.dto.PackageInfo;

import javafx.util.BuilderFactory;

public abstract class TourManager {
	
@PUT
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
public byte[] updatePackage(InputStream in) {
	PackageInfo packageInfo = null;
	NewPackage newPackage = null;
	newPackage = readAndConvert(in);
	
  //Put the Data into Packageinfo Object and send as part of response
	packageInfo = new PackageInfo();
	packageInfo.setAmount("1230");
	packageInfo.setName(newPackage.getName());
	packageInfo.setStatus("sucess");
	packageInfo.setPackageName(newPackage.getPackageName());
	
	//Send the response after processing the request
	
	StringBuffer stringBuffer = new StringBuffer();
	stringBuffer.append("<package-info>").append("<package-name>").append(packageInfo.getPackageName()).append("</package-name>").append("<name>").append(packageInfo.getName()).append("</name>").append("<amount>").append(packageInfo.getAmount()).append("<amount>").append("<status>").append(packageInfo.getStatus()).append("</status>");
	return stringBuffer.toString().getBytes();
}

public abstract NewPackage readAndConvert(InputStream in);
}
