package com.revature.daos;

import com.revature.beans.Transaction;

public interface TransactionDao {
	public static final TransactionDao currentTransactionDao = new TransactionDaoJdbc();

	Transaction getTransaction(int accountId);

	void createTransaction(Transaction t);

	Transaction getAllTransactions();
}
