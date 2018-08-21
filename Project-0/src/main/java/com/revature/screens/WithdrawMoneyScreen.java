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

public class WithdrawMoneyScreen implements Screen {

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
			System.out.println("Enter the account name of the account you wish to withdraw from: ");
			currentAccount = ad.findByAccountName(scan.nextLine());

			System.out.println(currentAccount);

			double balance;
			System.out.println("How much would you like to withdraw?");

			System.out.println("Balance: " + currentAccount.getBalance());
			String withdrawAmount = scan.nextLine();

			System.out.println(currentAccount.getBalance() + " - " + withdrawAmount);
			System.out.println(balance = currentAccount.getBalance() - Double.valueOf(withdrawAmount));
			currentAccount.setBalance(balance);
			ad.updateUser(currentAccount);
			System.out.println("");
			log.info("Sucsesfully deposited space bucks!");
			System.out.println("");
			t.setAccountId(currentAccount.getAccountId());
			t.setTransactionInfo("You withdrew: " + withdrawAmount);
			t.setTransactionTotal(currentAccount.getBalance());
			td.createTransaction(t);

		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}

		return new HomeScreen();

	}
}