package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6151084720858051506L;
	private int userId;
	private int accountId;
	private String accountName;
	private double balance;
	private String accountType;

	// private CurrentValues currentValues = CurrentValues.getInstance();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		result = prime * result + accountId;

		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (userId != other.userId)
			return false;
		if (accountId != other.accountId)
			return false;

		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [userId=" + userId + "accountId=" + accountId + ", accountName=" + accountName + ", balance="
				+ balance + ", accountType=" + accountType + "]";
	}

	public Account(int userId, int accountId, String accountName, double balance, String accountType,
			ArrayList<String> transHistory) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
		this.accountType = accountType;

	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

}
