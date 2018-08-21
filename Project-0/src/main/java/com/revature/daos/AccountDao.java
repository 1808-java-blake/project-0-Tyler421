package com.revature.daos;

import java.util.List;

import com.revature.beans.Account;

public interface AccountDao {
	public static final AccountDao currentAccountDao = new AccountDaoJdbc();

	Account viewAllAccounts();

	Account findByAccountName(String accountName);

	Account getBankAccount(int id);

	void createAccount(Account u);

	List<Account> findByUserId(int userId);


	void updateAccount(Account u);

	void deleteAccount(Account u);

	void updateUser(Account ad);

}
