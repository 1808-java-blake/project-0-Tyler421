package com.revature.beans;

public class Transaction {

	private int transactionId;
	private String transactionInfo;
	private double transactionTotal;
	private int accountId;

	public void setTransactionInfo(String transactionInfo) {
		this.transactionInfo = transactionInfo;
	}

	public double getTransactionTotal() {
		return transactionTotal;
	}

	public void setTransactionTotal(double transactionTotal) {
		this.transactionTotal = transactionTotal;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionInfo() {
		return transactionInfo;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transactionId, String transactionInfo, double transactionTotal, int accountId) {
		super();
		this.transactionId = transactionId;
		this.transactionInfo = transactionInfo;
		this.transactionTotal = transactionTotal;
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionInfo=" + transactionInfo
				+ ", transactionTotal=" + transactionTotal + ", accountId=" + accountId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + transactionId;
		result = prime * result + ((transactionInfo == null) ? 0 : transactionInfo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(transactionTotal);
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
		Transaction other = (Transaction) obj;
		if (accountId != other.accountId)
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionInfo == null) {
			if (other.transactionInfo != null)
				return false;
		} else if (!transactionInfo.equals(other.transactionInfo))
			return false;
		if (Double.doubleToLongBits(transactionTotal) != Double.doubleToLongBits(other.transactionTotal))
			return false;
		return true;
	}

}
