package business;

public class SavingAccount extends Account{

	private double annualInterestRate;
	private double savingBalance;
	
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public double getSavingBalance() {
		return this.savingBalance;
	}
	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}

	public SavingAccount() {
		super();
		this.annualInterestRate = 0;
		this.savingBalance = 0;
	}
	public SavingAccount(	String customerId,
							String accountId,
							double annualInterestRate,
							double savingBalance,
							int month,
							int day,
							int year) {
		super(	customerId,
				accountId,
				savingBalance,
				month,
				day,
				year);
		

		this.annualInterestRate = annualInterestRate;
		this.savingBalance = savingBalance;
	}
	
	public String toString()
	{
		return 	super.toString() + 
				", saving balance CAD: " + this.savingBalance + 
				", annual interest rate(%): " + this.annualInterestRate;
	}
}
