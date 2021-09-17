package com.firstProject.MainDriver;

import com.firstProject.Constructor;
import com.firstProject.DummyDataBase.ConstructorDAO;
import com.firstProject.DummyDataBase.ConstructorDAOImpl;

public class DAOTEst {
	
	public static void prettyDisplay(Constructor [] array) {
		for(int i =0;i<array.length;i++) {
			if(array[i]!= null) {
				System.out.println(array[0].getAccountID());
				System.out.println(array[0].getFirstName());
				System.out.println(array[0].getLastName());
				System.out.println(array[0].getAccountType());

				System.out.println(array[0].getIsComplete());
				System.out.println(array[0].getBalance());
				System.out.println("");
			}
		}
	}
	
	public static void prettyDisplay2(Constructor [] array) {
		for(int i =0;i<array.length;i++) {
			if(array[i]!= null) {
				System.out.println(array[0].getAccountID());
				
			}
		}
	}
public static void main(String[] args) {
	ConstructorDAO database = new ConstructorDAOImpl();
	//Constructor [] myTable = database.SelectAllCompletedAccounts();
	//database.SelectAllCompletedAccounts();
	//database.insert(new Constructor(3,"Caleb","City","savings",false,100));
	//^^ works
	//prettyDisplay(myTable);
	//database.delete(1);
	//^^ this works WOWOWOWOWOW
	
	//database.delete("Caleb", "City");
	//^^ this WORKS OMG
 //database.SelectByAccountID(1);
//^^ this does not work for ????
 database.SelectByAccountID(2);
 Constructor [] a = database.SelectByAccountID(2);
 //System.out.println(a);
 prettyDisplay(a);
 //^^ this workds for selecting account by id
 //prettyDisplay2(a);
 //^^ this just return the accountID
 
database.Update(new Constructor(1,"sacka","lacka","checking",false,50));
}
}