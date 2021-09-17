package com.firstProject.myService;

import com.firstProject.Constructor;
import com.firstProject.DummyDataBase.ConstructorDAO;
import com.firstProject.DummyDataBase.dummyDataBase;

public class service {
	ConstructorDAO data;
	public service(ConstructorDAO data) {
		this.data= data;
	}
public Constructor [] viewAccounts() {
	return this.data.selectAllAccounts();
	
}
public Constructor [] ViewUnApprovedAccounts() {
	return this.data.SelectAllInCompletedAccounts();
	
}
public int ViewAccountsByID(int accountNumber) {
	return this.data.SelectByAccountNumber(accountNumber);
	
}
public boolean deleteAccount(int accountNumber) {
	return this.data.delete(accountNumber);
	
}
public boolean createAccount(Constructor account) {
	return this.data.insert(account);
	
}
//public Constructor[] createAccountWithConstraints(Constructor account) {
	//return this.data.insert(account);
	
//}
//public boolean Deposit(int accountNumber,double deposit) {
	//return data.Deposit(accountNumber,deposit);
//}
//public boolean Withdraw(int accountNumber,double deposit,double balance) {
	//return data.Withdraw( accountNumber, 0.0, deposit - balance );
//}
public boolean ApproveAccount(int accountNumbber) {
	return data.Update(accountNumbber);
}
//public Constructor[] getDeposit(double deposit) {
	//return data.getDeposit(deposit);
//}
//public boolean ModDepositWithdraw(int accountNumber, double balance) {
	//return this.data.modifiedWithdraw(accountNumber, balance);
	
//}
//public boolean WithdrawNew(int accountNumber,double deposit,double balance) {
	//return data.WithdrawNew(accountNumber, 0.0,  deposit - balance);
//}
//public boolean Withdraw3(int accountNumber,double balance) {
	//return this.data.Withdraw3(accountNumber, balance);
//}
//public boolean newWithDraw(int accountNumber,double withdraw) {
	//return this.data.WITHDRAWOMG( accountNumber, withdraw);
//}
}
