package com.presentation;

import java.util.Random;
import java.util.Scanner;

import com.main.MainDriver;

import Constructor.Item;
import Service.canDo;

public class DisplayCustomer implements Menu {
	canDo service;
	public DisplayCustomer(canDo service) {
		this.service= service;
	}
	public static void options() {
		System.out.println("1) Create Account");
		System.out.println("2) View Account");	
		System.out.println("3) Deposit Money");
		System.out.println("4) Withdraw Money");
		System.out.println("5) Request joint account");
		System.out.println("6) Back ");



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
			System.out.println(array[i].getBalance());
			System.out.println(array[i].isRequestJointAccount());
			System.out.println(array[i].isApproveJoint());



		}
	}
}
public void displayCustomer() {
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
				System.out.println("Nay, nothing created");
			}
			System.out.println("Your account number is: " + accountid);
			break;

	case"2": System.out.println("Viewing specific accounts by ID");
			int accountid9 = input.nextInt();
			service.viewMyAccount(accountid9);
			prettyDisplay(service.viewMyAccount(accountid9));
			break;

	case"3": 	 boolean Approve = service.Approved;
				System.out.println("What is your account number?");
				int accountid3 = rand.nextInt();
				System.out.println("How much would you like to deposit");
				int deposit = input.nextInt();
				service.deposit(accountid3, deposit,Approve);
				boolean success2 = service.deposit(accountid3, deposit,Approve);
				System.out.println("Your account number is: "+accountid3);
				if(success2 && Approve == true) {
					System.out.println("Success");

					}else {
					System.out.println("You are not Approved!");
					}
					break;
	case"4":	

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
		
		
	case"5":System.out.println("What is you account id?");
			int accountid5= input.nextInt();
			service.viewMyAccount(accountid5);
			prettyDisplay(service.viewMyAccount(accountid5));
	case"6":System.out.println("Going back to previous options");
			MainDriver drive = new MainDriver();
			drive.main(null);
			break;
	default:System.out.println("Pick another option!");
			running = false;
			break;

	}
	}

}
@Override
public void display() {
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