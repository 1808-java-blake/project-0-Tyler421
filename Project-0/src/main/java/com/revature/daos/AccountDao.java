package com.revature.daos;

import java.util.List;

import com.revature.beans.Account;

public interface AccountDao {
public static final AccountDao currentAccountDao = new AccountDaoJdbc();
	
	int createAccount(Account u);
	List<Account> findByUserId(int userId);
	void updateAccount(Account u);
	void deleteAccount(Account u);

}

