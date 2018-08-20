package com.revature.screens;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.CurrentValues;
import com.revature.daos.AccountDao;
import com.revature.daos.UserDao;

public class AddMoneyScreen implements Screen {

	private CurrentValues currentValues = CurrentValues.getInstance();
	private Scanner scan = new Scanner(System.in);
	private AccountDao ad = AccountDao.currentAccountDao;
	private UserDao ud = UserDao.currentUserDao;

	@Override
	public Screen start() throws InterruptedException {
		if (currentValues.currentUser.getAccounts() == null) {
			System.out.println("No accounts to display, returning to menu...");
			Thread.sleep(3000);
			return new HomeScreen();
		}
		ArrayList<String> accounts = currentValues.currentUser.getAccounts();
		System.out.println("Accounts:");
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println((i + 1) + ": " + accounts.get(i));
		}
		System.out.println("enter the name of the account you want to deposit in:");

//Needs new implementation: 		
//		String selectedAccount = scan.nextLine();
//		Account a = new Account();
//
//		if (accounts.contains(selectedAccount)) {
//			a = ad.findByAccountName(selectedAccount);
//			if (a == null) {
//				System.out.println("account file not found");
//				return this;
//			}
//			System.out.println("enter the amount you want to deposit:");
//			String selectedAmount = scan.nextLine();
//
//			// currentValues.currentAccount = a;
////			a.depositFunds(depAmount);
//			return null;
//		}
		return null;

	}
}
