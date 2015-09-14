
package com.lftechnology.java.training.krishna.employeemanagement.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lftechnology.java.training.krishna.employeemanagement.domain.Employee;
import com.lftechnology.java.training.krishna.employeemanagement.domain.User;
import com.lftechnology.java.training.krishna.employeemanagement.service.employee.impl.EmployeeServiceImpl;
import com.lftechnology.java.training.krishna.employeemanagement.service.user.impl.UserServiceImpl;
import com.lftechnology.java.training.krishna.employeemanagement.utils.ValidationUtils;

public class LoginController {

	public static UserServiceImpl userServiceImpl;
	public static EmployeeServiceImpl employeeServiceImpl;
	public static User user;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		authentiateUser(scanner);

	}

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

	private static void showLoginTitle() {

		System.out.println("\n"
			+ "*******************************************************" + "\n"
			+ "**                                                   **" + "\n"
			+ "**              Login                                **" + "\n"
			+ "**                                                   **" + "\n"
			+ "*******************************************************" + "\n");
	}

	private static User loginAction(Scanner scanner) {

		System.out.println("Please enter the username::");
		String username = ValidationUtils.emptyValidation(scanner, "Username");
		System.out.println("Please enter the password::");
		String password = ValidationUtils.emptyValidation(scanner, "Password");
		userServiceImpl = new UserServiceImpl();
		user = userServiceImpl.login(username, password);
		return user;
	}

	private static void showMainTitle(String username) {

		System.out.println("\n" +
			"*******************************************************" + "\n" +
			"**                                                   **" + "\n" +
			"**              Welcome To " + username + "                   **" +
			"\n" + "**                                                   **" +
			"\n" + "*******************************************************" +
			"\n");
	}

	private static void showMainMenu(Scanner scanner, int id) {

		System.out.println(""
			+ "**   MAIN MENU (Please choose the desired action) *****" + "\n"
			+ "**   0. Quit OR Logout                               **" + "\n"
			+ "**   1. Add New User                                 **" + "\n"
			+ "**   2. Delete User                                  **" + "\n"
			+ "**   3. Terminated User                              **" + "\n"
			+ "**   4. Search User                                  **" + "\n"
			+ "**   5. Edit Information                             **" + "\n"
			+ "*******************************************************" + "\n");
		chooseAction(scanner, id);

	}

	private static void chooseAction(Scanner scanner, int id) {

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
			searchEmployee(scanner);
			break;
		case 5:
			editEmployee(scanner, id);
			break;
		case 0:
			authentiateUser(scanner);
			break;
		default:
			System.out.println("Please choose the desired action.\n");
			break;
		}
		showMainMenu(scanner, id);
	}

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
		System.out.println("Please enter the role::");
		String role = ValidationUtils.emptyValidation(scanner, "Role");
		employeeServiceImpl = new EmployeeServiceImpl();
		Employee emp =
			employeeServiceImpl.saveEmployee(
				username, password, fullname, department, address, role);
		if (emp.getId() > 0) {
			System.out.println(fullname + " is added successfully.\n");
		}

	}

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

	private static void deleteUser(Scanner scanner) {

		System.out.println("Do you want to delete User? Please enter the fullname::\n");
		String fullname = ValidationUtils.emptyValidation(scanner, "Fullname");
		employeeServiceImpl = new EmployeeServiceImpl();
		boolean isDeleted = employeeServiceImpl.delete(fullname);
		if (isDeleted) {
			System.out.println(fullname + " is deleted successfully.\n");
		}
	}

	private static void terminateUser(Scanner scanner) {

		System.out.println("Do you want to terminate User? Please enter the fullname::\n");
		String fullname = ValidationUtils.emptyValidation(scanner, "Fullname");
		employeeServiceImpl = new EmployeeServiceImpl();
		boolean isTerminated = employeeServiceImpl.terminate(fullname);
		if (isTerminated) {
			System.out.println(fullname + " is terminated successfully.\n");
		}

	}

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
}
