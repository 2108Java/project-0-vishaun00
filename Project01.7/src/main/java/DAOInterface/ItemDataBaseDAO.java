package DAOInterface;

import Constructor.Item;

public interface ItemDataBaseDAO {

	Item[] selectAllAccounts ();

	boolean insert(Item newItem);

	boolean update(int accountid);

	boolean delete(int accountid);

	boolean updateDeposit(int accountid, int deposit);

	boolean updateWithdraw(int accountid, int deposit, boolean approved);
	boolean updateWithdraw1(int accountid,int deposit, int withdraw,  boolean approved);

	boolean requestUpdate(int accountid);

	public boolean joinAccount(int accountid);

	public Item[] viewMyAccount(int accountid);

	public Item[] viewMyAccount1(Item newItem);

	boolean UpdateWithdraw(int acountid, int deposit);

	boolean UpdateWithdraw2(int acountid, int withdraw);

	boolean aNewDeposit(int accountid, int deposit, boolean approved);

}
