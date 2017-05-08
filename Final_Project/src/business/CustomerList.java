package business;

import java.util.ArrayList;

public final class CustomerList {
	
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();

	private static String currentCustomerId;
	
	public static String getCurrentCustomerId()
	{
		return CustomerList.currentCustomerId;
	}
	
	public static void setCurrentCustomerId(String currentCustomerId)
	{
		CustomerList.currentCustomerId = currentCustomerId;
	}
	
	public static ArrayList<Customer> getCustomerList() {
		return CustomerList.customerList;
	}
	public void setAccountList(ArrayList<Customer> customerList) {
		CustomerList.customerList = customerList;
	}

	
	public static void addCustomer(	String id,
									String ln,
									String fn,
									String log,
									String psw)
	{
		customerList.add(new Customer(id, ln, fn, log, psw));
	}
	
	public static void removeCustomer(Customer current)
	{
		customerList.remove(current);
	}
}
