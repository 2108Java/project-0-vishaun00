package Service;

import Constructor.Item;

public interface canDo {

	
	boolean Approved = false;
	public boolean create(Item newItem);

	public Item[] viewAccount();

	public boolean update(int accountid);// for approval of accounts

	public boolean delete(int accountid);

	public boolean deposit(int acountid,int deposit);

	public boolean withdrawOriginal(int acountid, int deposit,boolean Approved);
	public boolean withdraw1(int acountid, int deposit,int withdraw,boolean Approved);
	public boolean withdraw2(int acountid, int withdraw);

	public boolean approveJointAccount(int accountid);

	public boolean joinAccounts(int accountid);

	public Item [] viewMyAccount(int accountid);
	public Item [] viewMyAccount1(Item newItem);

	public boolean deposit(int accountid, int deposit, boolean Approved);


	
	
	
	//public boolean Approve(boolean Approved);

	//public Object getApprove(boolean Approved );


}
