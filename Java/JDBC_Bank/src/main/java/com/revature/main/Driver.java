package com.revature.main;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.beans.User;
import com.revature.dao.*;
import com.revature.util.ConnectionUtil;

import java.util.Scanner;



public class Driver {
	
	private static void choiceOne() {
		 Scanner choice1 = new Scanner(System.in);
		 System.out.println("Would you like to create a new user?");
		 String choosing = choice1.nextLine();
		 if (choosing.contentEquals("yes")) {
			 Scanner fName = new Scanner(System.in);
			 System.out.println("What is your firstname?");
			 String name1 = fName.nextLine();
			 Scanner lName = new Scanner(System.in);
			 System.out.println("What is your lastname?");
			 String name2 = lName.nextLine();
			 Scanner uName = new Scanner(System.in);
			 System.out.println("What would you like your username to be?");
			 String name3 = uName.nextLine();
			 Scanner passW = new Scanner(System.in);
			 System.out.println("What would you like your password to be?");
			 String passing = passW.nextLine();
			  UserDAO ud = new UserDAOImpl();
			  ud.createUser(name1, name2, name3, passing, 1);
			 
		 }
		 else {
			 System.out.println("Reeeee");
		 }
		 System.out.println("Username is: " + choosing);
	}
	
	public static void main(String[] args) {
		choiceOne();
		 
		  try { Connection con =
		  ConnectionUtil.getConnection();
		  System.out.println(con); } catch (SQLException e) { e.printStackTrace(); }
		  
//		  UserDAO ud = new UserDAOImpl();
//		  List<User> userList = ud.getUser();
//			
//			for(User u : userList) {
//				System.out.println(u);
//			}
//		  
	}

}
