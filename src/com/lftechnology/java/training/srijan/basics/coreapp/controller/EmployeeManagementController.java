package com.lftechnology.java.training.srijan.basics.coreapp.controller;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.UserRole;
import com.lftechnology.java.training.srijan.basics.coreapp.service.EmployeeServiceImpl;
import com.lftechnology.java.training.srijan.basics.coreapp.service.ServiceFactory;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementController {
	private static final Logger LOGGER = Logger.getLogger(EmployeeManagementController.class.getName());
	List<Employee> employees;
	Employee employee;
	Employee e = new Employee();
	EmployeeServiceImpl employeeServiceImpl = ServiceFactory.getEmployeeService();
	public EmployeeManagementController(){
	}
	
	public UserRole save(String userName,String password){
		e.setUserName(userName);
		e.setPassword(password);
		return employeeServiceImpl.save(e);
	}
	
	public void adminUserOptionHandler(int adminChoice){
		
		switch(adminChoice){
		case 1:
			Employee employeeDetails = inputUserInfo(e);
			employeeServiceImpl.addEmployee(employeeDetails);
			break;
		case 2:
			employees = employeeServiceImpl.viewAllUser(e);
			LOGGER.log(Level.INFO, "{0}", employees);
			LOGGER.log(Level.INFO,"Choose id of an Employee you want to Edit");
			int employeeIdToEdit = editAndTerminateEmployee();
			employee = employeeServiceImpl.findById(employeeIdToEdit);
			LOGGER.log(Level.INFO, "{0}", employee);
			Employee editEmployeeDetails = inputUserInfo(e);
			employeeServiceImpl.updateEmployee(editEmployeeDetails);
			break;
		case 3:
			LOGGER.log(Level.INFO,"Choose id of an Employee you want to terminate");
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
	
	public Employee inputUserInfo(Employee e){
		Scanner input = null;
		int choiceUserRole = 0;
		int userStatus = 0;
		String username = "";
		String fullname = "";
		String department = "";
		String address = "";
		String password = "";
		try{
			input = new Scanner(System.in);
			LOGGER.log(Level.INFO, "Enter Username*:");
			username = input.nextLine();
			e.setUserName(username);
			LOGGER.log(Level.INFO, "Enter Fullname*:");
			fullname = input.nextLine();
			e.setFullName(fullname);
			LOGGER.log(Level.INFO, "Enter Department*:");
			department = input.nextLine();
			e.setDepartment(department);
			LOGGER.log(Level.INFO, "Enter Address:");
			address = input.nextLine();
			e.setAddress(address);
			LOGGER.log(Level.INFO, "Enter password*");
			password = input.nextLine();
			e.setPassword(password);
			LOGGER.log(Level.INFO,"Enter User Role*:\n1.ADMIN\n2.NORMAL\n3.Default: NORMAL");
			choiceUserRole = input.nextInt();
			switch(choiceUserRole){
			case 1:
				e.setUserRole(UserRole.ADMIN);
				System.out.println(e.getUserRole());
				break;
			case 2:
				e.setUserRole(UserRole.USER);
				break;
			default:
				LOGGER.log(Level.INFO,"please choose right option,Default Normal user assigned");
				e.setUserRole(UserRole.USER);
				break;
			}
			LOGGER.log(Level.INFO, "User status:\n0.Not terminated\n1.Terminated\n2.Default: Not Terminated");
			userStatus = input.nextInt();
			switch(userStatus){
			case 0:
				e.setIsTerminated(false);
				break;
			case 1:
				e.setIsTerminated(true);
				break;
			default:
				LOGGER.log(Level.INFO,"Wrong option, User has been default assigned to Not Terminated");
				e.setIsTerminated(false);
				break;
			}
		}catch(Exception ex){
			LOGGER.log(Level.INFO, "Exception", ex);
		}finally{
			input.close();
		}
		return e;
	}
	
	
	public void normalUserOptionHandler(int normalUserChoice,String userName){
		switch(normalUserChoice){
		case 1:
			employees = employeeServiceImpl.viewAllUser(e);
			LOGGER.log(Level.INFO, "{0}", employees);
			break;
		case 2:
			employee = employeeServiceImpl.findUserByUserName(userName);
			LOGGER.log(Level.INFO, "{0}", employee);
			Employee changedProfileDetails = changeProfile();
			employeeServiceImpl.updateProfile(changedProfileDetails,employee);
			break;
		default:
			LOGGER.log(Level.INFO, "Please choose option properly,Default view all user block");
			employees = employeeServiceImpl.viewAllUser(e);
			LOGGER.log(Level.INFO, "{0}", employees);
			break;
		}
	}
	
	public int editAndTerminateEmployee(){
		Scanner input = null;
		int employeeIdToEdit = 0;
		try{
			input = new Scanner(System.in);
			employeeIdToEdit = input.nextInt();
		}catch(Exception ex){
			LOGGER.log(Level.INFO, "Exception", ex);
		}finally{
			input.close();
		}
		return employeeIdToEdit;
	}
	
	public Employee changeProfile(){
		Scanner input = null;
		String username = "";
		String fullname = "";
		String department = "";
		String address = "";
		try{
			input = new Scanner(System.in);
			LOGGER.log(Level.INFO, "Enter Username:");
			username = input.nextLine();
			e.setUserName(username);
			LOGGER.log(Level.INFO, "Enter Fullname:");
			fullname = input.nextLine();
			e.setFullName(fullname);
			LOGGER.log(Level.INFO, "Enter Department:");
			department = input.nextLine();
			e.setDepartment(department);
			LOGGER.log(Level.INFO, "Enter Address:");
			address = input.nextLine();
			e.setAddress(address);
		}catch(Exception ex){
			LOGGER.log(Level.INFO, "Exception{0}", ex);
		}finally{
			input.close();
		}
		return e;
	}
}
