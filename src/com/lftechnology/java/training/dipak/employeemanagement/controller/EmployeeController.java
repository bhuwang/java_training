package com.lftechnology.java.training.dipak.employeemanagement.controller;

import java.sql.ResultSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;
import com.lftechnology.java.training.dipak.employeemanagement.service.EmployeeService;
import com.lftechnology.java.training.dipak.employeemanagement.service.ServiceFactory;

public class EmployeeController{
	private static final Logger LOGGER=Logger.getLogger(EmployeeController.class.getName());
	
	public int addEmployee(Employee e,Scanner sc) {
		String userName=null;
		String password=null;
		String fullName=null;
		String department=null;
		String address=null;
		int count=0;
		boolean isTerminated=false;
		UserType role=null;
		try {
			for(;;) {
				try {
					LOGGER.info("Please enter the employee username::");
					userName=sc.nextLine();
					LOGGER.info("Pleasse enter the password for the password::");
					password=sc.nextLine();
					LOGGER.info("please enter the fullname::");
					fullName=sc.nextLine();
					LOGGER.info("Please enter the department::");
					department=sc.nextLine();
					LOGGER.info("Please enter the address::");
					address=sc.nextLine();
					LOGGER.info("Please enter whether the user is terminated::(true/false)");
					isTerminated=sc.nextBoolean();
					LOGGER.info("Please enter the user type::(ADMIN->1/USER->2)");
					int role2=sc.nextInt();
					if(role2==1) {
						role=UserType.ADMIN;
					}else if(role2==2) {
						role=UserType.USER;
					}else {
						throw new Exception("Invalid value of the User type");
					}
					
					break;
				}catch(Exception ex) {
					LOGGER.log(Level.INFO, "Exception occurred:",ex);
					LOGGER.info("Please re-enter the values.");
				}
				
			}
			
			
			e.setAddress(address);
			e.setDepartment(department);
			e.setFullName(fullName);
			e.setIsTerminated(isTerminated);
			e.setUserName(userName);
			e.setPassword(password);
			e.setRole(role);
			
			EmployeeService ed=ServiceFactory.getEmployeeService();
			count=ed.addEmployee(e);
						
		}catch(Exception ex) {
			LOGGER.log(Level.INFO,"Exception type::{0}",ex);
		}
		return count;
	}

	

	public int terminateEmployee(Employee e,Scanner sc) {
		String fullName=null;
		int count=0;
		try {
			LOGGER.info("Please enter the employee fullname::");
			fullName=sc.nextLine();
			e.setFullName(fullName);
			
			EmployeeService ed=ServiceFactory.getEmployeeService();
			
			ed.terminateEmployee(e);
			
		}catch(Exception ex) {
			LOGGER.log(Level.INFO,"Exception type::{0}",ex);
		}	
		return count;
	}

	public ResultSet viewEmployee(Employee e,Scanner sc) {
		String fullName=null;
		String department=null;
		String address=null;
		try {
			LOGGER.info("Please enter the employee fullname::");
			fullName=sc.nextLine();
			
			LOGGER.info("Please enter the department::");
			department=sc.nextLine();
			
			LOGGER.info("Please enter the address::");
			address=sc.nextLine();
			
			e.setFullName(fullName);
			e.setAddress(address);
			e.setDepartment(department);
			
			EmployeeService ed=ServiceFactory.getEmployeeService();
			
			ed.viewEmployee(e);
			
		}catch(Exception ex) {
			LOGGER.log(Level.INFO,"Exception type::{0}",ex);
		}
		return null;
	}

//	public int deleteEmployee(Employee e,Scanner sc) {
//		String fullName=null;
//		String department=null;
//		String address=null;
//		int count=0;
//		try {
//			
//			LOGGER.info("Please enter the employee username::");
//			fullName=sc.nextLine();
//			
//			LOGGER.info("Please enter the department::");
//			department=sc.nextLine();
//			LOGGER.info("Please enter the address::");
//			address=sc.nextLine();
//			
//			e.setFullName(fullName);
//			e.setAddress(address);
//			e.setDepartment(department);
//			
//			EmployeeService ed=ServiceFactory.getEmployeeService();
//			
//			count=ed.deleteEmployee(e);
//			
//		}catch(Exception ex) {
//			LOGGER.log(Level.INFO,"Exception type::{0}",ex);
//		}	
//		return count;
//	}



	public Employee editEmployeeDetails(Employee e,Scanner sc) {
		LOGGER.info("Welcome to the edit mode....");
		String userName=null;
		String password=null;
		String fullName=null;
		String department=null;
		String address=null;
		try {
			LOGGER.info("Enter new username::");
			userName=sc.nextLine();
			
			LOGGER.info("Enter new password::");
			password=sc.nextLine();
			
			LOGGER.info("Enter new fullname::");
			fullName=sc.nextLine();
			
			LOGGER.info("Enter new department::");
			department=sc.nextLine();
			
			LOGGER.info("Enter new address::");
			address=sc.nextLine();
			
			if(!(userName.equals(""))) {
				e.setUserName(userName);
			}
			if(!(password.equals(""))) {
				e.setPassword(password);
			}
			if(!(fullName.equals(""))) {
				e.setFullName(fullName);
			}
			if(!(department.equals(""))) {
				e.setDepartment(department);
			}
			if(!(address.equals(""))) {
				e.setAddress(address);
			}
			
			LOGGER.info(""+e.getAddress()+" "+e.getDepartment()+" "+e.getFullName());
			
			EmployeeService es=ServiceFactory.getEmployeeService();
			
			e=es.editEmployeeDetails(e);
			
		}catch(Exception ex) {
			LOGGER.log(Level.INFO,"Exception type::{0}",ex);
		}
				
		return e;
	}

}
