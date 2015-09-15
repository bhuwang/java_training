package com.lftechnology.java.training.srijan.basics.coreapp.service;

public class ServiceFactory {
	
	public static EmployeeServiceImpl getEmployeeService(){
		return new EmployeeServiceImpl();
	}
}
