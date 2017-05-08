package prod;


import java.util.Scanner;

import business.Account;
import business.AccountList;
import business.CheckingAccount;
import business.SavingAccount;
import business.TransactionList;
import data.FileHandler;

public final class AccountCommon {

	static Scanner newScanner = new Scanner(System.in);

	public static boolean validateUniqAccountId(String val) {
		for (Account current : AccountList.getAccountList()) {
			if (current.getAccountId().equals(val)) {
				System.out.printf("\tThe account with Id %s already exist!\n",
						val);
				return false;
			}
		}

		return true;
	}

	public static void addAccount() {
		if (CustomerCommon.validateEmptyCustomerList()) {
			while (true) {
				String cusId;
				String accId;
				String balance;
				String month;
				String day;
				String year;
				String val;
				String interestRate;

				System.out.print("\tEnter customer ID or 'Q' to quit input > ");
				cusId = newScanner.next();
				System.out.println();
				if (cusId.length() == 1
						&& (cusId.charAt(0) == 'q' || cusId.charAt(0) == 'Q')) {
					break;
				}

				else {
					if (CustomerCommon.searchCustomer(cusId)) {
						do {
							System.out.println("\tChoose type of account:");
							System.out.println("\t\t1.	Checking account");
							System.out.println("\t\t2.	Saving account");
							System.out.print("\t\t> ");
							val = newScanner.next();
							System.out.println();
						} while (!val.equals("1") && !val.equals("2"));

						switch (Integer.parseInt(val)) {
							case 1 :
								do {
									System.out
											.print("\tEnter checking account id > ");
									accId = newScanner.next();
									System.out.println();
								} while (!AccountCommon
										.validateUniqAccountId(accId));

								do {
									System.out.print("\tEnter min balanse > ");
									balance = newScanner.next();
									System.out.println();
								} while (!ValidationCommon
										.validateDouble(balance));

								do {
									System.out
											.print("\tEnter Month open account > ");
									month = newScanner.next();
									System.out.println();
								} while (!ValidationCommon.validateMonth(month));

								do {
									System.out
											.print("\tEnter Day open account > ");
									day = newScanner.next();
									System.out.println();
								} while (!ValidationCommon.validateDay(day));

								do {
									System.out
											.print("\tEnter Year open account > ");
									year = newScanner.next();
									System.out.println();
								} while (!ValidationCommon.validateYear(year));

								AccountList.addAccount(	cusId, 
														accId, 
														Double.parseDouble(balance), 
														Integer.parseInt(month),
														Integer.parseInt(day), 
														Integer.parseInt(year));
								
								TransactionList.addTransaction(	Integer.parseInt(month),
																Integer.parseInt(day),
																Integer.parseInt(year),
																accId, 
																"Cr", 
																Double.parseDouble(balance),
																"Open account/Deposit money");
									
								FileHandler.writeToTxtFile(TransactionList.getTransactionList());
								break;
							case 2 :
								do {
									System.out
											.print("\tEnter saving account id > ");
									accId = newScanner.next();
									System.out.println();
								} while (!AccountCommon
										.validateUniqAccountId(accId));

								do {
									System.out
											.print("\tEnter saving balanse > ");
									balance = newScanner.next();
									System.out.println();
								} while (!ValidationCommon
										.validateDouble(balance));

								do {
									System.out
											.print("\tEnter annual interest rate (%) > ");
									interestRate = newScanner.next();
									System.out.println();
								} while (!ValidationCommon
										.validateDouble(interestRate));

								do {
									System.out
											.print("\tEnter Month open account > ");
									month = newScanner.next();
									System.out.println();
								} while (!ValidationCommon.validateMonth(month));

								do {
									System.out
											.print("\tEnter Day open account > ");
									day = newScanner.next();
									System.out.println();
								} while (!ValidationCommon.validateDay(day));

								do {
									System.out
											.print("\tEnter Year open account > ");
									year = newScanner.next();
									System.out.println();
								} while (!ValidationCommon.validateYear(year));

								AccountList.addAccount(	cusId, 
														accId, 
														Double.parseDouble(interestRate), 
														Double.parseDouble(balance), 
														Integer.parseInt(month),
														Integer.parseInt(day), 
														Integer.parseInt(year));
								
								TransactionList.addTransaction(	Integer.parseInt(month),
										Integer.parseInt(day),
										Integer.parseInt(year),
										accId, 
										"Cr", 
										Double.parseDouble(balance),
										"Open account/Deposit money");
								FileHandler.writeToTxtFile(TransactionList.getTransactionList());
								break;
						}
					} else
						System.out
								.printf("\tAny customer with %s Id!\n", cusId);
				}
			}
		} else
			System.out
					.println("\tThe customer list is empty. You should firstly create a customer!");
	}

