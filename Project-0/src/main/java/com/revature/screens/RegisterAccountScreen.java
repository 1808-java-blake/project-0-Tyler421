package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.daos.AccountDao;
import com.revature.util.AppState;

public class RegisterAccountScreen implements Screen {
	private AppState state = AppState.state;
	private Logger log = Logger.getRootLogger();
	private Scanner scan = new Scanner(System.in);
	private AccountDao ad = AccountDao.currentAccountDao;

	@Override
	public Screen start() {
		User currentUser = state.getCurrentUser();
		if (currentUser == null) {
			return new LoginScreen();
		}
		try {
			Account a = new Account();
			System.out.println("Enter the name for the account: ");
			a.setAccountName(scan.nextLine());
			System.out.println("Is it a Checking or Savings account?");

			a.setAccountType(scan.nextLine());
			a.setBalance(0.00);
			a.setUserId(currentUser.getId());

			ad.createAccount(a);

			log.info("created account " + a);
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");

		}
		return new HomeScreen();
	}

}
