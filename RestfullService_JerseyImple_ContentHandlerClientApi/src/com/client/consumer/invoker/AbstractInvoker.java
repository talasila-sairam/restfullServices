package com.client.consumer.invoker;

import java.net.URI;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public abstract class AbstractInvoker {
	WebTarget target = null;
	public static void main(String[] args) {
		URI uri = ClientBuilder.newClient().target("").getUri();
		
	}
			
}
