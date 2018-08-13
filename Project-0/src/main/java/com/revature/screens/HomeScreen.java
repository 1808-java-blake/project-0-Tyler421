package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.CurrentValues;
import com.revature.beans.User;
import com.revature.daos.UserDao;

public class HomeScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private CurrentValues currentValues = CurrentValues.getInstance();
	private UserDao ud = UserDao.currentUserDao;
	
	

	public Screen start() {
		
		
		System.out.println("current user = " + currentValues.currentUser.getUsername());
		
		System.out.println("Please chose from following options:");
		System.out.println("Enter 1 to deposit funds");
		System.out.println("Enter 2 to withdraw funds");
		System.out.println("Enter 3 to view balance");
		System.out.println("Enter 4 to view transaction history");
		System.out.println("Enter 5 to create a new account");
		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			System.out.println("selected 1 not yet implemented that screen");
			break;
		case "2":
			System.out.println("selected 2 not yet implemented that screen");
			break;
		case "3":
			return new ViewAccountScreen();
			
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
