
package com.lftechnology.java.training.dipak.employeemanagement.ui;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.LoggerFormatter;
import com.lftechnology.java.training.dipak.employeemanagement.controller.EmployeeController;
import com.lftechnology.java.training.dipak.employeemanagement.controller.LogOutController;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

/**
 * <p>This class contains method that contains options for the admin access.</p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class AdminPanel {

	private static final Logger LOGGER =
		Logger.getLogger(AdminPanel.class.getName());

	static {
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.FINEST);
		LOGGER.addHandler(ch);
		LOGGER.setUseParentHandlers(false);

		LoggerFormatter myFormat = new LoggerFormatter();

		ch.setFormatter(myFormat);
	}

	/**
	 * <p>This method allows the admin to choose the operations that can be
	 * performed by an admin.</p>
	 * 
	 * @param employee
	 * @param sc
	 */
	public void displayPanel(Employee employee, Scanner sc) {

		Employee e = new Employee();
		e = DuplicateEmployee.duplicateEmployeeObject(employee, e);

		EmployeeController ec = new EmployeeController();
		for (;;) {
			try {
				LOGGER.info("Welcome to the admin panel...\n");
				LOGGER.info("1.Add User");
				LOGGER.info("2.Remove user");
				LOGGER.info("3.Search/View user");
				LOGGER.info("4.Edit your personal info");
				LOGGER.info("5.Exit");
				LOGGER.info("Please Enter your choices::");
				int choice = Math.abs(Integer.parseInt(sc.nextLine()));
				switch (choice) {
				case 1:
					ec.addEmployee(e, sc);
					break;
				case 2:
					ec.terminateEmployee(e, sc);
					break;
				case 3:
					ec.viewEmployee(e, sc);
					break;
				case 4:
					employee = ec.editEmployeeDetails(employee, sc);
					break;
				case 5:
					e = LogOutController.logOut(e, sc);
					break;

				default:
					LOGGER.info("Illegal choice. Please re-enter your choice.");
					break;
				}
			}
			catch (Exception ex) {
				LOGGER.log(Level.INFO, "{0}", ex);
			}
			if (UserType.INVALID.equals(e.getRole())) {
				return;
			}
		}

	}
}
