package business;

public class CheckingAccount extends Account{
	private double minBalance;
	public double getMinBalance() {
		return this.minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public CheckingAccount() {
		super();
		this.minBalance = 0;
	}

	public CheckingAccount(	String customerId, 
							String accountId,
							double minBalance,
							int month,
							int day,
							int year) {
		super(	customerId,
				accountId,
				minBalance,
				month,
				day,
				year);
				
		this.minBalance = minBalance;

	}

	public String toString()
	{
		return 	super.toString() + 
				", min balace CAD: " + this.minBalance;
	}
	}
