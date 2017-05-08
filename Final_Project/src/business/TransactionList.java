package business;


import java.util.ArrayList;

public final class TransactionList {
	
	private static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

	public static ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}


	public static void setTransactionList(ArrayList<Transaction> transactionList) {
		TransactionList.transactionList = transactionList;
	}


	public static void addTransaction(	int month,
										int day,
										int year,
										String accountId, 
										String transactionEntry, 
										double amountTransaction, 
										String descriptionTransaction)
	{
		transactionList.add(new Transaction(month,
											day,
											year,
											accountId, 
											transactionEntry, 
											amountTransaction,
											descriptionTransaction));
	}
}

