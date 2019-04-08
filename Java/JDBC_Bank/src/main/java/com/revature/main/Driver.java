package com.revature.main;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.beans.User;
import com.revature.dao.*;
import com.revature.util.ConnectionUtil;



public class Driver {

	public static void main(String[] args) {
		
		  try { Connection con =
		  ConnectionUtil.getConnection();
		  System.out.println(con); } catch (SQLException e) { e.printStackTrace(); }
		  
		 
		  UserDAO ud = new UserDAOImpl();
		  List<User> userList = ud.getUser();
			
			for(User u : userList) {
				System.out.println(u);
			}
	}

}
