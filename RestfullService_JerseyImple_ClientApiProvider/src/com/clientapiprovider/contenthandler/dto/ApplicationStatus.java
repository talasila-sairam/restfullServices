package com.clientapiprovider.contenthandler.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*These Xml Tags are Mandatory incase if you are converting this object into Xml Type but incase id=f you want to convert 
 * this object into JSON not required if it is there also not a problem
 * */

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="application-status")
public class ApplicationStatus {
	
	public ApplicationStatus() {
		System.out.println("inside ApplicationStatus class constructor");
	}
	
	@Override
	public String toString() {
		return "ApplicationStatus [accountNo=" + accountNo + ", status=" + status + ", balance=" + balance + ", name="
				+ name + "]";
	}

	@XmlElement(name="account-no")
  private String accountNo;
	@XmlElement
  private String status;
	@XmlElement
  private double balance;
	@XmlElement
  private String name;
	
public String getAccountNo() {
	return accountNo;
}
public void setAccountNo(String accountNo) {
	this.accountNo = accountNo;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
