
package com.lftechnology.java.training.srijan.basics.coreapp.controller;

import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.SearchEmployee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.UserRole;
import com.lftechnology.java.training.srijan.basics.coreapp.service.EmployeeServiceImpl;
import com.lftechnology.java.training.srijan.basics.coreapp.service.ServiceFactory;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementController {

	private static final Logger LOGGER =
		Logger.getLogger(EmployeeManagementController.class.getName());
	List<Employee> employees;
	Employee employee;
	Employee e = new Employee();
	EmployeeServiceImpl employeeServiceImpl =
		ServiceFactory.getEmployeeService();
	private int choiceUserRole;
	private int userStatus;
	private String username;
	private String fullname;
	private String department;
	private String address;
	private String password;

	public EmployeeManagementController() {
		this.choiceUserRole = 0;
		this.userStatus = 0;
		this.username = "";
		this.fullname = "";
		this.department = "";
		this.address = "";
		this.password = "";
	}

	/**
	 * <p>Sets username and password</p>
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @author srijan
	 */
	public UserRole save(String userName, String password) {

		e.setUserName(userName);
		e.setPassword(password);
		return employeeServiceImpl.save(e);
	}

	/**
	 * <p>Calls different methods depending upon user choice</p>
	 * 
	 * @param adminChoice
	 * @author srijan
	 */
	public void adminUserOptionHandler(int adminChoice) {

		switch (adminChoice) {
		case 1:
			Employee employeeDetails = inputUserInfo(e);
			employeeServiceImpl.addEmployee(employeeDetails);
			break;
		case 2:
			SearchEmployee emp = new SearchEmployee();
			LOGGER.log(
				Level.INFO,
				"Search By:\n1.Department\n2.Fullname\n3.Address\n4.Default");
			emp = choiceOfSearch();
			if ("default".equals(emp.getSearchChoice())) {
				employees = employeeServiceImpl.viewAllUser(e);
				LOGGER.log(Level.INFO, "{0}", employees);
			}
			else {
				e = employeeServiceImpl.search(emp);
				LOGGER.log(Level.INFO, "{0}", e);
			}
			break;
		case 3:
			employees = employeeServiceImpl.viewAllUser(e);
			LOGGER.log(Level.INFO, "Employee Details\n{0}", employees);
			LOGGER.log(
				Level.INFO, "Choose id of an Employee you want to terminate");
			int terminateEmployee = editAndTerminateEmployee();
			employeeServiceImpl.terminate(terminateEmployee);
			break;
		case 4:
			employees = employeeServiceImpl.viewAllUser(e);
			LOGGER.log(Level.INFO, "{0}", employees);
			break;
		default:
			LOGGER.log(Level.INFO, "Wrong option, Default view functionality");
			employees = employeeServiceImpl.viewAllUser(e);
			LOGGER.log(Level.INFO, "{0}", employees);
			break;
		}
	}

	/**
	 * <p>Takes employee information from user</p>
	 * 
	 * @param e
	 * @return
	 * @author srijan
	 */
	public Employee inputUserInfo(Employee e) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			LOGGER.log(Level.INFO, "Enter Username*:");
			this.username = input.nextLine();
			e.setUserName(username);
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
		finally {
			input.close();
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
	public void normalUserOptionHandler(int normalUserChoice, String userName) {

		switch (normalUserChoice) {
		case 1:
			employees = employeeServiceImpl.viewAllUser(e);
			LOGGER.log(Level.INFO, "{0}", employees);
			break;
		case 2:
			employee = employeeServiceImpl.findUserByUserName(userName);
			LOGGER.log(Level.INFO, "{0}", employee);
			Employee changedProfileDetails = changeProfile(employee);
			employeeServiceImpl.updateProfile(changedProfileDetails);
			break;
		default:
			LOGGER.log(
				Level.INFO,
				"Please choose option properly,Default view all user block");
			employees = employeeServiceImpl.viewAllUser(e);
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
	public int editAndTerminateEmployee() {

		Scanner input = null;
		int employeeIdToEdit = 0;
		try {
			input = new Scanner(System.in);
			employeeIdToEdit = input.nextInt();
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception", ex);
		}
		finally {
			input.close();
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
	public Employee changeProfile(Employee emp) {

		Scanner input = null;
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
		finally {
			input.close();
		}
		return emp;
	}

	/**
	 * <p>Takes input from user the search choice and value of choice</p>
	 * 
	 * @return
	 */
	public SearchEmployee choiceOfSearch() {

		SearchEmployee emp = new SearchEmployee();
		Scanner inputChoice = null;
		Scanner input = null;
		String choiceValue = "";
		int choice = 0;
		try {
			inputChoice = new Scanner(System.in);
			input = new Scanner(System.in);
			choice = inputChoice.nextInt();
			if (choice == 1)
				emp.setSearchChoice("department");
			else if (choice == 2)
				emp.setSearchChoice("fullname");
			else if (choice == 3)
				emp.setSearchChoice("address");
			else
				emp.setSearchChoice("default");

			LOGGER.log(Level.INFO, "Write {0}?", emp.getSearchChoice());
			choiceValue = inputChoice.nextLine();
			if (!"".equals(choiceValue)) {
				emp.setChoiceValue(choiceValue);
				System.out.println("here");
			}
			return emp;
		}
		finally {
			inputChoice.close();
			input.close();
		}
	}
}
