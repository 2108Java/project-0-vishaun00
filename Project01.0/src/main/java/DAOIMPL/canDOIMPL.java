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
	public boolean deposit(int accountid, int deposit, boolean Approved) {
		return database.updateDeposit(accountid,deposit,Approved);
	}

	@Override
	public boolean withdraw(int accountid, int deposit, boolean Approved) {
		return database.updateWithdraw(accountid,deposit,Approved);
	}
	@Override
	public boolean approveJointAccount(int accountid) {
		return database.requestUpdate(accountid);
	}
	
	@Override
	public Item[] joinAccounts1(Item newItem) {
		return database.joinAccount1(newItem);
	}
	public boolean joinAccounts(int accountid) {
		return database.joinAccount(accountid);
	}

}
