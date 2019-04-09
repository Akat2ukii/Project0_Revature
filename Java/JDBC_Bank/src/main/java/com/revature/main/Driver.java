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
		
		 //choice0 -- is the user registered?
		 Scanner choice0 = new Scanner(System.in);
		 System.out.println("Are you a registerd user?");
		 String choosing0 = choice0.nextLine();
		 if (choosing0.contentEquals("no")) {
		
			 //choice1 - option for unregistered users to register as user 	
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
				 
				 	//choice2 - option to open an account for the newly registered
				 	/*
				 	Scanner choice2 = new Scanner(System.in);
				 	System.out.println("Would you like to create ?");
				 	*/
				 		//choice3 -- option to exit or proceed to the registerd users portal
				 		//
				 		// 
				 
			 } 
			 // end of block for non-registered users to register 
			 
			 else {
				 //code for non-registered and don't want to register
				 System.out.println("Reeeee");
			 }
		 System.out.println("Username is: " + choosing);
		 } 
		 // end of block for non-users registering
		 else {
			 //choices for registered users 
			 Scanner choiceR1 = new Scanner(System.in);
			 System.out.println("\nPlease enter one of the following:\n'v' to view your accounts,\n'c' to create a new account,\n'd' to delete an empty account, or\n'f' to depsit or withdraw funds.");
			 String choosingR1 = choiceR1.nextLine();
			 // . . . more code here. . . 
		 }
		 //end of block for non-registered users 
	}
	//end of choice one method
	
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
