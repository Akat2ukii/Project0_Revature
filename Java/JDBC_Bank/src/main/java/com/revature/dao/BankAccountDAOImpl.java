package com.revature.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.*;
import com.revature.util.ConnectionUtil;


public class BankAccountDAOImpl implements BankAccountDAO {

	@Override
	public List<BankAccount> getBAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount getBAccountById(int id) {
		List<BankAccount> ba = new ArrayList<>();
		// try-with-resources... resources will be closed at the end of the block
		// works for all AutoCloseable resources
		try (Connection con = ConnectionUtil.getConnection()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT * " + 
						 "FROM BANK_ACCOUNT B WHERE B.BANK_ACCOUNT_ID = ?";
				
			PreparedStatement stmtGet = con.prepareStatement(sql);
			stmtGet.setInt(1, id);
			ResultSet rs = stmtGet.executeQuery();
			while (rs.next()) {
				int bankAccId = rs.getInt("BANK_ACCOUNT_ID");
				int userId = rs.getInt("USR_ID");
				int accountTypId = rs.getInt("ACCOUNT_TYPE_ID");
				double bankBalance = rs.getDouble("BALANCE");
				
				ba.add(new BankAccount(bankAccId, userId, accountTypId, bankBalance));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < ba.size(); i++) {
			System.out.println(ba.get(i));
		}
		BankAccount rawr = ba.get(0);
		return rawr;
	}

	@Override
	public void createBAccount(int UserId, int accountTypeID, double balance) {

		try (Connection con = ConnectionUtil.getConnection()) {

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
	public void updateBAccount(double balanceOfUser, int idOfUser) {
		
		try (Connection con = ConnectionUtil.getConnection()) {

			String sql = "UPDATE BANK_ACCOUNT " + 
						 "SET BALANCE = ? " + 
						 "WHERE  " + 
						 "BANK_ACCOUNT_ID = ? ";
						
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, balanceOfUser);
			pstmt.setInt(2, idOfUser);
			pstmt.executeUpdate();
				
					
		} 
			catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteBAccount(User user) {
		// TODO Auto-generated method stub
		
	}

}
