package business;

import java.util.Scanner;

public class Customer {
	private String customerId;
	private String customerFn;
	private String customerLn;
	private String customerLogin;
	private String customerPassword;
		
	Scanner newScanner = new Scanner(System.in);
	
	public String getCustomerLogin() {
		return this.customerLogin;
	}
	public void setCustomerLogin(String customerLogin) {
		this.customerLogin = customerLogin;
	}
	public String getCustomerPassword() {
		return this.customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
		
	public String getCustomerId()
	{
		return this.customerId;
	}
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}
	
	public String getCustomerFn()
	{
		return this.customerFn;
	}
	public void setCustomerFn(String customerFn)
	{
		this.customerFn = customerFn;
	}
	public String getCustomerLn()
	{
		return this.customerLn;
	}
	public void setCustomerLn(String customerLn)
	{
		this.customerLn = customerLn;
	}
	
	public Customer()
	{
		this.customerId = "unknown";
		this.customerLn = "unknown";
		this.customerFn = "unknown";
		this.customerLogin = "unknown";
		this.customerPassword = "unknown";
	}
	public Customer(String customerId,
					String customerLn,
					String customerFn,
					String customerLogin,
					String customerPassword)
	{
		this.customerId = customerId;
		this.customerLn = customerLn;
		this.customerFn = customerFn;
		this.customerLogin = customerLogin;
		this.customerPassword = customerPassword;
	}
	
	
	public String toString()
	{
		return	"Customer ID: " + this.customerId + 
				", Name: " + this.customerLn + ", " + this.customerFn;
	}
	
}
