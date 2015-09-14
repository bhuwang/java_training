
package com.lftechnology.java.training.krishna.employeemanagement.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lftechnology.java.training.krishna.employeemanagement.domain.Employee;
import com.lftechnology.java.training.krishna.employeemanagement.domain.User;
import com.lftechnology.java.training.krishna.employeemanagement.service.employee.impl.EmployeeServiceImpl;
import com.lftechnology.java.training.krishna.employeemanagement.service.user.impl.UserServiceImpl;
import com.lftechnology.java.training.krishna.employeemanagement.utils.Role;
import com.lftechnology.java.training.krishna.employeemanagement.utils.ValidationUtils;

/**
 *  The application should have the following features:
 * 1. Application will have two users: a. admin user b. normal user
 * 2. Admin user will have option to add/delete user
 * 3. Normal user can view/search employee
 * 4. admin user will be generated by the system by default
 * 5. admin user will add normal user
 */

/**
 * This program used for simple employeement system
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class LoginController {

	public static UserServiceImpl userServiceImpl;
	public static EmployeeServiceImpl employeeServiceImpl;
	public static User user;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		authentiateUser(scanner);

	}

	/**
	 * This method is used to authenticate user
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void authentiateUser(Scanner scanner) {

		showLoginTitle();
		user = loginAction(scanner);
		while (user == null) {
			System.out.println("Invalid username and password. Please try again.\n");
			loginAction(scanner);
		}
		showMainTitle(user.getUsername());
		showMainMenu(scanner, user.getId());
	}

	/**
	 * This method is used to display title of login
	 *
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void showLoginTitle() {

		System.out.println("\n"
			+ "*******************************************************" + "\n"
			+ "**                                                   **" + "\n"
			+ "**              Login                                **" + "\n"
			+ "**                                                   **" + "\n"
			+ "*******************************************************" + "\n");
	}

	/**
	 * This method is used to login using user information
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @return User
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static User loginAction(Scanner scanner) {

		System.out.println("Please enter the username::");
		String username = ValidationUtils.emptyValidation(scanner, "Username");
		System.out.println("Please enter the password::");
		String password = ValidationUtils.emptyValidation(scanner, "Password");
		userServiceImpl = new UserServiceImpl();
		user = userServiceImpl.login(username, password);
		return user;
	}

	/**
	 * This method is used to display username
	 *
	 * @param username
	 *            {@link String}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void showMainTitle(String username) {

		System.out.println("\n" +
			"*******************************************************" + "\n" +
			"**                                                   **" + "\n" +
			"**              Welcome To " + username + "                   **" +
			"\n" + "**                                                   **" +
			"\n" + "*******************************************************" +
			"\n");
	}

	/**
	 * This method is used to display main menu
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @param id
	 *            {@link int}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void showMainMenu(Scanner scanner, int id) {

		employeeServiceImpl = new EmployeeServiceImpl();
		Employee employee = employeeServiceImpl.findById(id);
		if (employee.getRole().equalsIgnoreCase(Role.Admin.toString())) {
			System.out.println(""
				+ "**   MAIN MENU (Please choose the desired action) *****"
				+ "\n"
				+ "**   1. Add New User                                 **"
				+ "\n"
				+ "**   2. Delete User                                  **"
				+ "\n"
				+ "**   3. Terminated User                              **"
				+ "\n"
				+ "**   4. Quit OR Logout                               **"
				+ "\n"
				+ "**   5. Search User                                  **"
				+ "\n"
				+ "*******************************************************"
				+ "\n");

			chooseAdminUserAction(scanner, id);
		}
		else {
			System.out.println(""
				+ "**   MAIN MENU (Please choose the desired action) *****"
				+ "\n"
				+ "**   4. Quit OR Logout                               **"
				+ "\n"
				+ "**   5. Search User                                  **"
				+ "\n"
				+ "**   6. Edit Information                             **"
				+ "\n"
				+ "*******************************************************"
				+ "\n");

			chooseNormalUserAction(scanner, id);
		}

	}

	/**
	 * This method is used to choose admin user action such as add employee,
	 * delete user
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @param id
	 *            {@link int}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void chooseAdminUserAction(Scanner scanner, int id) {

		int choice = ValidationUtils.numberValidation(scanner);

		switch (choice) {
		case 1:
			addEmployee(scanner);
			break;
		case 2:
			deleteUser(scanner);
			break;
		case 3:
			terminateUser(scanner);
			break;
		case 4:
			authentiateUser(scanner);
			break;
		case 5:
			searchEmployee(scanner);
			break;
		default:
			System.out.println("Please choose the desired action.\n");
			break;
		}
		showMainMenu(scanner, id);
	}

	/**
	 * This method is used to choose normal user action such as search employee
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @param id
	 *            {@link int}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void chooseNormalUserAction(Scanner scanner, int id) {

		int choice = ValidationUtils.numberValidation(scanner);

		switch (choice) {
		case 4:
			authentiateUser(scanner);
			break;
		case 5:
			searchEmployee(scanner);
			break;
		case 6:
			editEmployee(scanner, id);
			break;
		default:
			System.out.println("Please choose the desired action.\n");
			break;
		}
		showMainMenu(scanner, id);
	}

	/**
	 * This method is used to add employee from user input
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void addEmployee(Scanner scanner) {

		System.out.println("************ Collecting Employee Information ************\n");
		System.out.println("Please enter the username::");
		String username = ValidationUtils.emptyValidation(scanner, "Username");
		System.out.println("Please enter the password::");
		String password = ValidationUtils.emptyValidation(scanner, "Password");
		System.out.println("Please enter the full name::");
		String fullname = ValidationUtils.emptyValidation(scanner, "Full Name");
		System.out.println("Please enter the department::");
		String department =
			ValidationUtils.emptyValidation(scanner, "Department");
		System.out.println("Please enter the address::");
		String address = ValidationUtils.emptyValidation(scanner, "Address");
		System.out.println("Please choose the following role::\n");
		String role = chooseRole(scanner);
		employeeServiceImpl = new EmployeeServiceImpl();
		Employee emp =
			employeeServiceImpl.saveEmployee(
				username, password, fullname, department, address, role);
		if (emp == null) {
			System.out.println("Username already exists. Please try again.\n");
		}
		else if (emp.getId() > 0) {
			System.out.println(fullname + " is added successfully.\n");
		}

	}

	/**
	 * This method is used to search employee using user input
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void searchEmployee(Scanner scanner) {

		List<Employee> empList = new ArrayList<Employee>();
		System.out.println("Please enter the key::\n");
		String key = scanner.nextLine();
		employeeServiceImpl = new EmployeeServiceImpl();
		empList = employeeServiceImpl.findAll(key);
		System.out.println("************ Employee List ************\n");
		String leftAlignFormat = "| %-19s | %-19s | %-21s | %-19s | %-15s |%n";
		System.out.format("+---------------------+---------------------+-----------------------+---------------------+-----------------+%n");
		System.out.printf("| Username            | Fullname            | Department            | Address             | Role            |%n");
		System.out.format("+---------------------+---------------------+-----------------------+---------------------+-----------------+%n");
		for (Employee emp : empList) {
			System.out.format(
				leftAlignFormat, emp.getUsername(), emp.getFullname(),
				emp.getDepartment(), emp.getAddress(), emp.getRole());
		}
		System.out.format("+---------------------+---------------------+-----------------------+-----------------------+----------------+%n");
		System.out.println("\n");
	}

	/**
	 * This method is used to delete employee using user input
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void deleteUser(Scanner scanner) {

		System.out.println("Do you want to delete User? Please enter the fullname::\n");
		String fullname = ValidationUtils.emptyValidation(scanner, "Fullname");
		employeeServiceImpl = new EmployeeServiceImpl();
		boolean isDeleted = employeeServiceImpl.delete(fullname);
		if (isDeleted) {
			System.out.println(fullname + " is deleted successfully.\n");
		}
	}

	/**
	 * This method is used to terminate employee, delete use
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void terminateUser(Scanner scanner) {

		System.out.println("Do you want to terminate User? Please enter the fullname::\n");
		String fullname = ValidationUtils.emptyValidation(scanner, "Fullname");
		employeeServiceImpl = new EmployeeServiceImpl();
		boolean isTerminated = employeeServiceImpl.terminate(fullname);
		if (isTerminated) {
			System.out.println(fullname + " is terminated successfully.\n");
		}

	}

	/**
	 * This method is used to edit employee information
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @param id
	 *            {@link int}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void editEmployee(Scanner scanner, int id) {

		System.out.println("Do you want to edit your information? Please choose the options::\n");
		System.out.println("1. Full Name");
		System.out.println("2. Department");
		System.out.println("3. Address");
		String fullname = null;
		String department = null;
		String address = null;
		String message = null;
		int choice = ValidationUtils.numberValidation(scanner);
		employeeServiceImpl = new EmployeeServiceImpl();
		switch (choice) {
		case 1:
			System.out.println("Please enter the full name::");
			fullname = ValidationUtils.emptyValidation(scanner, "Full Name");
			break;
		case 2:
			System.out.println("Please enter the department::");
			department = ValidationUtils.emptyValidation(scanner, "Department");
			break;
		case 3:
			System.out.println("Please enter the address::");
			address = ValidationUtils.emptyValidation(scanner, "Address");
			break;
		default:
			System.out.println("Please choose the desired action.\n");
			break;
		}
		Employee emp =
			employeeServiceImpl.updateEmployee(
				id, fullname, department, address);
		switch (choice) {
		case 1:
			message = "Fullname";
			break;
		case 2:
			message = "Department";
			break;
		case 3:
			message = "Address";
			break;
		}
		if (emp.getId() > 0) {

			System.out.println(message + " is updated successfully.\n");
		}
	}

	/**
	 * This method is used to display employee role
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static void roleOptions(Scanner scanner) {

		System.out.println("***********************************************"
			+ "\n" + "**   1. Admin                                 **" + "\n"
			+ "**   2. User                                  **" + "\n"
			+ "************************************************" + "\n");
	}

	/**
	 * This method is used to choose employee role
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @return role {@link String}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static String chooseRole(Scanner scanner) {

		String role = null;
		int choice = 0;
		roleOptions(scanner);
		while (true) {
			choice = ValidationUtils.numberValidation(scanner);
			if (choice == 1) {
				role = Role.Admin.toString();
				break;
			}
			else if (choice == 2) {
				role = Role.User.toString();
				break;
			}
			else {
				System.out.println("Please choose the desired role::\n");
				roleOptions(scanner);
			}

		}
		return role;

	}
}
