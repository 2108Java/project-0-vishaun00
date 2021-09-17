package com.firstProject;

import java.util.Random;

public class Constructor {
	
private int accountID;
private double deposit;
private double balance;           
private String firstName;
private String lastName;
private String accountType;
private String status;// verifying if they are employee or customer
private boolean isComplete;


public Constructor( int accountID,String firstName, String lastName,String accountType,boolean isComplete,double deposit) {
	this.accountID= accountID;
	this.firstName = firstName;
	this.lastName= lastName;
	this.setAccountType(accountType);
	this.isComplete= isComplete;
	this.deposit= deposit;
	
}


//public Constructor( int accountID,String firstName, String lastName,String status,double deposit) {
	//this.accountID= accountID;
	//this.firstName = firstName;
	//this.lastName= lastName;
	//this.status= status;
	//this.deposit= deposit ;
//}
public Constructor( int accountID,String firstName, String lastName) {
	this.accountID= accountID;
	this.firstName = firstName;
	this.lastName= lastName;
}
public Constructor(double deposit) {
	this.deposit=deposit;
}
public Constructor(int accountID,double deposit,double balance) {

	this.deposit=deposit-balance;
}
public Constructor(int accountID,double deposit) {

	this.deposit=deposit;
}
public Constructor() {
	
}
public int getAccountID() {
	return accountID;
}
public void setAccountID(int accountID) {
	this.accountID = accountID;
}
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
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public boolean getIsComplete() {
	return isComplete;
}
public void setIsComplete(boolean isComplete) {
	this.isComplete = isComplete;
}
public boolean setIsCompleteForApproval(boolean isComplete) {
	return this.isComplete = isComplete;
}
public double getDeposit() {
	return deposit;
}
public void setDeposit(double deposit) {
	this.deposit = deposit;
	
}
public double getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
	
	
}
