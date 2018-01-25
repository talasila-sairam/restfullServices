package com.client.consumer.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="application-status")
public class AccountStatus {
    public AccountStatus() {
	   System.out.println("inside AccountStatus class constructor in ClientApi");
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
	
	@Override
	public String toString() {
		return "ApplicationStatus [accountNo=" + accountNo + ", status=" + status + ", balance=" + balance + ", name="
				+ name + "]";
	}
}