	public static void removeAccount() {
		String month = "";
		String day = "";
		String year = "";
		String accountId;
		boolean condition = false;
		System.out.print("\tEnter ID of removing account > ");
		accountId = newScanner.next();
		System.out.println();
		for (Account current : AccountList.getAccountList()) {
			if (current.getAccountId().equals(accountId)) {
				
				do {
					System.out
							.print("\tEnter the month the account is closed > ");
					month = newScanner.next();
					System.out.println();
				} while (!ValidationCommon.validateMonth(month));

				do {
					System.out
							.print("\tEnter the day the account is closed > ");
					day = newScanner.next();
					System.out.println();
				} while (!ValidationCommon.validateDay(day));

				do {
					System.out
							.print("\tEnter the year the account is closed > ");
					year = newScanner.next();
					System.out.println();
				} while (!ValidationCommon.validateYear(year));
				
				TransactionList.addTransaction(	Integer.parseInt(month),
												Integer.parseInt(day),
												Integer.parseInt(year),
												accountId, 
												"Dr", 
												current.getCurrentBalance(),
												"Close account/Withdrawal money");
				FileHandler.writeToTxtFile(TransactionList.getTransactionList());
				
				
				AccountList.removeAccount(current);
				System.out.printf("\tAccount with Id %s has been removed\n",
						accountId);
				condition = true;
				break;
			}

		}
		if (!condition)
			System.out.printf("\tAny account with Id %s has not been found!\n",
					accountId);
	}

	public static void searchAccount() {
		String searchParam;
		boolean condition = false;
		System.out.print("\tEnter account Id > ");
		searchParam = newScanner.next();
		System.out.println();
		for (Account current : AccountList.getAccountList()) {
			if (current.getAccountId().equals(searchParam)) {
				System.out.println(current);
				condition = true;
				break;
			}
		}
		if (!condition)
			System.out.printf("\tAny account with Id %s has not been found!\n",
					searchParam);
	}

	public static void searchAccount(String Id) {
		String searchParam;
		boolean condition = false;
		System.out.print("\tEnter account Id > ");
		searchParam = newScanner.next();
		System.out.println();
		for (Account current : AccountList.getAccountList()) {
			if (current.getCustomerId().equals(Id)
					&& current.getAccountId().equals(searchParam)) {
				System.out.println(current);
				condition = true;
				break;
			}
		}
		if (!condition)
			System.out.printf("\tAny account with Id %s has not been found!\n",
					searchParam);
	}
	public static void makeDeposit(String customerId) {
		String month;
		String day;
		String year;
		String accountId = "";
		boolean condition = false;
		System.out.print("\tEnter account Id > ");
		accountId = newScanner.next();
		System.out.println();
		String depositAmmount = "";
		double depAmmount = 0;
		for (Account current : AccountList.getAccountList()) {
			if (current.getCustomerId().equals(customerId)
					&& current.getAccountId().equals(accountId)) {
				while (true) {
					
					do {
						System.out
								.print("\tEnter Month transaction account > ");
						month = newScanner.next();
						System.out.println();
					} while (!ValidationCommon.validateMonth(month));

					do {
						System.out
								.print("\tEnter Day transaction account > ");
						day = newScanner.next();
						System.out.println();
					} while (!ValidationCommon.validateDay(day));

					do {
						System.out
								.print("\tEnter Year transaction account > ");
						year = newScanner.next();
						System.out.println();
					} while (!ValidationCommon.validateYear(year));
					
					System.out.print("\tEnter amount for deposit > ");
					depositAmmount = newScanner.next();
					System.out.println();
					if (ValidationCommon.validateDouble(depositAmmount)) {
						depAmmount = Double.parseDouble(depositAmmount);
						current.setCurrentBalance(current.getCurrentBalance()
								+ depAmmount);

						TransactionList.addTransaction(	Integer.parseInt(month),
														Integer.parseInt(day),
														Integer.parseInt(year),
														accountId, 
														"Cr", 
														depAmmount,
														"Deposit money"); // add current transaction to
																		  // list of transactions
						FileHandler.writeToTxtFile(TransactionList.getTransactionList());
						System.out
								.printf(
										"\tThe amount CAD %.2f has been successfully added to your account %s.",
										depAmmount, accountId);
						System.out.println();
						break;
					} else
						System.out.println("\tWrong format!");
				}
				condition = true;
				break;
			}
		}
		if (!condition)
			System.out.printf("\tAny account with Id %s has not been found!\n",
					accountId);
	}

