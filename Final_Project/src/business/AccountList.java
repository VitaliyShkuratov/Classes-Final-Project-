package business;

import java.util.ArrayList;

public final class AccountList {
	private static ArrayList<Account> accountList = new ArrayList<Account>();
	
	public static ArrayList<Account> getAccountList() {
		return AccountList.accountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		AccountList.accountList = accountList;
	}
	
	public static void addAccount(	String cusId, 
									String accId,
									double balance,
									int month,
									int day,
									int year)
	{
		accountList.add(new CheckingAccount(cusId, 
											accId,
											balance, 
											month,
											day,
											year));

	}
	
	public static void addAccount(	String cusId, 
									String accId,
									double interestRate,
									double balance,
									int month,
									int day,
									int year)
	{
		accountList.add(new SavingAccount(	cusId, 
											accId,
											interestRate, 
											balance, 
											month,
											day,
											year));
	}
	
	
	public static void removeAccount(Account current)
	{	
		accountList.remove(current);
	}
}