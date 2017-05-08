package business;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
public Date ()
{
	this.month = 0;
	this.day = 0;
	this.year = 0;
}

public Date ( int month, int day, int year)
{
	this.month = month;
	this.day = day;
	this.year = year;
}

public String toString()
{
	return this.month + "/" + this.day + "/" + this.year;
}
}
