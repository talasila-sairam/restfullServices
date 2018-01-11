package com.customconversion.othresour;

public class AirwayBillNo {
	public AirwayBillNo() {
		System.out.println("inside AirwayBillNo class constructor");
	}
   private String referenceCode;
   private String tracKId;
public String getReferenceCode() {
	return referenceCode;
}
public void setReferenceCode(String referenceCode) {
	this.referenceCode = referenceCode;
}
public String getTracKId() {
	return tracKId;
}
public void setTracKId(String tracKId) {
	this.tracKId = tracKId;
}
}
