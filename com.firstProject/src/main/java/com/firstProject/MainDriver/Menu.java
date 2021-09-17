package com.firstProject.MainDriver;

import java.util.Random;
import java.util.Scanner;

import com.firstProject.Constructor;
import com.firstProject.myService.service;

public class Menu {
	service MyService;
public Menu(service MyService) {
	this.MyService= MyService;
}

public static void prettyDisplay(Constructor [] array){
	for(int i =0; i<array.length;i++) {
		if(array[i]!= null) {
			System.out.println(array[i].getAccountID());
			System.out.println(array[i].getFirstName());
			System.out.println(array[i].getLastName());
			System.out.println(array[i].getDeposit());
			System.out.println(array[i].getBalance());
			System.out.println(array[i].getIsComplete());
			System.out.println(array[i].getStatus());
			System.out.println("");



			
			
		}
	}
}
public void dissplayMenu(){
	
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	boolean running = true;
	while(running) {
		System.out.println("1) Create Account");
		System.out.println("2) Delete Account");
		System.out.println("3) Update Account");
		System.out.println("4) View Account");
		System.out.println("5) Deposit Money");
		System.out.println("6) Withdraw Money");
		String result= scan.nextLine();
		
		switch(result) {
		case"1":
			System.out.println("Enter your first name");
			String firstName = scan.nextLine();
			System.out.println("What is you last name");
			String lastName= scan.nextLine();
			int accountNumber = rand.nextInt(100);
			//randNumber(accountNumber);
			Constructor account = new Constructor( accountNumber,firstName,lastName);
			//^^^^^ works somewhat
			//MyService.createAccountWithConstraints(account);
			//^^^^^^ returns nothing, i must add a ERROR message
			MyService.createAccount(account);
			prettyDisplay(MyService.viewAccounts());
			break;
		case"2":System.out.println("what is your accounts id?");
				accountNumber = scan.nextInt();
				MyService.deleteAccount(accountNumber);
				//^^^ works but needs more polish
				prettyDisplay(MyService.viewAccounts());
				break;
		case"3":System.out.println("Updating an account");
				System.out.println("Enter the ID of the account you want updated");
				accountNumber= scan.nextInt();
				MyService.ApproveAccount(accountNumber);
				//^^^^ sets the value of  isComplete from false to true
				// soooo goood
				prettyDisplay(MyService.viewAccounts());
				break;
		case"4":System.out.println("Viewing all accounts");
				prettyDisplay(MyService.viewAccounts());
				//^^^ this also works
				break;
		case"5":System.out.println("What is you account number?");
				int accountNumber1 = scan.nextInt();
				System.out.println("How much would you like to deposit?");
				double deposit = scan.nextInt();
				//MyService.Deposit(accountNumber1, deposit);
				//MyService.getDeposit(deposit);
				//^^NO DICE
				if(deposit == deposit ) {
				//MyService.Deposit(accountNumber1, deposit);
				}
				
				//^^^ this works, money is deposited, must work of how
				//to make this more presentable
				// money also adds now
				//Does not work that well, it just doubles said amount
				prettyDisplay(MyService.viewAccounts());
				break;
		case"6":
				double balance = 0;
				System.out.println("What is your account number?");
				int accountNumber2 = scan.nextInt();
				System.out.println("");
				System.out.println("How much would you like to withdraw?");
				double withdraw = scan.nextInt();
				
				Constructor dep = new Constructor();
				
				MyService.newWithDraw(accountNumber2,withdraw);
				//MyService.Withdraw3(accountNumber2, withdraw);
				//^^^^ error
				//MyService.ModDeposit(accountNumber2, withdraw);
				//^^^ deos not work, it removes the DEPOSIT
				//MyService.WithdrawNew(accountNumber2,0, withdraw);
				// it only replaced the values,
				//must work on this, 
				//need to take out the deposit variable
				//MyService.ModDepositWithdraw(accountNumber2, item);
				//^^^ still just replaces the number
				//MyService.Withdraw(accountNumber2, 0, withdraw);
				//MyService.WithdrawNew(accountNumber2, deposit, balance);
		}
	}
}

public static void randNumber(int account) {
	Random rand = new Random();
	for(int i =0; i<rand.nextInt();i++) {
		if(rand.nextInt()!= rand.nextInt()) {
			int accountNumber = rand.nextInt();
			accountNumber = account;
		}
	}
}
}
