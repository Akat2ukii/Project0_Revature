package com.revature.main;

import java.io.IOException;

import com.revature.beans.*;
import java.sql.*;
import java.util.*;
import com.revature.dao.*;
import com.revature.util.ConnectionUtil;



public class Driver {
	
	private static void choiceOne() {
		
		 //choice0 -- is the user registered?
		 Scanner choice0 = new Scanner(System.in);
		 System.out.println("Are you a registerd user?");
		 String choosing0 = choice0.nextLine();
		 if (choosing0.toLowerCase().contentEquals("no")) {
		
			 //choice1 - option for unregistered users to register as user 	
			 Scanner choice1 = new Scanner(System.in);
			 System.out.println("Would you like to create a new user?");
			 String choosing = choice1.nextLine();
			 if (choosing.toLowerCase().contentEquals("yes")) {
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
				 
				 	
				 	Scanner choice2 = new Scanner(System.in);
				 	System.out.println("Would you like to create an account?");
				 	String choosing2 = choice2.nextLine();
				 	if (choosing2.toLowerCase().contentEquals("yes")) {
				 		List<User> myList = ud.getUserByUserNamePassword(name3, passing);
				 		User thisList = myList.get(0);
				 		int myid = thisList.getId();
				 		Scanner accountMake1 = new Scanner(System.in);
					 	System.out.println("Would you like a checking or savings account?");
					 	String accountMake1C = accountMake1.nextLine();
					 	int aType = 0;
					 	if (accountMake1C.toLowerCase().contentEquals("checkings")) {
					 		aType = 1;
					 	}
					 	else if(accountMake1C.toLowerCase().contentEquals("savings")) {
					 		aType = 2;
					 	}
					 	else {
					 		System.out.println("Please type out 'savings' or 'checking'");
					 	}
					 	Scanner accountMake2 = new Scanner(System.in);
					 	System.out.println("How much would you like to deposit?");
					 	String balanceS = accountMake2.nextLine();
					 	int balance = Integer.parseInt(balanceS);
					 	BankAccountDAO bad = new BankAccountDAOImpl();
					 	bad.createBAccount(myid, aType, balance);
					 	

					 	
				 	}
				 	else {
				 		System.out.println("Please type in either yes or no.");
				 	}
				 			 
				 		//choice3 -- option to exit or proceed to the registered users portal
				 		//
				 		// 
				 
			 } 
			 // end of block for non-registered users to register 
			 
			 else {
				 //code for non-registered and don't want to register
				 System.out.println("Reeeee");
			 }
		 } 
		 // end of block for non-users registering
		 else  if (choosing0.toLowerCase().contentEquals("yes")) {
		
			 //user login process 
			 Scanner un = new Scanner(System.in);
			 System.out.println("Please enter your username.");
			 String inUn = un.nextLine();
			 //
			 Scanner pass = new Scanner(System.in);
			 System.out.println("Please enter your password.");
			 String inPass = pass.nextLine();
			 //  
			 UserDAO ud = new UserDAOImpl();
			 List<User> myList = ud.getUserByUserNamePassword(inUn, inPass);
			 User thisUser = myList.get(0);
			 
			 // 
			 //options for registered users 
			 Scanner choiceR1 = new Scanner(System.in);
			 System.out.println("\nPlease enter one of the following:\n'v' "
			 					+ "to view your accounts,\n'c' "
			 					+ "to create a new account,\n'd' "
			 					+ "to delete an empty account, or\n'f' "
			 					+ "to deposit or withdraw funds.");
			 
			 String choosingR1 = choiceR1.nextLine();
			 
			 //cases 
			 switch(choosingR1) {
			 	case "v": 	List<BankAccount> accountList; /* = new ArrayList<BankAccount>();*/
			 				accountList = ud.getAccountDetails(thisUser.getId()); 
			 				BankAccount bankAccount; 
			 				for (int i = 0 ;  i < accountList.size(); i++) {
			 					bankAccount = ud.getAccountDetails(thisUser.getId()).get(i); 
				 				System.out.println(bankAccount);
			 				}
			 				break; 

			 	
			 	case "c":
			 		Scanner accountMake1 = new Scanner(System.in);
				 	System.out.println("Would you like a checking or savings account?");
				 	String accountMake1C = accountMake1.nextLine();
				 	int aType = 0;
				 	if (accountMake1C.toLowerCase().contentEquals("checking")) {
				 		aType = 1;
				 	}
				 	else if(accountMake1C.toLowerCase().contentEquals("savings")) {
				 		aType = 2;
				 	}
				 	else {
				 		System.out.println("Please type out 'savings' or 'checking'");
				 		return;
				 	}
				 	Scanner accountMake2 = new Scanner(System.in);
				 	System.out.println("How much would you like to deposit?");
				 	String balanceS = accountMake2.nextLine();
				 	int balance = Integer.parseInt(balanceS);
				 	BankAccountDAO bad = new BankAccountDAOImpl();
				 	bad.createBAccount(thisUser.getId(), aType, balance);
			 	break; 
			 	
			 	case "d":
			 				
			 	break; 
			 	case "f":
			 		BankAccountDAO bad1 = new BankAccountDAOImpl();
				 	Scanner balanceEdit2 = new Scanner(System.in);
				 	System.out.println("What is your account number?");
				 	String balancing2 = balanceEdit2.nextLine();
				 	int balancinging2 = Integer.parseInt(balancing2);
				 	Scanner balanceEdit3 = new Scanner(System.in);
				 	System.out.println("Would you like to deposit or withdraw?");
				 	String balancing3 = balanceEdit3.nextLine();
				 	Scanner balanceEdit4 = new Scanner(System.in);
				 	System.out.println("How much would you like to withdraw or deposit?");
				 	String balancing4 = balanceEdit4.nextLine();
				 	int balancinging4 = Integer.parseInt(balancing4);
				 	
				 	BankAccount me = bad1.getBAccountById(balancinging2);
				 	double changingValue = 0;
				 	if (balancinging4 == 0) {
				 		System.out.println("You cannot deposit or withdraw an amount of 0!");
				 	}
				 	else if (balancing3.toLowerCase().contentEquals("deposit") && balancinging4 > 0) {
				 		changingValue = me.getBalance() + balancinging4;
					 	bad1.updateBAccount(changingValue, me.getId());
				 	}
				 	else if (balancing3.toLowerCase().contentEquals("withdraw") && balancinging4 > 0) {
				 		changingValue = me.getBalance() - balancinging4;
				 		if (changingValue < 0) {
				 			System.out.println("You cannot have an overdraft fee!");
				 		}
				 		else {
				 			bad1.updateBAccount(changingValue, me.getId());
				 		}
					 	
				 	}
				 	else {
				 		System.out.println("No");
				 	}

			 	break;
			 	default:
			 	

			 }
			 
			
			 // . . . more code here . . . 
				 
		 } else if (choosing0.toLowerCase().contentEquals("super")) {
			 //
			 //choices for super users 
			 //
			 //user login process 
			 Scanner un = new Scanner(System.in);
			 System.out.println("Please enter your username.");
			 String inUn = un.nextLine();
			 //
			 Scanner pass = new Scanner(System.in);
			 System.out.println("Please enter your password.");
			 String inPass = pass.nextLine();
			 //  
			 UserDAO ud = new UserDAOImpl();
			 List<User> myList = ud.getUserByUserNamePassword(inUn, inPass);
			 User thisUser = myList.get(0); 
			 //
			 if (thisUser.getUserTypeId() == 2) {
				 // 
				 Scanner choiceR1 = new Scanner(System.in);
				 System.out.println("\nWelcome superuser "+thisUser.getFirstName()+"\nPlease enter one of the following:\n'v' to view all accounts,\n'c' to create a new account,\n'd' to delete all user accounts, or\n'u' to update an account.");
				 String choosingR1 = choiceR1.nextLine();
				 // . . . more code here. . . 
				 
			 } else {
				 System.out.println("Sorry, "+thisUser.getFirstName()+", you do not have superuser priveledges.\nPlease start again and enter your user credentials to access your account.");
			 }
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
