package com.revature.screens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.CurrentValues;
import com.revature.daos.AccountDao;
import com.revature.daos.UserDao;
import com.revature.util.AppState;
import com.revature.util.ConnectionUtil;

public class AddMoneyScreen implements Screen {

	private AppState state = AppState.state;
	private Scanner scan = new Scanner(System.in);
	private AccountDao ad = AccountDao.currentAccountDao;
	private UserDao ud = UserDao.currentUserDao;
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.cu;

	@Override
	public Screen start() throws InterruptedException {
//		if (state.getCurrentUser().getAccounts() == null) {
//			System.out.println("No accounts to display, returning to menu...");
//			Thread.sleep(3000);
//			return new HomeScreen();
//		}
		List<Account> accounts = ad.findByUserId(state.getCurrentUser().getId());
		accounts.stream().forEach((each) -> {
			System.out.println(each);
		});
		System.out.println("enter the name of the account you want to deposit in:");

		String selectedAccount = scan.nextLine();
		List<Account> a = ad.findByAccountName(selectedAccount);
		log.trace("Account specified ready for deposit");
		System.out.println("enter the amount you want to deposit:");
		String selectedAmount = scan.nextLine();
		double selectedAmountAsDouble = Double.parseDouble(selectedAmount);
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance=? WHERE accountname=?");
			ps.setDouble(1, selectedAmountAsDouble);
			ps.setString(2, selectedAccount);
			ResultSet rs = ps.executeQuery();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new HomeScreen();

	}
}
