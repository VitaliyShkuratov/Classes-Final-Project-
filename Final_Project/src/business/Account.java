package business;

public abstract class Account {
	
	private String customerId;
	private String accountId;
	private Date openedDate;
	private double currentBalance;

	
	public String getAccountId() {
		return this.accountId;
	}
	public void setSavingAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public double getCurrentBalance() {
		return this.currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public Date getOpenedDate() {
		return this.openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}
	
	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public Account()
	{
		this.customerId = "unknown";
		this.accountId = "unknown";
		this.currentBalance = 0;
		this.openedDate = new Date(00,00,0000);
	}
	public Account(	String customerId,
					String accountId,
					double balance,
					int month,
					int day,
					int year)
	{
		this.customerId = customerId;
		this.accountId = accountId;
		this.currentBalance = balance;
		this.openedDate = new Date(month, day, year);
	}
public String toString()
{
	return	"Customer Id: " + this.customerId + 
			", account Id: " + this.accountId + 
			", current balance CAD: " + this.currentBalance + 
			", opened: " + this.openedDate;
}
}
