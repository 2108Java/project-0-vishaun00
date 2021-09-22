package DAOIMPL;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Constructor.Item;
import DAOInterface.ItemDataBaseDAO;

class ItemDataBaseDAOIMPLTest {

	@Test
	void test() {
		class ItemDataBaseDAOIMPL implements ItemDataBaseDAO {

		public Item[] selectAllAccounts() {
			String server ="localhost";
			String username="postgres";
			String password = "PorkChop@00";
			String url="jdbc:postgresql://" + server + "/postgres";
			Item [] array = new Item[10];
			try {
				Connection connection = DriverManager.getConnection(url, username, password);
				String sql = "Select * from bankAccount";
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();// we expect something back, ps.setInt for insert
				int i =0;
				while(rs.next()) {
					array[i] = new Item(rs.getInt("accountid"),
							rs.getString("fullName"),
							rs.getString("accountType"),// be more consistent 
							rs.getBoolean("Approved"), 
							rs.getInt("deposit"),
							rs.getInt("withdraw"),
							rs.getInt("balance"),
							rs.getBoolean("requestJointAccount"),
							rs.getBoolean("approveJoint"));// change to balance, was withdraw
							
					i++;
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			return array;
		}

		@Override
		public boolean insert(Item newItem) {
			// TODO Auto-generated method stub
			return false;
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
		public boolean updateDeposit(int accountid, int deposit) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean updateWithdraw(int accountid, int deposit, boolean approved) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean updateWithdraw1(int accountid, int deposit, int withdraw, boolean approved) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean requestUpdate(int accountid) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean joinAccount(int accountid) {
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
		public boolean UpdateWithdraw(int acountid, int deposit) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean UpdateWithdraw2(int acountid, int withdraw) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean aNewDeposit(int accountid, int deposit, boolean approved) {
			// TODO Auto-generated method stub
			return false;
		}
	}

}
}
