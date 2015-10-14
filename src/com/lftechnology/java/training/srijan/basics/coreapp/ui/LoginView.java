
package com.lftechnology.java.training.srijan.basics.coreapp.ui;

import com.lftechnology.java.training.srijan.basics.coreapp.controller.LoginController;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.UserRole;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginView {

	private static final Logger LOGGER =
		Logger.getLogger(LoginView.class.getName());

	private LoginView() {

	}

	public static void main(String[] args) {

		login();
	}

	/**
	 * <p>Inputs password and user name from user and determines role of
	 * user</p>
	 * 
	 * @author srijan
	 */
	public static void login() {

		Employee e = new Employee();
		String userName = "";
		String password = "";
		Scanner inputScanner = null;
		LoginController loginControl = new LoginController();
		Boolean loginStatus = false;

		try {
			do {
				inputScanner = new Scanner(System.in);
				LOGGER.info("Enter UserName:");
				userName = inputScanner.nextLine();
				LOGGER.info("Enter Password:");
				password = inputScanner.nextLine();
				e = loginControl.save(userName, password, inputScanner);
				if (UserRole.ADMIN.equals(e.getUserRole()) ||
					UserRole.NORMAL.equals(e.getUserRole())) {
					LOGGER.log(
						Level.INFO, "Logged Successful - User Type- {0}",
						e.getUserRole());
					loginStatus = true;
				}
				else{
					LOGGER.log(Level.INFO, "Entry not found in Database");
				}
			}
			while (loginStatus.equals(false));
			loginControl.determineUserRole(inputScanner, e);
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Error {0}", ex);
		}
		finally {
			inputScanner.close();
		}

	}
}
