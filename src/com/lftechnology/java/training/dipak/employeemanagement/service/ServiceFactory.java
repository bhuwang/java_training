
package com.lftechnology.java.training.dipak.employeemanagement.service;

/**
 * <p>This class contains method to create object of the classes present in
 * service layer.</p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class ServiceFactory {

	public static EmployeeService getEmployeeService() {

		return new EmployeeService();
	}

	public static LoginService getLoginService() {

		return new LoginService();
	}
}