	public static int makeWithdrawal(String customerId)
	{
		String month = "";
		String day = "";
		String year = "";
		boolean condition = false;
		String accountId = "";
		System.out.print("\tEnter account Id > ");
		accountId = newScanner.next();
		System.out.println();
		String withdrawalAmmount = "";
		double withAmm = 0;
		for (Account current : AccountList.getAccountList()) 
		{
			if (current.getCustomerId().equals(customerId)
					&& current.getAccountId().equals(accountId)) 
			{
			//-----------------------------------------------------------
			
				if (current instanceof CheckingAccount) 
				{
					CheckingAccount chAcc = (CheckingAccount) current;

					while (true) {
						
						do {
							System.out
									.print("\tEnter Month transaction account > ");
							month = newScanner.next();
							System.out.println();
						} while (!ValidationCommon.validateMonth(month));

						do {
							System.out
									.print("\tEnter Day transaction account > ");
							day = newScanner.next();
							System.out.println();
						} while (!ValidationCommon.validateDay(day));

						do {
							System.out
									.print("\tEnter Year transaction account > ");
							year = newScanner.next();
							System.out.println();
						} while (!ValidationCommon.validateYear(year));
						
						
						System.out.print("\tEnter amount for withdrawal > ");
						withdrawalAmmount = newScanner.next();
						System.out.println();
						if (ValidationCommon.validateDouble(withdrawalAmmount))
						{
							withAmm = Double.parseDouble(withdrawalAmmount);
							if (chAcc.getCurrentBalance() - withAmm >= chAcc
									.getMinBalance()) 
							{
								chAcc.setCurrentBalance(chAcc
										.getCurrentBalance()
										- withAmm);

								// add current transaction to list of
								// transactions
								TransactionList.addTransaction(	Integer.parseInt(month),
																Integer.parseInt(day),
																Integer.parseInt(year),
																accountId,
																"Dr",
																withAmm,
																"Withdrawal money");
								FileHandler.writeToTxtFile(TransactionList.getTransactionList());

								System.out
										.printf(
												"\tThe amount CAD %.2f has been successfully removed from your account %s.",
												withAmm, accountId);
								System.out.println();
								condition = true;
								return 0;
							}
							else 
							{
								System.out.println("\tInsufficient fund!");
								return 0;
							}
						} 
						else 
						{
							System.out.println("\tWrong format!");
							return 0;
						}
					}
					}
				if (current instanceof SavingAccount) 
				{
					SavingAccount saAcc = (SavingAccount) current;
					while (true) 
					{
						do {
							System.out
									.print("\tEnter Month transaction account > ");
							month = newScanner.next();
							System.out.println();
						} while (!ValidationCommon.validateMonth(month));

						do {
							System.out
									.print("\tEnter Day transaction account > ");
							day = newScanner.next();
							System.out.println();
						} while (!ValidationCommon.validateDay(day));

						do {
							System.out
									.print("\tEnter Year transaction account > ");
							year = newScanner.next();
							System.out.println();
						} while (!ValidationCommon.validateYear(year));
						
						System.out.print("\tEnter amount for withdrawal > ");
						withdrawalAmmount = newScanner.next();
						System.out.println();
						if (ValidationCommon.validateDouble(withdrawalAmmount)) 
						{
							withAmm = Double.parseDouble(withdrawalAmmount);
							if (saAcc.getCurrentBalance() - withAmm >= saAcc
									.getSavingBalance()) {
								saAcc.setCurrentBalance(saAcc
										.getCurrentBalance()
										- withAmm);

								// add current transaction to list of
								// transactions
								TransactionList.addTransaction(	Integer.parseInt(month),
																Integer.parseInt(day),
																Integer.parseInt(year),
																accountId,
																"Dr",
																withAmm, 
																"Withdrawal money");
								FileHandler.writeToTxtFile(TransactionList.getTransactionList());

								System.out
										.printf(
												"\tThe amount CAD %.2f has been successfully removed from your account %s.",
												withAmm, accountId);
								System.out.println();
								condition = true;
								return 0;
							} 
							else 
							{
								System.out.println("\tInsufficient fund!");
								return 0;
							}
						}

						else 
						{
							System.out.println("\tWrong format!");
							return 0;
						}
					
					}
				//-----------------------------------------------------		
			}
			} 
		}
			if(!condition)
			{
				System.out.printf(
						"\tAny account with Id %s has not been found!\n",
						accountId);
			}
		return 0;
	}
	
