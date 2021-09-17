package com.firstProject.DummyDataBase;

import com.firstProject.Constructor;

public class dummyDataBase {
private Constructor [] ConstructorItem = new Constructor[10];

public boolean delete(int accountNumber) {
	boolean success = false;
	for(int i =0; i<ConstructorItem.length;i++) {
		if(ConstructorItem[i]!= null) {
		if(ConstructorItem[i].getAccountID() == accountNumber) {
				ConstructorItem[i]= null;
				success = true;
		}
	}
	}
	return success;

}
public boolean create(Constructor Account) {
	boolean success= false;
	for(int i =0; i<ConstructorItem.length;i++) {
		if(ConstructorItem[i] == null) {
			 ConstructorItem[i] = Account;
			 success = true;
			 break;
		}
	}
	return success;
	
}
public boolean update(int accountNumber) {
	boolean success = false;
	for(int i =0; i<ConstructorItem.length;i++) {
		if(ConstructorItem[i]!= null && accountNumber == ConstructorItem[i].getAccountID()) {
			ConstructorItem[i].setIsComplete(true);;
			success = true;
			// may be used to APPROVE customer account
		}
	}
	return success;
}
public Constructor [] viewAccount() {
	return this.ConstructorItem;
	
}
public boolean Deposit(int accountNumber, double deposit) {
	boolean success = false;
	for(int i =0; i<ConstructorItem.length;i++) {
		if(ConstructorItem[i]!= null && accountNumber == ConstructorItem[i].getAccountID()) {
			 ConstructorItem[i].setDeposit(deposit );
			
			success= true;
		}
	}
	return success;
	//works fine
}
public boolean Withdraw(int accountNumber,double deposit,double balance) {
	boolean success = false;
	Constructor [] withdrawArray = new Constructor[10];
	for(int i =0;i<ConstructorItem.length;i++) {
		if(ConstructorItem[i]!= null  && accountNumber== ConstructorItem[i].getAccountID()) {
			ConstructorItem[i].setDeposit(balance- deposit);
			
			success= true;
			break;
			// hmmm it just replaced the  deposit value
		}
	}
	return success;
}
public boolean verifyStatus(String status) {
	for(int i =0; i<ConstructorItem.length;i++) {
		if(ConstructorItem[i].getStatus()==status) {
			ConstructorItem[i].setStatus(status);
		}
	}
	return false;
	
}
public boolean ApproveApplication(int accountNumber) {
	boolean success = false;
	for(int i =0; i<ConstructorItem.length;i++) {
		if(ConstructorItem[i]!= null && accountNumber == ConstructorItem[i].getAccountID()) {
			ConstructorItem[i].setIsComplete(true);;
			success = true;
			// may be used to APPROVE customer account
		}
	}
	return success;
}
public Constructor [] createWithRestrictions(Constructor Account) {
	boolean success= false;
	for(int i =0; i<ConstructorItem.length;i++) {
		if(ConstructorItem[i] != null) {
			if(ConstructorItem[i].setIsCompleteForApproval(false)) {
				ConstructorItem[i] = null;
				System.out.println("You do not have approval");
				break;
			}
				 //SOMEWHAT WORKS, must test in the menu class
			}
			
		}
	
	return ConstructorItem;
	
}
public Constructor [] GetIncompletedApplications() {
	Constructor[] IncompletedArray = new Constructor[10];
	for(int i =0; i<ConstructorItem.length;i++) {
		if(ConstructorItem[i].getIsComplete()== false &&  ConstructorItem[i] == null) {
			IncompletedArray[i]= ConstructorItem[i];
			break;
		}
	}
	return IncompletedArray;
	//for employee to get UNAPPROVED APPLICATIONS
}
public Constructor[]  getDeposit(double deposit) {
	boolean success= false;
	for(int i =0;i<ConstructorItem.length;i++) {
		if(ConstructorItem[i] != null) {
		if(ConstructorItem[i].getDeposit()== deposit) {
			 ConstructorItem[i].setDeposit(deposit);
			 success = true;
			 //no dice
		}
	}
	}
	return ConstructorItem;
}
public boolean modifiedWithdraw(int accountNumber,double balance) {
	boolean success = false;
	for(int i =0;i<ConstructorItem.length;i++) {
		if(ConstructorItem[i]!= null  && accountNumber== ConstructorItem[i].getAccountID()) {
			ConstructorItem[i].getBalance();
			success= true;
			break;
			//NO DICE
		}
	}
	return success;
}


public boolean WithdrawNew(int accountNumber,double deposit,double balance) {
	boolean success = false;
	for(int i =0;i<ConstructorItem.length;i++) {
		if(ConstructorItem[i]!= null  && accountNumber== ConstructorItem[i].getAccountID()) {
			ConstructorItem[i].getDeposit();
			deposit = deposit - balance;
			success= true;
			break;
			//NO DICE
		}
	}
	return success;
}
public boolean WITHDRAWOMG(int accountNumber,double withdraw) {
boolean success = false;

Constructor [] withdrawArray = new Constructor[10];
for(int i =0;i<ConstructorItem.length;i++) {
	if(ConstructorItem[i]!= null  && accountNumber== ConstructorItem[i].getAccountID()) {
		withdraw = ConstructorItem[i].getBalance();
		success= true;
		break;
		// NO DICE
		
	}
}
return success;
}
}
