package business;

public final class Employee{
	private static String employeePin = "1234";
	private static String employeeLogin = "admin";
	
	public static String getEmployeePin()
	{
		return employeePin;
	}
	
	public static String getEmployeeLogin()
	{
		return employeeLogin;
	}
}
