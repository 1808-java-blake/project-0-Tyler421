package com.revature.screens;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.daos.AccountDao;
import com.revature.daos.TransactionDao;
import com.revature.util.AppState;

public class AddMoneyScreen implements Screen {

	private AppState state = AppState.state;
	private Scanner scan = new Scanner(System.in);
	private AccountDao ad = AccountDao.currentAccountDao;
	private TransactionDao td = TransactionDao.currentTransactionDao;
	private Logger log = Logger.getRootLogger();

	@Override
	public Screen start() throws InterruptedException {

		User currentUser = state.getCurrentUser();
		Account currentAccount = new Account();
		Transaction t = new Transaction();
		if (currentUser == null) {
			return new LoginScreen();
		}

		try {
			List<Account> accounts = ad.findByUserId(state.getCurrentUser().getId());
			accounts.stream().forEach((each) -> {
				System.out.println(each);
			});
			System.out.println("Enter the account name of the account you wish to deposit in: ");
			currentAccount = ad.findByAccountName(scan.nextLine());
			//state.getCurrentAccount();
			System.out.println(currentAccount);
			//System.out.println(state.getCurrentAccount());
			double balance;
			System.out.println("How much would you like to deposit?");

			System.out.println("Balance: " + currentAccount.getBalance());
			String depositAmount = scan.nextLine();

			System.out.println(depositAmount + " + " + currentAccount.getBalance());
			System.out.println(balance = Double.valueOf(depositAmount) + currentAccount.getBalance());
			currentAccount.setBalance(balance);
			ad.updateUser(currentAccount);
			System.out.println("");
			log.info("Sucsesfully deposited space bucks!");
			System.out.println("");
			t.setAccountId(currentAccount.getAccountId());
			t.setTransactionInfo(" You added: " + depositAmount);
			t.setTransactionTotal(currentAccount.getBalance());
			td.createTransaction(t);

		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}

		return new HomeScreen();

	}
}
