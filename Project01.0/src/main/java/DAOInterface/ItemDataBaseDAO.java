package DAOInterface;

import Constructor.Item;

public interface ItemDataBaseDAO {

	Item[] selectAllAccounts ();

	boolean insert(Item newItem);

	boolean update(int accountid);

	boolean delete(int accountid);

	boolean updateDeposit(int accountid, int deposit, boolean approved);

	boolean updateWithdraw(int accountid, int deposit, boolean approved);
	boolean updateWithdraw1(int accountid, int withdraw,  boolean approved);

	boolean requestUpdate(int accountid);

	Item[] joinAccount1(Item newItem);
	boolean joinAccount(int accountid);


}
