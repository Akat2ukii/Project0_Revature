package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser (String firstName, String lastName, String userName, String password, int userTypeId) {
		// try-with-resources... resources will be closed at the end of the block
		// works for all AutoCloseable resources
		try (Connection con = ConnectionUtil.getConnection()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "INSERT INTO USR(FIRSTNAME, LASTNAME, USERNAME, PASSWORD, USR_TYPE_ID) " 
					+ "VALUES ('" +  firstName + "', '" + lastName + "', '" + userName + "', '" + password + "', '" + userTypeId + "')";
				
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
		
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
