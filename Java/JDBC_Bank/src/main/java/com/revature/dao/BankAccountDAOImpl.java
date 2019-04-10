package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;


public class BankAccountDAOImpl implements BankAccountDAO {

	@Override
	public List<User> getBAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getBAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBAccount(int UserId, int accountTypeID, double balance) {
		// try-with-resources... resources will be closed at the end of the block

				// works for all AutoCloseable resources
				try (Connection con = ConnectionUtil.getConnection()) {
					// write a join to unify Bear, Cave, and BearType into one ResultSet
					// map the ResultSet onto a list of Bear objects
					String sql = "INSERT INTO BANK_ACCOUNT(USR_ID, ACCOUNT_TYPE_ID, BALANCE) " 
								 + "VALUES (?, ?, ?)";
						
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, UserId);
					pstmt.setInt(2, accountTypeID);
					pstmt.setDouble(3, balance);
					pstmt.executeUpdate();
				
					
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				

		// works for all AutoCloseable resources
		try (Connection con = ConnectionUtil.getConnection()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "INSERT INTO BANK_ACCOUNT(USR_ID, ACCOUNT_TYPE_ID, BALANCE) " 
						 + "VALUES (?, ?, ?)";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, UserId);
			pstmt.setInt(2, accountTypeID);
			pstmt.setDouble(3, balance);
			pstmt.executeUpdate();
		
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void updateBAccount(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBAccount(User user) {
		// TODO Auto-generated method stub
		
	}

}
