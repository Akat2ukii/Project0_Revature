package com.revature.main;

import com.revature.beans.*;
import java.util.*;
import com.revature.dao.*;

public class Driver {
	private static UserDAO ud = new UserDAOImpl();
	private static BankAccountDAO bad = new BankAccountDAOImpl();
	private static BankAccount userAccount = new BankAccount();
	private static User thisUser = new User();
	private static String naming;
	private static String passing;

	private static void newUserCreateAccount(String username, String password) {
		Scanner choice2 = new Scanner(System.in);
		System.out.println("Would you like to create an account?");
		String choosing2 = choice2.nextLine();
		if (choosing2.toLowerCase().contentEquals("yes")) {
			List<User> myList = ud.getUserByUserNamePassword(username, password);
			User thisList = myList.get(0);
			int myid = thisList.getId();	
			System.out.println("Would you like a checking or savings account?");
			String accountMake1C = choice2.nextLine();
			int aType = 0;
			if (accountMake1C.toLowerCase().contentEquals("checking")) {
				aType = 1;
			} 
			else if (accountMake1C.toLowerCase().contentEquals("savings")) {
				aType = 2;
			} 
			else {
				System.out.println("Please type out 'savings' or 'checking'");
				return;
			}
			System.out.println("How much would you like to deposit?");
			try {			
				String balanceS = choice2.nextLine();
				int balance = Integer.parseInt(balanceS);
				bad.createBAccount(myid, aType, balance);
				System.out.println("Thank you, " + username + " we have sucessfully created your account.");
				choiceOne();
			}
			catch (NumberFormatException e) {
				System.out.println("Please enter a bloody number.");
				newUserCreateAccount(naming, passing);
			}

		} 
		else if (choosing2.toLowerCase().contentEquals("no")) {
			choiceOne();
		} 
		else if (choosing2.toLowerCase().contentEquals("back")) {
			createUser();
		} 
		else {
			System.out.println("Please type in either 'yes' or 'no'. To go back, type in 'back'");
			newUserCreateAccount(naming, passing);
		}
	}
	
		
	private static void createUser() {
		// choice1 - option for unregistered users to register as user
		Scanner choice1 = new Scanner(System.in);
		System.out.println("Would you like to create a new user?");
		String choosing = choice1.nextLine();
		if (choosing.toLowerCase().contentEquals("yes")) {
			System.out.println("What is your firstname?");
			String name1 = choice1.nextLine();
			System.out.println("What is your lastname?");
			String name2 = choice1.nextLine();
			System.out.println("What would you like your username to be?");
			naming = choice1.nextLine();
			System.out.println("What would you like your password to be?");
			passing = choice1.nextLine();

			ud.createUser(name1, name2, naming, passing, 1);
		} 
		else if (choosing.toLowerCase().contentEquals("no")) {
			choiceOne();
		} 
		else if (choosing.toLowerCase().contentEquals("exit")) {
			choiceOne();
		} 
		else {
			// code for non-registered and don't want to register
			System.out.println("Please type in either 'yes' or 'no'. To go back, type in 'exit'");
			createUser();
		}
		
	}
	
	private static void superUserCreateUser() {
		// 
		
		Scanner choice1 = new Scanner(System.in);
			
		System.out.println("firstname: ");
		String name1 = choice1.nextLine();
		//
		System.out.println("lastname: ");
		String name2 = choice1.nextLine();
		//
		System.out.println("username: ");
		naming = choice1.nextLine();
		//
		System.out.println("password: ");
		passing = choice1.nextLine();

		ud.createUser(name1, name2, naming, passing, 1);
			
	}
	/*
	userUpdate(accountId) {
		// stuff goes here 
	}
	*/
	
	private static void userLogin() {
		// user login process
		Scanner un = new Scanner(System.in);
		System.out.println("Please enter your username.");
		String inUn = un.nextLine();
		//
		System.out.println("Please enter your password.");
		String inPass = un.nextLine();
		//
		try {
			List<User> myList = ud.getUserByUserNamePassword(inUn, inPass);
			thisUser = myList.get(0);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("I'm sorry, but those inputs do not match with anything we have in memory, please try to log in again or make a new account.");
			choiceOne();
		}

	}
	
	private static void viewAccounts() {
		List<BankAccount> accountList; /* = new ArrayList<BankAccount>(); */
		accountList = ud.getAccountDetails(thisUser.getId());
		BankAccount bankAccount;
		for (int i = 0; i < accountList.size(); i++) {
			bankAccount = ud.getAccountDetails(thisUser.getId()).get(i);
			System.out.println(bankAccount);
		}
		choiceOne();
	}
	// -- pick up here 
	private static void viewAllAccounts() {
		List<BankAccount> accountsList; 
		accountsList = ud.getAllAccountDetails();
		BankAccount bankAccount; 
		for (int i = 0; i < accountsList.size(); i++) {
			bankAccount = ud.getAllAccountDetails().get(i);
			System.out.println(bankAccount);
		}
		choiceOne();
	}
	
