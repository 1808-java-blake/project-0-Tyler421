package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.CurrentValues;
import com.revature.daos.AccountDao;
import com.revature.daos.UserDao;

public class RegisterAccountScreen implements Screen {
	private CurrentValues currentValues = CurrentValues.getInstance();
	private Scanner scan = new Scanner(System.in);
	private AccountDao ad = AccountDao.currentAccountDao;
	private UserDao ud = UserDao.currentUserDao;

	@Override
	public Screen start() {
		Account a = new Account();
		System.out.println("Enter new account number");
		a.setAccountName(scan.nextLine());
		System.out.println("Enter account type");
		a.setAccountType(scan.nextLine());
		a.setBalance(0);
		
		
		
		//try {
		    ad.createAccount(a);
		    //System.out.println(currentValues.currentAccount);
			currentValues.currentAccount = a;
			currentValues.currentUser.addaccount(a.getAccountName());
			ud.updateUser(currentValues.currentUser);
		return new HomeScreen();
	}

}