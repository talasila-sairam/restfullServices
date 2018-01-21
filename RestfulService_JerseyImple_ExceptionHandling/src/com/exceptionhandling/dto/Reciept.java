package com.exceptionhandling.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="reciept")
public class Reciept {
  public Reciept() {
	  System.out.println("inside reciept class constructor");
}
  protected String accountNo;
  protected double remaingBalance;
  protected String status;
public String getAccountNo() {
	return accountNo;
}
public void setAccountNo(String accountNo) {
	this.accountNo = accountNo;
}
public double getRemaingBalance() {
	return remaingBalance;
}
public void setRemaingBalance(double remaingBalance) {
	this.remaingBalance = remaingBalance;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
