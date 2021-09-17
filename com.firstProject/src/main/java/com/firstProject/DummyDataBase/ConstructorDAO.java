package com.firstProject.DummyDataBase;

import com.firstProject.Constructor;

public interface ConstructorDAO {
// data access object
	//design pattern
	//allows us to keep the database querry 
	//seperate from our java code
	//
	//create
	public boolean insert(Constructor item);
	
	public boolean delete(String firstName,String lastName);
	public boolean delete(int accountNumber);
	
	public Constructor [] selectAllAccounts();
	public Constructor [] SelectAllCompletedAccounts();
	public Constructor[] SelectAllInCompletedAccounts();
	
	
	public Constructor[] SelectByAccountID(int accountID);
	
	public boolean Update(int accountid);

	public void insert(int i, String string, String string2, String string3, boolean b, int j);

	Constructor[] Update(Constructor item);
}
