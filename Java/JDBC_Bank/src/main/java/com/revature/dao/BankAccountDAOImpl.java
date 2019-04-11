package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
		try (Connection con = ConnectionUtil.getConnectionFromFile("config.properties")) {
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
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < ba.size(); i++) {
		}
		BankAccount rawr = ba.get(0);
		return rawr;
	}

	@Override
	public void createBAccount(int UserId, int accountTypeID, double balance) {

		try (Connection con = ConnectionUtil.getConnectionFromFile("config.properties")) {

			String sql = "INSERT INTO BANK_ACCOUNT(USR_ID, ACCOUNT_TYPE_ID, BALANCE) " 
						  + "VALUES (?, ?, ?)";
						
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, UserId);
			pstmt.setInt(2, accountTypeID);
			pstmt.setDouble(3, balance);
			pstmt.executeUpdate();
				
					
		} 
			catch (SQLException | IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void updateBAccount(double balanceOfUser, int bankAccId, int idOfUser) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile("config.properties")) {

			String sql = "UPDATE BANK_ACCOUNT " + 
						 "SET BALANCE = ? " + 
						 "WHERE  " + 
						 "BANK_ACCOUNT_ID = ? " +
						 "AND USR_ID = ?";

						
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, balanceOfUser);
			pstmt.setInt(2, bankAccId);
			pstmt.setInt(3, idOfUser);
			pstmt.executeUpdate();
				
					
		} 
			catch (SQLException | IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteBAccount(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMaxActivity() {
		int maxIndx = 0; 
		
		try (Connection con = ConnectionUtil.getConnectionFromFile("config.properties")) {
			String sql = "{call SP_GET_MAX_ACTIVITY(?)}"; 			
			CallableStatement cs = con.prepareCall(sql);
			cs.registerOutParameter(1, java.sql.Types.INTEGER); 
			cs.execute(); 
			maxIndx =cs.getInt(1); 		
		} 
			catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		return maxIndx;
	}

	@Override
	public void updateActivity(int bankAccountId, int activityIndx, int activityTypeId, String txDescription,
			double currentBalance) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("config.properties")) {
			String sql = 
					"UPDATE ACTIVITY A " +
					"SET " +
					    "A.BANK_ACCOUNT_ID = ?, " +
					    "A.ACTIVITY_TYPE_ID = ?, " + 
					    "A.TX_DESCRIPTION = ?, " +
					    "A.CURRENT_BALANCE = ? " +
					"WHERE " +
					    "A.ACTIVITY_ID = ? "; 
						
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bankAccountId);
			pstmt.setInt(2, activityTypeId);
			pstmt.setString(3, txDescription);
			pstmt.setDouble(4, currentBalance);
			pstmt.setInt(5, activityIndx);
			pstmt.executeUpdate();		
		} 
			catch (SQLException | IOException e) {
				e.printStackTrace();
			}	
		
		
	}


	@Override
	public List<Activity> getActivity(int bankAccountId) {
		List<Activity> activityList = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile("config.properties")) {
			String sql = 
					
					"SELECT * " +
					"FROM ACTIVITY " +
					"WHERE BANK_ACCOUNT_ID = ? "; 
			
			PreparedStatement stmtGet = con.prepareStatement(sql);
			stmtGet.setInt(1, bankAccountId);
			ResultSet rs = stmtGet.executeQuery();
			while (rs.next()) {
				int activityId = rs.getInt("ACTIVITY_ID");
				int bAccountId = rs.getInt("BANK_ACCOUNT_ID");
				int actTypeId = rs.getInt("ACTIVITY_TYPE_ID"); 
				LocalDate txDate = rs.getDate("TX_DATE").toLocalDate();
				String txDescribe = rs.getString("TX_DESCRIPTION");
				double currentBalance = rs.getDouble("CURRENT_BALANCE"); 
				
				activityList.add(new Activity(activityId, bAccountId, actTypeId, txDate,txDescribe, currentBalance));
			}
				
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return activityList; 
	}


}
