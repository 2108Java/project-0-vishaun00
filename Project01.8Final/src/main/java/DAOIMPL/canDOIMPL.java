package DAOIMPL;

import Constructor.Item;
import DAOInterface.ItemDataBaseDAO;
import Service.canDo;

public class canDOIMPL implements canDo {
//need a database
	ItemDataBaseDAO database;
	public canDOIMPL(ItemDataBaseDAO database) {
		this.database=database;//connected to item database
	}
	@Override
	public boolean create(Item newItem) {
				return database.insert(newItem);
		
	}

	@Override
	public Item[] viewAccount() {
		
		return  database.selectAllAccounts();
	}

	@Override
	public boolean update(int accountid) {
		return database.update(accountid);
	}

	@Override
	public boolean delete(int accountid) {
			return database.delete(accountid);
	}


	@Override
	public boolean deposit(int accountid, int deposit) {
		return database.updateDeposit(accountid,deposit);
	}

	@Override
	public boolean withdrawOriginal(int accountid,int withdraw, boolean Approved) {
		return database.updateWithdraw(accountid,withdraw,Approved);
	}
	@Override
	public boolean approveJointAccount(int accountid) {
		return database.requestUpdate(accountid);
	}
	
	@Override
	public boolean joinAccounts(int accountid) {
		return database.joinAccount(accountid);
	}
	@Override
	public Item[] viewMyAccount(int accountid) {
		return database.viewMyAccount(accountid);
	}
	@Override
	public Item[] viewMyAccount1(Item newItem) {
		return database.viewMyAccount1(newItem);
	}
	//@Override
	//public boolean withdraw10(int acountid, int deposit) {
		//return database.UpdateWithdraw(acountid,  deposit);
	//}
	//@Override
	//public boolean withdraw(int acountid, int deposit, boolean Approved) {
		//// TODO Auto-generated method stub
		//return false;
	//}
	@Override
	public boolean withdraw1(int acountid, int deposit, int withdraw, boolean Approved) {
		return false;
	}
	@Override
	public boolean withdraw2(int acountid, int withdraw) {
		return database.UpdateWithdraw2(acountid, withdraw);
	}
	@Override
	public boolean deposit(int accountid, int deposit, boolean Approved) {
			return database.aNewDeposit(accountid,deposit,Approved);
		
	}
	


}
