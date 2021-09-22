package DAOIMPL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Constructor.Item;
import DAOInterface.ItemDataBaseDAO;

public class ItemDataBaseDAOIMPL implements ItemDataBaseDAO {
	String server ="localhost";
String username="postgres";
String password = "PorkChop@00";
String url="jdbc:postgresql://" + server + "/postgres";
	
	public Item[] selectAllAccounts() {
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
	boolean	success = false;
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String sql = "Insert Into bankAccount Values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,newItem.getAccountID());
			ps.setString(2, newItem.getName());
			ps.setString(3,newItem.getAccount());
			ps.setBoolean(4, false);
			ps.setDouble(5, newItem.getDeposit());
			ps.setDouble(6, newItem.getWithdraw());
			ps.setDouble(7, newItem.getBalance());
			ps.setBoolean(8,false );
			ps.setBoolean(9, false);
			ps.execute();
			success = true;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
		return success;
	}

	@Override
	public boolean update(int accountid) {
		Connection connection;
		boolean success= false;
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql= "Update bankAccount set Approved = true where accountid =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, accountid);
			ps.execute();
			success = true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
	
		return success;
	}

	@Override
	public boolean delete(int accountid) {

		Connection connection;
		boolean success= false;
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql= "Delete from bankAccounts where accountid =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, accountid);
			ps.execute();
			success = true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return success;
	}

	@Override
	public boolean updateDeposit(int accountid, int deposit) {
		boolean success = false;
try {
	Connection connection = DriverManager.getConnection(url, username, password);
	String sql="Update bankAccount \r\n"
			+ "Set deposit = ?\r\n"
			+ "where approved = true\r\n"
			+ "and accountid = ?;";
	PreparedStatement ps = connection.prepareStatement(sql);
	ps.setInt(1, deposit);
	ps.setInt(2, accountid);

	ps.execute();
	success = true;
			} catch (SQLException e) {

	e.printStackTrace();
}

return success;
	}

	@Override
	public boolean updateWithdraw(int accountid, int deposit, boolean approved) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql="Update  bankAccount\r\n"
					+ "Set deposit = deposit - ?\r\n"
					+ "Where approved = true\r\n"
					+ "And accountid =?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, deposit);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateWithdraw1(int accountid,int deposit, int withdraw, boolean approved) {
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql="Update  bankAccount\r\n"
					+ "Set deposit = deposit - ?\r\n"
					+ "Where approved = true\r\n"
					+ "And accountid =?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, deposit-withdraw);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean requestUpdate(int accountid) {
		Connection connection;
		boolean success = false;
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql="Update bankAccount Set requestJointaccount = true where accountid =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1,accountid);
			ps.execute();
			success = true;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public boolean joinAccount(int accountid) {
		Item [] array = new Item[10];

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql="update  bankaccount \r\n"
					+ "set approverjoint =true \r\n"
					+ "where requestJointaccount =true \r\n"
					+ "and accountid = ?;\r\n"
					+ "";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, accountid);
			ps.execute();
	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Item[] viewMyAccount(int accountid) {
		Item [] array = new Item[10];
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql = "Select * from bankAccount Where accountid =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, accountid);
			ResultSet rs = ps.executeQuery();
			int i =0;
			
			
			while(rs.next()) {
				array[i] = new Item(rs.getInt("accountid"),
						rs.getString("fullName"),
						rs.getString("accounttype"),
						rs.getBoolean("Approved"), 
						rs.getInt("deposit"),
						rs.getInt("withdraw"),
						rs.getInt("balance"),
						rs.getBoolean("requestJointAccount"),
						rs.getBoolean("approveJoint"));
						
				i++;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return array;
	}

	@Override
	public Item[] viewMyAccount1(Item newItem) {
		Item [] array = new Item[10];
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql = "Select * from bankAccount Where accountid =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();// we expect something back, ps.setInt for insert
			int i =0;
			while(rs.next()) {
				array[i] = new Item(rs.getInt("accountid"),
						rs.getString("fullName"),
						rs.getString("accounttype"),// be more consistent 
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
	public boolean UpdateWithdraw(int acountid, int deposit) {
		return false;
	}

	@Override
	public boolean UpdateWithdraw2(int acountid, int withdraw) {
		Connection connection;
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "Update bankAccount \r\n"
					+ "Set balance = (deposit-?) \r\n"
					+ "Where accountid = ?\r\n"
					+ "And  approved =true;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, withdraw);
			ps.setInt(2, acountid);
			ps.execute();
			//finally works 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean aNewDeposit(int accountid, int deposit, boolean approved) {
		boolean success = false;
try {
	Connection connection = DriverManager.getConnection(url, username, password);
	String sql="Update bankAccount \r\n"
			+ "Set deposit = ?\r\n"
			+ "where approved = true\r\n"
			+ "and accountid = ?;";
	PreparedStatement ps = connection.prepareStatement(sql);
	ps.setInt(1, deposit);
	ps.setInt(2, accountid);

	ps.execute();
	success = true;
			} catch (SQLException e) {

	e.printStackTrace();
}

return success;
	}

}
