package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;


import com.revature.beans.User;

import com.revature.daos.UserDao;
import com.revature.util.AppState;

public class LoginScreen implements Screen {
	private AppState state = AppState.state;
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	private Logger log = Logger.getRootLogger();
	
	
	@Override
	public Screen start() {
	
		log.debug("started login screen");
		System.out.println("Enter Username or type Register to sign up: ");
		String username = scan.nextLine();
		if ("register".equalsIgnoreCase(username)) {
			return new RegisterUserScreen();
		}
		
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		

	
		User currentUser = ud.findByUsernameAndPassword(username, password);
		if (currentUser != null) {
			state.setCurrentUser(currentUser);
			//currentValues.currentAccount = null;
			log.info("user succefully logged in");
			log.info("welcome " + currentUser);
			return new HomeScreen();
		}

		System.out.println("unable to login");
		return this;
	}
}

