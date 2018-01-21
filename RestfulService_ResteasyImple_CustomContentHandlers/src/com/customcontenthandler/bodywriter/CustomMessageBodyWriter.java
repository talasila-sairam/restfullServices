package com.customcontenthandler.bodywriter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.customcontenthandler.dto.ApplicationStatus;

/*Without these classes also it wil work rest easy inteernally provides it
 * 
 * @Provider
@Produces("application/xml")*/
public class CustomMessageBodyWriter implements MessageBodyWriter<ApplicationStatus> {
	
	public CustomMessageBodyWriter() {
		System.out.println("inside CustomMessageBodyWriter constructor");
	}

	@Override
	public boolean isWriteable(Class<?> classType, Type type, Annotation[] annotation, MediaType mediaType) {
		System.out.println("inside isWriteable method ");
		return classType.isAssignableFrom(ApplicationStatus.class);
	}
	
	@Override
	public long getSize(ApplicationStatus applicationStatus, Class<?> classType, Type type, Annotation[] annotation, MediaType mediaType) {
		System.out.println("inside getSize method");
		return -1;
	}
	@Override
	public void writeTo(ApplicationStatus applicationStatus, Class<?> classType, Type type, Annotation[] annotation, MediaType mediaType,
			MultivaluedMap<String, Object> multuValuedMap, OutputStream outPutStream) throws IOException, WebApplicationException {
		System.out.println("inside writeTo method ");
		try {
		JAXBContext context = JAXBContext.newInstance(ApplicationStatus.class);
		Marshaller marshller = context.createMarshaller();
		marshller.marshal(applicationStatus, outPutStream);
		}catch (Exception e) {
			System.out.println("inside catch block");
		}
	}

}
