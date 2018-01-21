package com.customconversion.othresour;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.customconversion.converters.AwbnParameterConverter;
@Provider
public class CustomProvider implements ParamConverterProvider {
    
	public CustomProvider() {
		System.out.println("inside CustomProvider class constructor");
	}
	@Override
	public <T> ParamConverter<T> getConverter(Class<T> classType, Type arg1, Annotation[] annotations) {
		System.out.println("inside getConverter method");
		if(classType.getSimpleName().equalsIgnoreCase("AirwayBillNo")) {
			System.out.println("inside if condition");
			return (ParamConverter<T>) new AwbnParameterConverter();
		}else {
			System.out.println("inside the else condition");
		}
		return null;
	}

}
