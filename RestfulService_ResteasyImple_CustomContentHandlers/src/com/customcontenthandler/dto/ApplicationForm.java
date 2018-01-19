package com.customcontenthandler.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="application-form")
public class ApplicationForm {
	@Override
	public String toString() {
		return "ApplicationForm [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", mobileNo=" + mobileNo + ", pincode=" + pincode + "]";
	}
	public ApplicationForm() {
		System.out.println("inside ApplicationForm class constructor");
	}
  @XmlElement(name="first-name")
  private String firstName;
  @XmlElement(name="last-name")
  private String lastName;
  @XmlElement
  private String address;
  @XmlElement(name="mobile-no")
  private String mobileNo;
  @XmlElement
  private int pincode;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
  
}
