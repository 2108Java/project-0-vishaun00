package Constructor;

public class Item {
private int accountID;

private String name;
private String account;
private boolean requestJointAccount;
private boolean Approved = false;

private int deposit;
private int withdraw;
public int getDeposit() {
	return deposit;
}
public void setDeposit(int deposit) {
	this.deposit = deposit;
}
public int getWithdraw() {
	return withdraw;
}
public void setWithdraw(int withdraw) {
	this.withdraw = withdraw;
}

public int getAccountID() {
	return accountID;
}
public void setAccountID(int accountID) {
	this.accountID = accountID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public boolean isApproved() {
	return Approved;
}
public void setApproved(boolean Approved) {
	this.Approved = Approved;
}
public Item(int accountID, String name, String account, boolean Approved) {

	this.accountID = accountID;
	this.name = name;
	this.account = account;
	this.Approved = Approved;
}
public Item(int accountID, String name, String account, boolean approved, int deposit, int withdraw, boolean requestJointAccount) {

	this.accountID = accountID;
	this.name = name;
	this.account = account;
	Approved = approved;
	this.deposit = deposit;
	this.withdraw = withdraw;
	this.requestJointAccount= requestJointAccount;
}
public boolean isRequestJointAccount() {
	return requestJointAccount;
}
public void setRequestJointAccount(boolean requestJointAccount) {
	this.requestJointAccount = requestJointAccount;
}
public Item(String name, String account, boolean approved, int deposit, int withdraw, boolean requestJointAccount) {

	
	this.name = name;
	this.account = account;
	Approved = approved;
	this.deposit = deposit;
	this.withdraw = withdraw;
	this.requestJointAccount= requestJointAccount;
}
}


