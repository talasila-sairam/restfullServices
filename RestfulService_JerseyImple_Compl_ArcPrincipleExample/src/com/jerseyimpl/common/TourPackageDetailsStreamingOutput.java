package com.jerseyimpl.common;
import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import com.tourdetails.dto.NewPackage;

public class TourPackageDetailsStreamingOutput implements StreamingOutput {

	NewPackage newPackage;
	public TourPackageDetailsStreamingOutput(NewPackage newPackage){
		this.newPackage = newPackage;
	}
	@Override
	public void write(OutputStream output) throws IOException, WebApplicationException {
		StringBuffer stringBuffer = null;
		stringBuffer = new StringBuffer();
		stringBuffer = stringBuffer.append("<Package-Details>").append("<orderId>").append(newPackage.getOrderId()).append("</orderId>").append("<name>").append(newPackage.getName()).append("</name>").append("<email>").append(newPackage.getEmail()).append("</email>").append("<mobile>").append(newPackage.getMobile()).append("</mobile>").append("<members>").append(newPackage.getMembers()).append("</members>").append("<status>").append(newPackage.getStatus()).append("</status>");
		byte[] byteArr = stringBuffer.toString().getBytes();
		output.write(byteArr);
		output.flush();
		System.out.println("after writing the output to Member");
	}

}