	private static void createAccount() {
		Scanner accountMake1 = new Scanner(System.in);
		System.out.println("Would you like a checking or savings account?");
		String accountMake1C = accountMake1.nextLine();
		int aType = 0;
		if (accountMake1C.toLowerCase().contentEquals("checking")) {
			aType = 1;
		} else if (accountMake1C.toLowerCase().contentEquals("savings")) {
			aType = 2;
		} 
		else {
			System.out.println("Please type out 'savings' or 'checking'");
			createAccount();
		}
		System.out.println("How much would you like to deposit?");
		try {
			String balanceS = accountMake1.nextLine();
			int balance = Integer.parseInt(balanceS);
			bad.createBAccount(thisUser.getId(), aType, balance);
		}
		catch (NumberFormatException e) {
			System.out.println("Please enter a valid number.");
			createAccount();
		}

		System.out.println("Would you like to make another account?");
		String going1 = accountMake1.nextLine();
		if (going1.toLowerCase().contentEquals("yes")) {
			createAccount();
		}
		else if (going1.toLowerCase().contentEquals("no")) {
			choiceOne();
		}
		else {
			return;
		}
	}
	
	private static int idForAccount() {
		Scanner verification = new Scanner(System.in);
		System.out.println("What is your account number?");
		String thisAccountId = verification.nextLine();
	
			int returnId = Integer.parseInt(thisAccountId);
			return returnId;
	}
	
	private static void accountUpdate(int id) {	
		userAccount = bad.getBAccountById(id);
		if (userAccount.getUserId() != thisUser.getId()) {
			System.out.println("I'm sorry, it looks like this account isn't tied to your account. Please try again, or type 'exit' to go back.");
			idForAccount();
		}
		Scanner transactionType = new Scanner(System.in);
		System.out.println("Would you like to deposit, withdraw or exit?");
		String transaction = transactionType.nextLine();
		if (transaction.toLowerCase().contentEquals("withdraw") || transaction.toLowerCase().contentEquals("deposit")) {
			Scanner amountT = new Scanner(System.in);
			System.out.println("How much would you like to withdraw or deposit?");
			double amountNum = 0;
			try {
				String amount = amountT.nextLine();
				amountNum = Double.parseDouble(amount);
			}
			catch(NumberFormatException e) {
				System.out.println("A number... really");
				accountUpdate(userAccount.getId());
			}

			double changingValue = 0;
			if (amountNum == 0) {
				System.out.println("You cannot deposit or withdraw an amount of 0!");
				accountUpdate(userAccount.getId());
			} 
			else if (transaction.toLowerCase().contentEquals("deposit") && amountNum > 0) {
				changingValue = userAccount.getBalance() + amountNum;
				bad.updateBAccount(changingValue, userAccount.getId(), thisUser.getId());
        					 	//update transaction record here 
					 	int activityTypeId = 1;
					 	String txDescription = "deposit"; 
					 	double currentBalance = changingValue; 
					 	int maxActivityIndx = bad.getMaxActivity(); 
					 	bad.updateActivity(userAccount.getId(), maxActivityIndx, activityTypeId, txDescription, currentBalance); 
				Scanner query1 = new Scanner(System.in);
				System.out.println("Would you like to continue editing this account?");
				String answer1 = query1.nextLine();
				if (answer1.toLowerCase().contentEquals("yes")) {
					accountUpdate(userAccount.getId());
				}
				else {
					accountUpdate(userAccount.getId());
				}
			} 
			else if (transaction.toLowerCase().contentEquals("withdraw") && amountNum > 0) {
				changingValue = userAccount.getBalance() - amountNum;
				
				if (changingValue < 0) {
					System.out.println("You cannot have an overdraft fee!");
					System.out.println("You have " + userAccount.getBalance() + " remaining in your account.");
					accountUpdate(userAccount.getId());
				} 
				
				else {
					bad.updateBAccount(changingValue, userAccount.getId(), thisUser.getId());
          					 	//update transaction record here 
					 	int activityTypeId = 1;
					 	String txDescription = "deposit"; 
					 	double currentBalance = changingValue; 
					 	int maxActivityIndx = bad.getMaxActivity(); 
					 	bad.updateActivity(userAccount.getId(), maxActivityIndx, activityTypeId, txDescription, currentBalance); 
					Scanner query2 = new Scanner(System.in);
					System.out.println("Would you like to continue editing this account?");
					String answer2 = query2.nextLine();
					if (answer2.toLowerCase().contentEquals("yes")) {
						accountUpdate(userAccount.getId());
					}
					else {
						accountUpdate(userAccount.getId());
					}
				}

			} 
			else {
				System.out.println("That was not a numerical value, please enter in a number.");
			}
		}
		else if (transaction.toLowerCase().contentEquals("exit")) {
			return;
		}
		
		else {
			System.out.println("Please either type in deposit, withdraw or exit.");
			accountUpdate(userAccount.getId());
		}
	}

