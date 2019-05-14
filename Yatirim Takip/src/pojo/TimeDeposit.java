package pojo;

import java.util.Date;

import constant.InterestPeriod;

public class TimeDeposit extends Entity{
	
	private double balance;
	private double interest;
	private InterestPeriod interestPeriod;
	private String username;

	public TimeDeposit(double balance, double interest, InterestPeriod interestPeriod, String username) {
		super();
		this.balance = balance;
		this.interest = interest;
		this.interestPeriod = interestPeriod;
		this.username = username;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public InterestPeriod getInterestPeriod() {
		return interestPeriod;
	}

	public void setInterestPeriod(InterestPeriod interestPeriod) {
		this.interestPeriod = interestPeriod;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return super.toString() 
				+ balance + "___" + interest + "___" + interestPeriod + "___" + username;
	}

}
