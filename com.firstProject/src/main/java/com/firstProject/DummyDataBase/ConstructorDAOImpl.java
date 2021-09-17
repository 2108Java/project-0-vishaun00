package com.firstProject.DummyDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.firstProject.Constructor;

public class ConstructorDAOImpl implements ConstructorDAO {
String server="localhost";	
String url="jdbc:postgresql://" +server+"/postgres";
String username ="postgres";
String password="PorkChop@00";
	@Override
	public boolean insert(Constructor item) {
		boolean success= false;
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			String sql= "Insert Into Accounts Values(?,?,?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,item.getAccountID());
			ps.setString(2,item.getFirstName());
			ps.setString(3, item.getLastName());
			ps.setString(4, item.getAccountType());
			ps.setBoolean(5, item.getIsComplete());
			ps.setDouble(6, item.getDeposit());
			
			ps.execute();
			success= true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean delete(String firstName,String lastName) {
		boolean success = false;
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql = "Delete From Accounts where firstName = ? AND lastName = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.execute();

			success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean delete(int accountID) {
		boolean success = false;
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			String sql="Delete From Accounts where accountid =?;";
			PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, accountID);
				ps.execute();
				success = true;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public Constructor[] selectAllAccounts() {
		Constructor[] array = new Constructor[10];
		try (Connection connection = DriverManager.getConnection(url,username,password)){
			String sql ="Select * From Accounts;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int i=0;
			while(rs.next()) {      
				
				array[i]= new Constructor(rs.getInt("accountID"),
										 rs.getString("firstName"),
										 rs.getString("lastname"),
										  rs.getString("accountType"),
										 rs.getBoolean("Approved"),
										 rs.getInt("balance"));
				
			}
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		}
			return array;
		}

	@Override
	public Constructor[] SelectAllCompletedAccounts() {
		Constructor[] array = new Constructor[10];
	try (Connection connection = DriverManager.getConnection(url,username,password)){
		String sql ="Select * From Accounts where Approved = true;";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		int i=0;
		while(rs.next()) {      
			
			array[i]= new Constructor(rs.getInt("accountID"),
									 rs.getString("firstName"),
									 rs.getString("lastname"),
									  rs.getString("accountType"),
									 rs.getBoolean("Approved"),
									 rs.getInt("balance"));
			
		}
	}
	catch (SQLException e) {
	
		e.printStackTrace();
	}
		return array;
	}

	@Override
	public Constructor[] SelectAllInCompletedAccounts() {
		Constructor[] array = new Constructor[10];
		try (Connection connection = DriverManager.getConnection(url,username,password)){
			String sql ="Select * From Accounts Where Approved = false;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int i=0;
			while(rs.next()) {      
				
				array[i]= new Constructor(rs.getInt("accountID"),
										 rs.getString("firstName"),
										 rs.getString("lastname"),
										  rs.getString("accountType"),
										 rs.getBoolean("Approved"),
										 rs.getInt("balance"));
				
			}
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		}
			return array;
	}

	@Override
	public Constructor [] SelectByAccountID(int accountid) {
		Constructor[] array = new Constructor[10];
		try (Connection connection = DriverManager.getConnection(url,username,password)){
			String sql ="Select * From Accounts \r\n"
					+ "Where accountid = 1;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int i=0;
			while(rs.next()) {      
				
				array[i]= new Constructor(rs.getInt("accountID"),
										  rs.getString("firstName"),
										  rs.getString("lastname"),
										  rs.getString("accountType"),
										  rs.getBoolean("Approved"),
										  rs.getInt("balance"));
			}
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		}
			return array;
	}

	@Override
	public boolean Update(int accountid) {
		Constructor[] array = new Constructor[10];
		boolean success= false;
	try {
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql ="update Accounts\r\n"
				+ "set approved = ?\r\n"
				+ "where accountid =?;";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i =0;
		while(rs.next()) {
			array[i]= new Constructor(rs.getInt("accountID"),
					  rs.getString("firstName"),
					  rs.getString("lastname"),
					  rs.getString("accountType"),
					  rs.getBoolean("Approved"),
					  rs.getInt("balance"));
}				success =true;
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return success;
	}



	@Override
	public void insert(int i, String string, String string2, String string3, boolean b, int j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Constructor[] Update(Constructor item) {
		Constructor[] array = new Constructor[10];
		//boolean success= false;
	try {
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql ="update Accounts\r\n"
				+ "set firstName = ?,lastName = ?,accountType =?,approved =?,balance =?\r\n"
				+ "where accountid =?;";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i =0;
		while(rs.next()) {
			array[i]= new Constructor(rs.getInt("accountID"),
					  rs.getString("firstName"),
					  rs.getString("lastname"),
					  rs.getString("accountType"),
					  rs.getBoolean("Approved"),
					  rs.getInt("balance"));
}				//success =true;
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return array;		
	}




	

}
