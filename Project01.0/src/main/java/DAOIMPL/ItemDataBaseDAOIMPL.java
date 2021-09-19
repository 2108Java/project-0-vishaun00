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
						rs.getString("accounttype"),// be more consistent 
						rs.getBoolean("Approved"), 
						rs.getInt("deposit"),
						rs.getInt("withdraw"),
						rs.getBoolean("requestJointAccount"));// change to balance, was withdraw
						
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	@Override
	public boolean insert(Item newItem) {
	boolean	success = false;
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String sql = "Insert Into bankAccount Values(?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,newItem.getAccountID());
			ps.setString(2, newItem.getName());
			ps.setString(3,newItem.getAccount());
			ps.setBoolean(4, false);
			ps.setDouble(5, newItem.getDeposit());
			ps.setDouble(6, newItem.getWithdraw());
			ps.execute();
			success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return success;
	}

	@Override
	public boolean updateDeposit(int accountid, int deposit, boolean approved) {
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
	//ps.setBoolean(2, approved);
	ps.execute();
	success = true;
			} catch (SQLException e) {
	// TODO Auto-generated catch block
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
			//ps.setInt(1, withdraw- deposit); //try this later
			//ps.setBoolean(1, approved);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateWithdraw1(int accountid, int withdraw, boolean approved) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requestUpdate(int accountid) {
		Connection connection;
		boolean success = false;
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql="Update bankAccount Set requestJoint = true where accountid =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1,accountid);
			ps.execute();
			success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public Item[] joinAccount(Item newItem) {
		Item [] array = new Item[10];

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql="select deposit\r\n"
					+ "from bankAccount\r\n"
					+ "full inner join bankAccount1 \r\n"
					+ "on ? = ?r\n"
					+ "where requestJointAccount = true;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i=0;
			while(rs.next()) {
				array[i]= new Item(rs.getInt("accountid"),
						rs.getString("fullName"),
						rs.getString("accounttype"),// be more consistent 
						rs.getBoolean("Approved"), 
						rs.getInt("deposit"),
						rs.getInt("withdraw"),
						rs.getBoolean("requestJointAccount"));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	public boolean joinAccount(int accountid){
		
		//, int accountid1 try if two ints work for id
		Item [] array = new Item[10];
		boolean success = false;

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql="select deposit\r\n"
					+ "from bankAccount\r\n"
					+ "full inner join bankAccount1 \r\n"
					+ "on bankAccount.accountid = bankAccount1.accountid\r\n"
					+ "where requestJointAccount = true;\r\n"
					+ "\r\n"
					+ "";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, accountid);
				//ps.setInt(2, accountid1);
				ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

}
