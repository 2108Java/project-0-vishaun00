package com.firstProject.MainDriver;

import java.util.Scanner;

import com.firstProject.Constructor;
import com.firstProject.DummyDataBase.dummyDataBase;
import com.firstProject.myService.service;

public class TestingMenu {
	
	public static void prettyDisplay(Constructor [] array) {
		for(int i=0; i<array.length;i++) {
			if(array[i]!= null) {
			System.out.println(array[i].getAccountID());
			System.out.println(array[i].getFirstName());
			System.out.println(array[i].getLastName());
			System.out.println(array[i].getDeposit());
			System.out.println(array[i].getIsComplete());
			System.out.println("");
		}
		}
		
	}
//public static void main(String[] args) {
	
	//Constructor item = new Constructor(1,"sam","roberts","customer",false,depos);
	//Constructor item2 = new Constructor(2,"Clam","Chowder","customer",1000);
	//int balance = 100;
	//Scanner dep = new Scanner(System.in);
	//System.out.println("Enter a number");
	//double depos = dep.nextDouble();
	//Constructor deposit= new Constructor(depos);
	//Constructor item = new Constructor(1,"sam","roberts","customer",false,depos);

	//dummyDataBase dataBase = new dummyDataBase();
	//dataBase.create(item);
	//dataBase.createWithRestrictions(item);
	//Constructor[] tempArray = dataBase.viewAccount();
	//dataBase.update(1);// could be used to approve customer Accounts
	//dataBase.delete(1);//works!!!
	//dataBase.create(item2);
	//dataBase.Deposit(2, 100);// also works
	
	//prettyDisplay(tempArray );
	//dataBase.Withdraw(2, depos, balance);// maybe this works.....maybe
	//needs to manually set the deposit
	//works with a scanner
	// how to deal with negative withdrawals? try and catch blocks?

	//prettyDisplay(tempArray );
	//dummyDataBase testDataBase= new dummyDataBase();
	//service testService = new service(testDataBase);
	//Menu test = new Menu(testService);
	//test.dissplayMenu();
	
		
			
			//dataBase.Withdraw(2, depos, balance);
			
			//prettyDisplay(tempArray );
	//	}

		

		
	
	
//}

