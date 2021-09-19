package com.presentation;

import java.util.Random;
import java.util.Scanner;

import Constructor.Item;
import Service.canDo;

public class MenuV1 implements Menu{
	canDo service;
	public MenuV1(canDo service) {
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

	}
	
public void prettyDisplay(Item[] array) {
	for(int i =0;i<array.length;i++) {
		if(array[i]!= null ) {
			System.out.println(array[i].getAccountID());
			System.out.println(array[i].getName());
			System.out.println(array[i].getAccount());
			System.out.println(array[i].isApproved());
			System.out.println(array[i].getDeposit());
			//System.out.println(array[i].getWithdraw());
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
			//int accountid = rand.nextInt(10000);
			Item newItem = new Item(fullName,accounttype,false, 0, 0, false);
			//make sure to update the ACCOUNTID to serial in the database
			//passes over
			//responsibility to the service
			//service.create(newItem);// creates the account
			if(service.create(newItem)) {
				System.out.println("Successfully created");
			}else {
				System.out.println("Nay, nothing created");
			}
			
			break;
	case"2":System.out.println("Approve an account");
		System.out.println("Enter the account number");
		int accountid1 = input.nextInt();
		//service.update(accountid);//establishing a contract
		boolean success =service.update(accountid1);
		if(success) {
			System.out.println("Approved");
		}else {
			System.out.println("Nay, get better creds");
		}
		//WORKS
		break;
	case"3": Item [] myObject = service.viewAccount();
				prettyDisplay(myObject);
				break;
	case"4":System.out.println("Enter you account number");
			int accountid2  = input.nextInt();
			boolean success1 = service.delete(accountid2);
		if(success1) {
			System.out.println("Begone Flame of Udun");
		}else {
			System.out.println("SALTED PORK");
		}
		break;
	case"5": boolean Approve = service.Approved;
			System.out.println("What is your account number?");
			int accountid3 = input.nextInt();
			System.out.println("How much would you like to deposit");
			int deposit = input.nextInt();
			service.deposit(accountid3, deposit,Approve);
			boolean success2 = service.deposit(accountid3, deposit,Approve);
			if(success2 && Approve == true) {
				System.out.println("Success");
		
			}else {
				System.out.println("Nay, got no rent money");
			}
			break;
	case"6":	

			 boolean Approve1 = service.Approved;
			 // my attempt to get approval from employee first before customer can deposit, withdraw
			System.out.println("What is you account number?");
			int accountid4 = input.nextInt();
			System.out.println("How much would you like to withdraw?");
			int deposit_withdraw = input.nextInt();
			service.withdraw(accountid4, deposit_withdraw,Approve1);
			boolean success4 = 	service.withdraw(accountid4, deposit_withdraw,Approve1);
			if(success4 &&Approve1 ==true && deposit_withdraw<0) {
				System.out.println("You have withdrawn: " + deposit_withdraw);
		} else {
				System.out.println("nay you got no money");
		}
			break;
			
	case"8":System.out.println("Approving a joint account");	
			
			System.out.println("What is you accountid");
			int accountid5 = input.nextInt();
			boolean success5 =	service.approveJointAccount(accountid5);
				if(success5) {
					System.out.println("Your application was submitted");
				}else {
					System.out.println("denied");
				}
				break;
		
	case"9":System.out.println("combining accounts");
	System.out.println("Enter your accoutID");
	int accountIDJoin = input.nextInt();
			service.joinAccounts(accountIDJoin);
		// test out if this works
	case"10":System.out.println("Bye bye");
			running = false;
			break;
	default:System.out.println("Try again");
			

	}
	}

}
}
