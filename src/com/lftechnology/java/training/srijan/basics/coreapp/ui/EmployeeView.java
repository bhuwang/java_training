
package com.lftechnology.java.training.srijan.basics.coreapp.ui;

import com.lftechnology.java.training.srijan.basics.coreapp.controller.EmployeeController;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.SearchEmployee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.UserRole;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeView {

	private static final Logger LOGGER =
		Logger.getLogger(EmployeeView.class.getName());
	List<Employee> employees;
	Employee employee;
	Employee e = new Employee();
	EmployeeController employeeControl = new EmployeeController();
	private int choiceUserRole;
	private int userStatus;
	private String username;
	private String fullname;
	private String department;
	private String address;
	private String password;

	public EmployeeView() {
		this.choiceUserRole = 0;
		this.userStatus = 0;
		this.username = "";
		this.fullname = "";
		this.department = "";
		this.address = "";
		this.password = "";
	}

	/**
	 * <p>Takes employee information from user</p>
	 * 
	 * @param e
	 * @return
	 * @author srijan
	 */
	public Employee inputUserInfo(Employee e, Scanner input) {

		Boolean checkUserValidity;
		try {
			input = new Scanner(System.in);
			do {
				LOGGER.log(Level.INFO, "Enter Username*:");
				this.username = input.nextLine();
				e.setUserName(username);
				checkUserValidity = employeeControl.checkUsernameValidation(e);
				if (checkUserValidity.equals(true)) {
					LOGGER.log(
						Level.INFO,
						"Duplicate Username or Empty Username..Please choose another Username");
				}
				else {
					LOGGER.log(Level.INFO, "valid Username");
				}
			}
			while (checkUserValidity.equals(true));
			LOGGER.log(Level.INFO, "Enter Fullname*:");
			this.fullname = input.nextLine();
			e.setFullName(fullname);
			LOGGER.log(Level.INFO, "Enter Department*:");
			this.department = input.nextLine();
			e.setDepartment(department);
			LOGGER.log(Level.INFO, "Enter Address:");
			this.address = input.nextLine();
			e.setAddress(address);
			LOGGER.log(Level.INFO, "Enter password*");
			this.password = input.nextLine();
			e.setPassword(password);
			LOGGER.log(
				Level.INFO,
				"Enter User Role*:\n1.ADMIN\n2.NORMAL\n3.Default: NORMAL");
			this.choiceUserRole = input.nextInt();
			switch (choiceUserRole) {
			case 1:
				e.setUserRole(UserRole.ADMIN);
				break;
			case 2:
				e.setUserRole(UserRole.NORMAL);
				break;
			default:
				LOGGER.log(
					Level.INFO,
					"please choose right option,Default Normal user assigned");
				e.setUserRole(UserRole.NORMAL);
				break;
			}
			LOGGER.log(
				Level.INFO,
				"User status:\n0.Not terminated\n1.Terminated\n2.Default: Not Terminated");
			userStatus = input.nextInt();
			switch (userStatus) {
			case 0:
				e.setIsTerminated(false);
				break;
			case 1:
				e.setIsTerminated(true);
				break;
			default:
				LOGGER.log(
					Level.INFO,
					"Wrong option, User has been default assigned to Not Terminated");
				e.setIsTerminated(false);
				break;
			}
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception", ex);
		}
		return e;
	}

	/**
	 * <p>Calls different user methods depending upon user choice</p>
	 * 
	 * @param normalUserChoice
	 * @param userName
	 * @author srijan
	 */
	public void normalUserOptionHandler(int normalUserChoice, Employee em,Scanner input) {

		switch (normalUserChoice) {
		case 1:
			employees = employeeControl.viewAllUser(em);
			LOGGER.log(Level.INFO, "{0}", employees);
			break;
		case 2:
			employee = employeeControl.findUserByUserName(em);
			LOGGER.log(Level.INFO, "{0}", employee);
			Employee changedProfileDetails = changeProfile(employee,input);
			Boolean status =
				employeeControl.updateProfile(changedProfileDetails);
			if (status.equals(true)) {
				LOGGER.log(Level.INFO, "Update Successful");
			}
			break;
		case 3:
			exit();
			break;
		default:
			LOGGER.log(Level.INFO,
				"Please choose option properly,Default view all user block");
			employees = employeeControl.viewAllUser(em);
			LOGGER.log(Level.INFO, "{0}", employees);
			break;
		}
	}

	/**
	 * <p>edit and terminate user</p>
	 * 
	 * @return
	 * @author srijan
	 */
	public int editAndTerminateEmployee(Scanner input) {

		int employeeIdToEdit = 0;
		try {
			input = new Scanner(System.in);
			employeeIdToEdit = input.nextInt();
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception", ex);
		}
		return employeeIdToEdit;
	}

	/**
	 * <p>Change profile of an user</p>
	 * 
	 * @param emp
	 * @return
	 * @author srijan
	 */
	public Employee changeProfile(Employee emp,Scanner input) {

		try {
			input = new Scanner(System.in);
			LOGGER.log(Level.INFO, "Enter Username:");
			this.username = input.nextLine();
			if (!"".equals(username))
				emp.setUserName(username);
			LOGGER.log(Level.INFO, "Enter Fullname:");
			this.fullname = input.nextLine();
			if (!"".equals(fullname))
				emp.setFullName(fullname);
			LOGGER.log(Level.INFO, "Enter Department:");
			this.department = input.nextLine();
			if (!"".equals(department))
				emp.setDepartment(department);
			LOGGER.log(Level.INFO, "Enter Address:");
			this.address = input.nextLine();
			if (!"".equals(address))
				emp.setAddress(address);
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception{0}", ex);
		}
		return emp;
	}

	/**
	 * <p>Takes input from user the search choice and value of choice</p>
	 * 
	 * @return
	 */
	public SearchEmployee choiceOfSearch(Scanner input) {

		SearchEmployee emp = new SearchEmployee();
		int choice = 0;
		try {
			input = new Scanner(System.in);
			choice = input.nextInt();
			if (choice == 1)
				emp.setSearchChoice("department");
			else if (choice == 2)
				emp.setSearchChoice("fullname");
			else if (choice == 3)
				emp.setSearchChoice("address");
			else
				emp.setSearchChoice("default");
			
			emp = valueOfSearchChoice(emp,input);
			
		}catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception{0}", ex);
		}
		return emp;
	}
	
	public SearchEmployee valueOfSearchChoice(SearchEmployee emp,Scanner input){
		String choiceValue = "";
		try{
			input = new Scanner(System.in);
		if (!emp.getSearchChoice().equals("default")) {
			LOGGER.log(Level.INFO, "Write {0}?", emp.getSearchChoice());
			choiceValue = input.nextLine();
			if (!"".equals(choiceValue)) {
				emp.setChoiceValue(choiceValue);
			}
		}	
		}catch(Exception ex){
			LOGGER.log(Level.INFO, "Exception{0}", ex);
		}
		return emp;
	}

	/**
	 * <p>Displays various options for ADMIN user</p> <p>Inputs choice from
	 * ADMIN user</p>
	 * 
	 * @param controller
	 * @author srijan
	 */
	public void adminAccess(Scanner input) {

		Boolean looping = true;
		do {
			int userInput = 0;
			LOGGER.log(
				Level.INFO,
				"\n1.Add User\n2.Search User \n3.Terminate User\n4.View Employee\n5.Exit");
			try {
				input = new Scanner(System.in);
				userInput = input.nextInt();
				if (userInput == 1) {
					addUser(input);
				}
				else if (userInput == 2) {
					searchUser(input);
				}
				else if (userInput == 3) {
					terminateUser(input);
				}
				else if (userInput == 4) {
					viewUsers();
				}
				else if (userInput == 5) {
					exit();
				}
				else {
					defaultUserView();
				}
			}
			catch (Exception ex) {
				LOGGER.log(Level.INFO, "Error:{0}", ex);
			}
		}
		while (looping.equals(true));
	}

	/**
	 * <p>Calls employee controller for employee add function</p>
	 * @author srijan
	 * @param input
	 */
	public void addUser(Scanner input) {
		Boolean addStatus = false;
		Employee employeeDetails = inputUserInfo(e, input);
		addStatus = employeeControl.addEmployee(employeeDetails);
		if(addStatus.equals(true)){
			LOGGER.log(Level.INFO, "New Employee Added");
		}
	}

	/**
	 * <p>Search user according to Department,fullname,address</p>
	 * @param input
	 * @author srijan
	 */
	public void searchUser(Scanner input) {

		SearchEmployee emp = new SearchEmployee();
		LOGGER.log(
			Level.INFO,
			"Search By:\n1.Department\n2.Fullname\n3.Address\n4.Default");
		emp = choiceOfSearch(input);
		if ("default".equals(emp.getSearchChoice())) {
			employees = employeeControl.viewAllUser(e);
			LOGGER.log(Level.INFO, "{0}", employees);
		}
		else {
			employees = employeeControl.search(emp);
			LOGGER.log(Level.INFO, "{0}", employees);
		}
	}

	/**
	 * <p>Terminates/Delete user from database and hence cannot login</p>
	 * @author srijan
	 */
	public void terminateUser(Scanner input) {
		
		Boolean terminateStatus = false;
		employees = employeeControl.viewAllUser(e);
		LOGGER.log(Level.INFO, "Employee Details\n{0}", employees);
		LOGGER.log(
			Level.INFO, "Choose id of an Employee you want to terminate");
		int terminateEmployee = editAndTerminateEmployee(input);
		terminateStatus = employeeControl.terminate(terminateEmployee);
		if(terminateStatus.equals(true)){
			LOGGER.log(Level.INFO, "User Status successfully terminated");
		}
	}

	/**
	 * <p>Displays all user/employees along with their information</p>
	 * @author srijan
	 */
	public void viewUsers() {

		employees = employeeControl.viewAllUser(e);
		LOGGER.log(Level.INFO, "{0}", employees);
	}

	/**
	 * <p>Exits to login view</p>
	 * @author srijan
	 */
	public void exit() {

		LOGGER.log(Level.INFO, "Logout successful");
		LoginView.login();
	}

	/**
	 * <p>If user input is incorrect then default shows all employees with their information</p>
	 * @author srijan
	 */
	public void defaultUserView() {

		employees = employeeControl.viewAllUser(e);
		LOGGER.log(Level.INFO, "{0}", employees);
	}

	/**
	 * <p>Shows different option for user access</p>
	 * @param input
	 * @param e
	 * @author srijan
	 */
	public void normalAccess(Scanner input, Employee e) {

		Boolean loop = true;
		do {
			int userInput = 0;
			LOGGER.log(
				Level.INFO,
				"\n1.View All User\n2.Edit Personal Details\n3.Exit");
			try {
				input = new Scanner(System.in);
				userInput = input.nextInt();
				normalUserOptionHandler(userInput, e,input);
			}
			catch (Exception ex) {
				LOGGER.log(Level.INFO, "Error:{0}", ex);
			}
		}
		while (loop.equals(true));
	}
}
