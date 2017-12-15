package com.tourpackage.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

public class TourPackageApplicationStreamingOutput implements StreamingOutput{
	
	public String name;
	public TourPackageApplicationStreamingOutput(String name) {
		this.name= name;
		System.out.println("inside the TourPackageApplicationStreamingOutput constructor");
	}

	@Override
	public void write(OutputStream outPutStream) throws IOException, WebApplicationException {
		System.out.println("inside the OutPutStream Writer class");
		  
		    /*FileInputStream fin = new FileInputStream("C:\\Users\\t05053\\Downloads\\appstek.jpg");    
		    BufferedInputStream bin = new BufferedInputStream(fin);  
		    BufferedOutputStream bout = new BufferedOutputStream(outPutStream);  
		    int ch =0; ;  
		    while((ch=bin.read())!=-1)  
		    {  
		    bout.write(ch);  
		    }    
		    bin.close();  
		    fin.close();  
		    bout.close();  
		    outPutStream.close();*/  
		
		      File file = new File("C:\\Users\\t05053\\Downloads\\appstek.jpg");
		      byte[] buffer = new byte[(int)file.length()];
		      FileInputStream in = new FileInputStream(file);
		      byte[] buf = new byte[1024];
		      int count = 0;
		      while ((count = in.read(buf)) >= 0) {
		    	  outPutStream.write(buf, 0, count);
		      }
		      outPutStream.close();
		      in.close();
	    System.out.println("end of this method");
	}
}
