
package com.lftechnology.java.training.dipak.employeemanagement.service;

/**
 * <p>This class contains method to create object of the classes present in
 * service layer.</p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class ServiceFactory {
	private ServiceFactory() {
		
	}
	/**
	 * <p>This method creates the object of the EmployeeService class.</p>
	 * 
	 * @return
	 */
	public static EmployeeService getEmployeeService() {

		return new EmployeeService();
	}
	/**
	 * <p>This method creates the object of the LoginService class.</p>
	 * 
	 * @return
	 */
	public static LoginService getLoginService() {

		return new LoginService();
	}
}
