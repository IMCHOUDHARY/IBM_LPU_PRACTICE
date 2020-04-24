package com.example.demo.dto;


public class AccountDTO {
	private String accountID;
	private String accountType;
	private double balance;
	public AccountDTO(String accountID, String accountType, double balance) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.balance = balance;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountDTO [accountID=" + accountID + ", accountType=" + accountType + ", balance=" + balance + "]";
	}

}