    private static void userTransactions() {
    	List<Activity> activityList; 
							//
			Scanner accNum = new Scanner(System.in);
			System.out.println("Please enter an account number.");
			int inAccNum = Integer.valueOf(accNum.nextLine());
							//
			activityList = bad.getActivity(inAccNum); 
			Activity activity; 
			for (int i = 0 ;  i < activityList.size(); i++) {
 					activity = bad.getActivity(inAccNum).get(i); 
 					System.out.println(activity);
			}
    }
	private static void choiceOne() {

		// choice0 -- is the user registered?
		Scanner choice0 = new Scanner(System.in);
		System.out.println("Are you a registerd user?");
		String choosing0 = choice0.nextLine();
		if (choosing0.toLowerCase().contentEquals("no")) {
			createUser();
			newUserCreateAccount(naming, passing);
		}
		// end of block for non-users registering
		else if (choosing0.toLowerCase().contentEquals("yes")) {
			userLogin();

			//
			// options for registered users
			Scanner choiceR1 = new Scanner(System.in);
			System.out.println("\nPlease enter one of the following:\n " 
					+ "'v' to view your accounts,\n "
					+ "'c' to create a new account,\n " + "'d' to delete an empty account, or\n "
					+ "'f' to deposit or withdraw funds.");

			String choosingR1 = choiceR1.nextLine();

			// cases
			switch (choosingR1) {
			
			case "v":
				viewAccounts();
				break;
				
			case "h":
				userTransactions();
				break; 
				
			case "c":
				createAccount();
				break;

			case "d":

				break;
			case "f":
				accountUpdate(idForAccount());
				break;
				
			default:

			}

			// . . . more code here . . .

		} 
		else if (choosing0.toLowerCase().contentEquals("super")) {
			//
			// choices for superusers
			//
			// superuser login process
			Scanner un = new Scanner(System.in);
			System.out.println("Please enter your username.");
			String inUn = un.nextLine();
			//
			Scanner pass = new Scanner(System.in);
			System.out.println("Please enter your password.");
			String inPass = pass.nextLine();
			//
			List<User> myList = ud.getUserByUserNamePassword(inUn, inPass);
			User thisUser = myList.get(0);
			//
			if (thisUser.getUserTypeId() == 2) {
				//
				Scanner choiceR1 = new Scanner(System.in);
				System.out.println("\nWelcome superuser " + thisUser.getFirstName() +
						"\nPlease enter one of the following:\n" + 
						"'v' to view all accounts,\n" +
						"'c' to create a new users account,\n"+
						"'d' to delete all user accounts, or\n"+
						"'u' to update an account.");
				
				String choosingR1 = choiceR1.nextLine();
				
				// superuser cases
				switch (choosingR1) {
				
				case "v":
					viewAllAccounts();
					break;
					
				case "c":
					superUserCreateUser();
					break;
					
				
				case "d":

					break;
			
					
				case "u":
					
					/*
					userUpdate(idForAccount());
					break;
					*/
					
				default:
			

				}

			} 
			else {
				System.out.println("Sorry, " + thisUser.getFirstName()
						+ ", you do not have superuser priveledges.\nPlease start again and enter your user credentials to access your account.");
			}
		} 
		else if (choosing0.toLowerCase().contentEquals("exit")) {
			return;
		} 
		else {
			System.out.println("Please type in either 'yes' or 'no'. To go logout, please type in 'exit'");
			choiceOne();
		}
		// end of block for non-registered users
	}
	// end of choice one method

	public static void main(String[] args) {
		choiceOne();

//		  try { Connection con =
//		  ConnectionUtil.getConnection();
//		  System.out.println(con); } catch (SQLException e) { e.printStackTrace(); }

//		  UserDAO ud = new UserDAOImpl();
//		  List<User> userList = ud.getUser();
//			
//			for(User u : userList) {
//				System.out.println(u);
//			}
//		  
	}

}
