package com.customconversion.converters;

import javax.ws.rs.ext.ParamConverter;

import com.customconversion.othresour.AirwayBillNo;

public class AwbnParameterConverter implements ParamConverter<AirwayBillNo> {
    public AwbnParameterConverter() {
	  System.out.println("inside AwbnParameterConverter constructor");   
    }
    
	@Override
	public AirwayBillNo fromString(String str) {
		AirwayBillNo awbn = null;
		if(str != null && str.length() >= 7) {
		awbn = new AirwayBillNo();
		awbn.setReferenceCode(str.substring(0, 3));
		awbn.setTracKId(str.substring(3, str.length()));
		}
		return awbn;
	}

	@Override
	public String toString(AirwayBillNo awbn) {
		System.out.println("inside toStrong method");
		return null;
	}

}
