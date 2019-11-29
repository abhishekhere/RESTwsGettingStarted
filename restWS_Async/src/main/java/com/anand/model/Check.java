package com.anand.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Check {

	private String checkNo;
	private String accountNo;
	private double amount;
	
	public String getCheckNo() {
		return checkNo;
	}
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