	public static boolean checkBelongsCustomerAccount(String id) // checks if a
																	// customer
																	// has any
																	// account
	{
		for (Account current : AccountList.getAccountList())
			if (current.getCustomerId().equals(id))
				return true;
		return false;
	}
	public static void displayAccounts() // display all account belonged to
											// customer for employee
	{
		boolean found = false;
		System.out.print("\tEnter Id of the customer > ");
		String id = newScanner.next();
		System.out.println();
		for (Account current : AccountList.getAccountList()) {
			if (current.getCustomerId().equals(id)) {
				System.out.println(current);
				found = true;
			}

		}
		if (!found)
			System.out.println("\tAny account belonging to the customer.");
	}

	public static void displayAccounts(String currentId) // display all account
															// belonged to
															// customer for
															// customer
	{
		boolean found = false;
		for (Account current : AccountList.getAccountList()) {
			if (current.getCustomerId().equals(currentId)) {
				System.out.println(current);
				found = true;
			}

		}
		if (!found)
			System.out.println("\tAny account belonging to the customer.");
	}
	public static void displayAllAccounts() {
		if (AccountList.getAccountList().size() > 0) {
			for (Account current : AccountList.getAccountList())
				System.out.println(current);
		} else
			System.out.println("\tAccount list is empty.");
	}
	public static void getMonthlyInteres(String Id) {
		System.out.print("\tEnter account Id to get a monthly interest > ");
		String searchParam = newScanner.next();
		System.out.println();
		for (Account current : AccountList.getAccountList()) {
			if (current.getCustomerId().equals(Id)
					&& current.getAccountId().equals(searchParam)) {
				if (current instanceof SavingAccount) {
					SavingAccount saAcc = (SavingAccount) current;
					System.out
							.printf(
									"\tThe account %s has a current balance CAD %.2f. The monthly interest equal CAD %.2f.",
									searchParam,
									saAcc.getCurrentBalance(),
									saAcc.getCurrentBalance()
											* (saAcc.getAnnualInterestRate() / (12 * 100)));
					System.out.println();
					break;
				} else {
					System.out
							.printf(
									"\tThe account with Id %s does not containe monthly interest!\n",
									searchParam);
					System.out.println();
				}
			} else {
				System.out.printf(
						"\tAny account with Id %s has not been found!\n",
						searchParam);
				System.out.println();
			}
		}
	}

	public static void modifyAccount() {
		System.out.print("\tEnter Id of modifying account > ");
		String id = newScanner.next();
		System.out.println();
		for (Account current : AccountList.getAccountList()) {
			if (current instanceof SavingAccount) {
				SavingAccount saAcc = (SavingAccount) current;
				if (saAcc.getAccountId().equals(id)) {
					System.out
							.printf(
									"\tThe account %s has a current annual interest rate %.2f",
									id, saAcc.getAnnualInterestRate());
					System.out.println();
					System.out.println();
					System.out.print("\tEnter new interest rate(%) > ");
					String newRate = newScanner.next();
					System.out.println();
					if (ValidationCommon.validateDouble(newRate)) {
						saAcc
								.setAnnualInterestRate(Double
										.parseDouble(newRate));
						System.out
								.printf(
										"\tThe account %s has a new annual interest rate %.2f",
										id, saAcc.getAnnualInterestRate());
						System.out.println();
						break;
					} else {
						System.out.printf("\tWrong input!", id);
						System.out.println();
						break;
					}

				} else {
					System.out.printf(
							"\tThe account with Id %s cannot be modified!", id);
					System.out.println();
				}
			}
		}
	}
}
