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

@Path("/tour")
public class TourManager {
	
	@POST
	@Path("/package1")
	@Produces("image/jpeg")
	public StreamingOutput bookPackage1(InputStream inputStream){
		System.out.println("inside the bookPackage method");
		return new TourPackageApplicationStreamingOutput("xyz");
	}
	
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
