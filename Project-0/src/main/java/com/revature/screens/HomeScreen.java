package com.revature.screens;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;

import com.revature.daos.AccountDao;

import com.revature.util.AppState;

public class HomeScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private AccountDao ad = AccountDao.currentAccountDao; 
	private AppState state = AppState.state;
	
	

	public Screen start() {
		
		System.out.println("Please chose from following options:");
		System.out.println("Enter 1 to deposit funds");
		System.out.println("Enter 2 to withdraw funds");
		System.out.println("Enter 3 to view all accounts");
		System.out.println("Enter 4 to view transaction history");
		System.out.println("Enter 5 to create a new account");
		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			return new AddMoneyScreen();
		case "2":
			System.out.println("selected 2 not yet implemented that screen");
			break;
		case "3":
			List<Account> accounts = ad.findByUserId(state.getCurrentUser().getId());
			accounts.stream().forEach((each) -> {
				System.out.println(each);
			}); break;
			
		case "4":
			System.out.println("selected 4 not yet implemented that screen");
			break;
		case "5":
			return new RegisterAccountScreen();
		default:
			break;
		}

		return this;
	}

}
