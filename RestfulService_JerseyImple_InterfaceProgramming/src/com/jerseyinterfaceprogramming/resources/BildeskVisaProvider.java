package com.jerseyinterfaceprogramming.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import com.jerseyinterfaceprogramming.common.interfaces.BildeskProvider;

@Path("/visa")
public class BildeskVisaProvider implements BildeskProvider {

	 public BildeskVisaProvider() {
		 System.out.println("inside the Visa class constructor");
	}
	@Override
	public StreamingOutput pay(InputStream in) {
		System.out.println("inside the Visa implementation class");
		//Insted of writing one more class writing inner class here itself
		return new StreamingOutput() {	
			@Override
			public void write(OutputStream out) throws IOException, WebApplicationException {
				StringBuilder builder = new StringBuilder();
				builder = builder.append("<transaction><tx-no>123456</tx-no><status>sucess</status><amount>1000</amount></transaction>");
				byte[] finalOutput = builder.toString().getBytes();
				out.write(finalOutput);
				System.out.println("end of the Mastero Method");
				out.close();
			}
		};
	}

}
