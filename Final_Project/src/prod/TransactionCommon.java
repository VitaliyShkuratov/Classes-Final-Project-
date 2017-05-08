package prod;

import business.Account;
import business.AccountList;
import business.Transaction;
import business.TransactionList;

public final class TransactionCommon {
	
	public static void displayAllTransactions() {
		
		
		if (TransactionList.getTransactionList().size() > 0) {
			for (Transaction current : TransactionList.getTransactionList())
				System.out.println(current);
		} else
			System.out.println("\tTransaction list is empty.");
	}

	public static void displayAllTransactions(String customerId) {
		boolean found = false;
		String accountId = "";

		for (Account current : AccountList.getAccountList()) {
			if (current.getCustomerId().equals(customerId)) {
				accountId = current.getAccountId();
				
				for (Transaction cur : TransactionList.getTransactionList()) {
					if (cur.getAccountId().equals(accountId)) {
						System.out.println(cur);
					}
				}
				
				found = true;

			}
		}
		if (!found)
			System.out.println("\tAny account belonging to the customer.");
	}
}


