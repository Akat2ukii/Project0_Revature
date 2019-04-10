package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.beans.*;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO{

	@Override
	public List<User> getUser() {
		List<User> ul = new ArrayList<>();
		// try-with-resources... resources will be closed at the end of the block
		// works for all AutoCloseable resources
		try (Connection con = ConnectionUtil.getConnection()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT U.USR_ID, U.FIRSTNAME, U.LASTNAME, U.USERNAME, U.PASSWORD, U.USR_TYPE_ID "
					+ "FROM USR U";
				
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int userId = rs.getInt("USR_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int userTypeId = rs.getInt("USR_TYPE_ID");
				
				ul.add(new User(userId, firstName, lastName, username, password, userTypeId));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ul;
	}

	@Override
	public List<User> getUserByUserNamePassword(String userName, String password) {
		List<User> ul = new ArrayList<>();
		// try-with-resources... resources will be closed at the end of the block
		// works for all AutoCloseable resources
		try (Connection con = ConnectionUtil.getConnection()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT U.USR_ID, U.FIRSTNAME, U.LASTNAME, U.USERNAME, U.PASSWORD, U.USR_TYPE_ID "
					+ "FROM USR U WHERE U.USERNAME = ? AND U.PASSWORD = ?";
				
			PreparedStatement stmtGet = con.prepareStatement(sql);
			stmtGet.setString(1, userName);
			stmtGet.setString(2, password);
			ResultSet rs = stmtGet.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("USR_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password1 = rs.getString("PASSWORD");
				int userTypeId = rs.getInt("USR_TYPE_ID");
				
				ul.add(new User(userId, firstName, lastName, username, password1, userTypeId));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < ul.size(); i++) {
			System.out.println(ul.get(i));
		}
		return ul;
	}

	@Override
	public void createUser (String firstName, String lastName, String userName, String password, int userTypeId) {
		// try-with-resources... resources will be closed at the end of the block
		// works for all AutoCloseable resources
		try (Connection con = ConnectionUtil.getConnection()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "INSERT INTO USR(FIRSTNAME, LASTNAME, USERNAME, PASSWORD, USR_TYPE_ID) " 
					+ "VALUES (?,?,?,?,?)";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, userName);
			pstmt.setString(4, password);
			pstmt.setInt(5, userTypeId);
			pstmt.executeUpdate();
		
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<BankAccount> getAccountDetails(int userId) {
		List<BankAccount> al = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = 
					
					"SELECT * "
					+"FROM BANK_ACCOUNT B "
					+"WHERE " 
					+    "B.USR_ID = ?"; 
			
			PreparedStatement stmtGet = con.prepareStatement(sql);
			stmtGet.setInt(1, userId);
			ResultSet rs = stmtGet.executeQuery();
			while (rs.next()) {
				int accountId = rs.getInt("BANK_ACCOUNT_ID");
				int id = rs.getInt("USR_ID");
				int accountTypeId = rs.getInt("ACCOUNT_TYPE_ID");
				double balance = rs.getDouble("BALANCE");
				
				al.add(new BankAccount(accountId, userId, accountTypeId, balance));
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return al; 
	}
	
	/*
	public List<BankAccount> getAccountDetails(int userId) {
		
		List<BankAccount> al = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = 
					
					"SELECT * "
					+"FROM BANK_ACCOUNT B "
					+"WHERE " 
					+    "B.USR_ID = 2 "; 
			
					/*
					"SELECT B.BANK_ACCOUNT_ID, B.USR_ID, B.ACCOUNT_TYPE_ID, B.BALANCE "
					+"FROM BANK_ACCOUNT B "
					+"INNER JOIN USR "
					+"ON "  
					+"USR.USR_ID = B.USR_ID "
					+"WHERE "
					+"(USR.USERNAME= ?) AND (USR.PASSWORD= ?) ";
					*/
			/*
			PreparedStatement stmtGet = con.prepareStatement(sql);
			stmtGet.setString(1, userName);
			stmtGet.setString(2, password);
			ResultSet rs = stmtGet.executeQuery();
			while (rs.next()) {
				int accountId = rs.getInt("BANK_ACCOUNT_ID");
				int userId = rs.getInt("USR_ID");
				int accountTypeId = rs.getInt("ACCOUNT_TYPE_ID");
				double balance = rs.getDouble("BALANCE");
				
				al.add(new BankAccount(accountId, userId, accountTypeId, balance));
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return al; 
	}
	*/
	
	/*
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
	}
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
	}
	*/

}
