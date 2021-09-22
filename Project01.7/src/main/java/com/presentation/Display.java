package com.presentation;

import java.util.Random;
import java.util.Scanner;

import com.main.MainDriver;

import Constructor.Item;
import Service.canDo;

public class Display implements Menu{
	canDo service;
	public Display(canDo service) {
		this.service= service;
	}
	public static void options() {
		System.out.println("1) Create Account");
		System.out.println("2) Approve an account");
		System.out.println("3) View Account");
		System.out.println("4) Delete Account");	
		System.out.println("5) Deposit Money");
		System.out.println("6) Withdraw Money");
		System.out.println("7) Request joint account");
		System.out.println("8) Approve joint account");
		System.out.println("9) View specific account");
		System.out.println("10) back");


	}
	
public void prettyDisplay(Item[] array) {
	for(int i =0;i<array.length;i++) {
		if(array[i]!= null ) {
			System.out.println(array[i].getAccountID());
			System.out.println(array[i].getName());
			System.out.println(array[i].getAccount());
			System.out.println(array[i].isApproved());
			System.out.println(array[i].getDeposit());
			System.out.println(array[i].getWithdraw());
			System.out.println(array[i]);

		}
	}
}
public void display() {
Scanner input = new Scanner(System.in);		
Random rand = new Random();
boolean running = true;
while(running) {
	options();
	String choice = input.nextLine();

	switch(choice) {
	
	case"1":System.out.println("Creating an account");
			System.out.println("Enter your full name");
			String fullName= input.nextLine();
			System.out.println("Would you like a checking or saving account?");
			String accounttype = input.nextLine();
			int accountid = rand.nextInt(10000);
			Item newItem = new Item(accountid,fullName,accounttype,false);//passes over
		
			if(service.create(newItem)) {
				System.out.println("Successfully created");
			}else {
				System.out.println("Failed to create");
			}
			
			break;
	case"2":System.out.println("Approve an account");
		System.out.println("Enter the account number");
		int accountid1 = input.nextInt();
		boolean success =service.update(accountid1);
		if(success) {
			System.out.println("Approved");
		}else {
			System.out.println("Not Approved");
		}
		break;
	case"3": Item [] myObject = service.viewAccount();
				prettyDisplay(myObject);
				break;
	case"4":System.out.println("Enter you account number");
			int accountid2  = input.nextInt();
			boolean success1 = service.delete(accountid2);
		if(success1) {
			System.out.println("Item deleted");
		}else {
			System.out.println("Failed to delete");
		}
		break;
	case"5": 
			System.out.println("What is your account number?");
			int accountid3 = input.nextInt();
			System.out.println("How much would you like to deposit");
			int deposit = input.nextInt();
			service.deposit(accountid3, deposit);
			boolean success2 = service.deposit(accountid3, deposit);
			if(success2 ) {
				System.out.println("Success");
				
			}else {
				System.out.println("Your account has not been verified!");
			}
			break;
	case"6":	

			 //boolean Approve1 = service.Approved;
			 // my attempt to get approval from employee first before customer can deposit, withdraw
			System.out.println("What is you account number?");
			int accountid4 = input.nextInt();
			System.out.println("How much would you like to withdraw?");
			int deposit_withdraw = input.nextInt();
			service.withdraw2(accountid4, deposit_withdraw);
			boolean success4 = 	service.withdraw2(accountid4,deposit_withdraw);
			if(success4 ) {
				System.out.println("You have withdrawn: " + -deposit_withdraw);
		} else {
				System.out.println("Invalid amount entered");
		}
			break;
			
	case"7":System.out.println("Approving a joint account");	
			
			System.out.println("What is your accountid");
			int accountid5 = input.nextInt();
			boolean success5 =	service.approveJointAccount(accountid5);
				if(success5 == true) {
					System.out.println("Your application was submitted");
				}else {
					System.out.println("Your application has been denied");
				}
				break;
		
	case"8":System.out.println("Approving joint accounts");
			System.out.println("Enter the customers id");
			int accountid6 = input.nextInt();

			if(service.joinAccounts(accountid6)) {
				System.out.println("Success");
			}else {
				System.out.println("Failed");
			}
			break;
		
	case"9":System.out.println("Viewing specific accounts by ID");
			int accountid9 = input.nextInt();
			service.viewMyAccount(accountid9);
			prettyDisplay(service.viewMyAccount(accountid9));
			break;
	case"10":System.out.println("Going back to previous options");
			MainDriver drive = new MainDriver();
			drive.main(null);
			break;
	default:System.out.println("Try again");
	running = false;
	break;
			

	}
	}

}
@Override
public void displayCustomer() {
	// TODO Auto-generated method stub
	
}
@Override
public void login() {
	Scanner input = new Scanner(System.in);
String user = input.nextLine();	
switch(user) {
case"1":System.out.println("CUSTOMER");
break;
case"2":System.out.println("EMPLOYEE");
}
}
}
