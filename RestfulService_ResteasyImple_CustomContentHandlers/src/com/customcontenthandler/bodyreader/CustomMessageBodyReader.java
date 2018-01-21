package com.customcontenthandler.bodyreader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.customcontenthandler.dto.ApplicationForm;
import com.customcontenthandler.resources.AccountOpening;

/*Without these classes also it wil work rest easy inteernally provides it
 * @Provider
@Consumes("application/xml")*/
public class CustomMessageBodyReader implements MessageBodyReader<ApplicationForm> {
	
	public CustomMessageBodyReader() {
		System.out.println("inside CustomMessageBodyReader class constructor");
	}
	
	@Override
	public boolean isReadable(Class<?> classType, Type type, Annotation[] annotaton, MediaType mediaType) {
		System.out.println("inside isReadable method");
		return classType.isAssignableFrom(AccountOpening.class);
	}

	@Override
	public ApplicationForm readFrom(Class<ApplicationForm> classType, Type type, Annotation[] annotation, MediaType mediaType, MultivaluedMap<String, String> multiValuedMap,
			InputStream inputStream) throws IOException, WebApplicationException {
		ApplicationForm form = null;
		System.out.println("inside readFrom method");
		try {
		JAXBContext context = JAXBContext.newInstance(AccountOpening.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		form = (ApplicationForm)unmarshaller.unmarshal(inputStream);
		}catch (Exception e) {
			System.out.println("inside catch block");
		}
		return form;
	}

}
