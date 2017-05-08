package prod;

import java.util.Scanner;
import business.*;

public final class ValidationCommon {
	static Scanner newScanner = new Scanner(System.in); 
	
	public static boolean validateDouble(String val)
	{
		 try {
		        double i = Double.parseDouble(val);
		        return true;
		    }
		 catch(NumberFormatException e)
		 {
			 return false;
		 }
	}
	public static boolean validateInt(String val)
			{
				 try {
				        int i = Integer.parseInt(val);
				        return true;
				    }
				 catch(NumberFormatException e)
				 {
					 return false;
				 }
			} 

	public static boolean validateDay(String val)
	{
		if(validateInt(val) && Integer.parseInt(val) > 0 && Integer.parseInt(val) <= 31)
				return true;
		return false;
	}
	
	public static boolean validateMonth(String val)
	{
		if(validateInt(val) && Integer.parseInt(val) > 0 && Integer.parseInt(val) <= 12)
				return true;
		return false;
	}
	
	public static boolean validateYear(String val)
	{
		if(validateInt(val) && val.length() == 4)
			return true;
		else return false;
	}


	public static int getUserRole()
	{
		while(true)
		{
			System.out.println("\n\tChoise one of:");
			System.out.println("\n\t\t1.	Enter as bank employee.");
			System.out.println("\t\t2.	Enter as bank customer.");
			System.out.println("\t\t3.	Exit application.");
			System.out.print("\n\t\t> ");
			
			String userRole = newScanner.next();
			System.out.println();
			if(userRole.equals("1") || userRole.equals("2") || userRole.equals("3") )
			{
				return Integer.parseInt(userRole);
			}
			else System.out.println("\tIncorrect choise!");
					
		}
	}

	public static int getEmployeeFunctions()
	{	
		while(true)
		{
			System.out.println("\n\t1.	Add the customer");
			System.out.println("\t2.	Add account to customer");
			System.out.println("\t3.	Modify interest rate of saving account");
			System.out.println("\t4.	Display all customers");
			System.out.println("\t5.	Display all accounts");
			System.out.println("\t6.	Display all accounts belonging to particular customer");
			System.out.println("\t7.	Search the customer");
			System.out.println("\t8.	Search the account");
			System.out.println("\t9.	Remove the customer");
			System.out.println("\t10.	Remove the account");
			System.out.println("\t11.	Display all transactions");
			System.out.println("\t12.	Exit menu");
			System.out.print("\n\t> ");

			String employeeFunctions = newScanner.next();
			System.out.println();
			if(	employeeFunctions.equals("1") || employeeFunctions.equals("2") ||
				employeeFunctions.equals("3") || employeeFunctions.equals("4") || 
				employeeFunctions.equals("5") || employeeFunctions.equals("6") || 
				employeeFunctions.equals("7") || employeeFunctions.equals("8") ||
				employeeFunctions.equals("9") || employeeFunctions.equals("10") ||
				employeeFunctions.equals("11") || employeeFunctions.equals("12"))
			{
				return Integer.parseInt(employeeFunctions);
			}
			else System.out.println("\tIncorrect choise!");
		}
	}
	
	public static int getCustomerFunctions()
	{	
		while(true)
		{

			System.out.println("\n\t1.	Make deposit");
			System.out.println("\t2.	Make withdrawal");
			System.out.println("\t3.	Display accounts");
			System.out.println("\t4.	Search account");
			System.out.println("\t5.	Calculate monthly interest");
			System.out.println("\t6.	Modify Login and Pin");
			System.out.println("\t7.	Display your transactions");
			System.out.println("\t8.	Exit menu");
			System.out.print("\n\t> ");

			String employeeFunctions = newScanner.next();
			System.out.println();
			if(	employeeFunctions.equals("1") || employeeFunctions.equals("2") ||
				employeeFunctions.equals("3") || employeeFunctions.equals("4") || 
				employeeFunctions.equals("5") || employeeFunctions.equals("6") || 
				employeeFunctions.equals("7") || employeeFunctions.equals("8"))
			{
				return Integer.parseInt(employeeFunctions);
			}
			else System.out.println("\tIncorrect choise!");
		}
	}

	public static boolean validateEmployee()
	{
		System.out.print("\tEnter login > ");
		String login = newScanner.next();
		System.out.println();
		System.out.print("\tEnter pin > ");
		String pin = newScanner.next();
		System.out.println();
		if (pin.equals(Employee.getEmployeePin()) && login.equals(Employee.getEmployeeLogin()))
			return true;
		else 
			{
			System.out.println("\tWrong identification, repeat!");
			return false;
			}
	}
}

