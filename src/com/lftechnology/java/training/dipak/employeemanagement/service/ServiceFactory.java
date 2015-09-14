package com.lftechnology.java.training.dipak.employeemanagement.service;


public class ServiceFactory {
	public static EmployeeService getEmployeeService() {
		return new EmployeeService();
	}
	
	public static LoginService getLoginService() {
		return new LoginService();
	}
}

