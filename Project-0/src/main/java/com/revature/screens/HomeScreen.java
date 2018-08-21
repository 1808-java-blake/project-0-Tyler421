package com.revature.screens;


import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;

import com.revature.daos.AccountDao;
import com.revature.daos.TransactionDao;
import com.revature.util.AppState;

public class HomeScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private AccountDao ad = AccountDao.currentAccountDao;
	private AppState state = AppState.state;
	private TransactionDao td = TransactionDao.currentTransactionDao;

	public Screen start() {
		System.out.println("");
		System.out.println("Welcome to SPACE BALLS THE BANK!");
		System.out.println("");
		System.out.println("Please choose from the following options:");
		System.out.println("Enter 1 to deposit space bucks");
		System.out.println("Enter 2 to withdraw space bucks");
		System.out.println("Enter 3 to view all accounts");
		System.out.println("Enter 4 to view transaction history");
		System.out.println("Enter 5 to create a new account");
		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			return new AddMoneyScreen();
		case "2":
			return new WithdrawMoneyScreen();
		case "3":
			List<Account> accounts = ad.findByUserId(state.getCurrentUser().getId());
			accounts.stream().forEach((each) -> {
				System.out.println(each);
			});
			break;

		case "4":
			System.out.println("Enter the account id for the account history you want to view: ");
			td.getTransaction(scan.nextInt());
			break;
		case "5":
			return new RegisterAccountScreen();
		default:
			break;
		}

		return this;
	}

}
