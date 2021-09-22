package DAOIMPL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Constructor.Item;
import DAOInterface.ItemDataBaseDAO;
import Service.canDo;

class canDOIMPLTest {

	@Test
	void test() {
		class canDOIMPL implements canDo {
		ItemDataBaseDAO database;
		public canDOIMPL(ItemDataBaseDAO database) {
			this.database=database;//connected to item database
		}
		@Override
		public boolean create(Item newItem) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Item[] viewAccount() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean update(int accountid) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean delete(int accountid) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean deposit(int acountid, int deposit) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean withdrawOriginal(int acountid, int deposit, boolean Approved) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean withdraw1(int acountid, int deposit, int withdraw, boolean Approved) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean withdraw2(int acountid, int withdraw) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean approveJointAccount(int accountid) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean joinAccounts(int accountid) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Item[] viewMyAccount(int accountid) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Item[] viewMyAccount1(Item newItem) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean deposit(int accountid, int deposit, boolean Approved) {
			// TODO Auto-generated method stub
			return false;
		}
	}
	}

}
