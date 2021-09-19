package Service;

import Constructor.Item;

public interface canDo {

	
	boolean Approved = false;
	public boolean create(Item newItem);

	public Item[] viewAccount();

	public boolean update(int accountid);// for approval of accounts

	public boolean delete(int accountid);

	public boolean deposit(int acountid,int deposit,boolean Approved);

	public boolean withdraw(int acountid, int deposit,boolean Approved);
	
	public boolean approveJointAccount(int accountid);

	public Item [] joinAccounts1(Item newItem);
	public boolean joinAccounts(int accountid);



	
	
	
	//public boolean Approve(boolean Approved);

	//public Object getApprove(boolean Approved );


}
