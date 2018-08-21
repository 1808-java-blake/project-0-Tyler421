package com.revature.screens;

import java.util.Scanner;

import com.revature.daos.AccountDao;
import com.revature.daos.TransactionDao;

public class AdminScreen implements Screen {
	private TransactionDao td = TransactionDao.currentTransactionDao;
	private AccountDao ad = AccountDao.currentAccountDao;
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() throws InterruptedException {
		System.out.println("Greetings Darth Helmet!");
		System.out.println("Please select from the following options: ");
		System.out.println("Enter 1 to view all accounts");
		System.out.println("Enter 2 to view all transactions");
		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			ad.viewAllAccounts();

			return new AdminScreen();
		case "2":
			td.getAllTransactions();

			return new AdminScreen();
		}

		return this;
	}

}
