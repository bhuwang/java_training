
package com.lftechnology.java.training.dipak.employeemanagement.dao;

/**
 * <p>This class contains method to create objects for the class in the Dao
 * layer.</p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class DaoFactory {

	/**
	 * <p>This method creates the object of the EmployeeDao class.</p>
	 * 
	 * @return
	 */
	public static EmployeeDao getEmployeeDao() {

		return new EmployeeDao();
	}

	/**
	 * <p>This method creates the object of the LoginDao class.</p>
	 * 
	 * @return
	 */
	public static LoginDao getLoginDao() {

		return new LoginDao();
	}
}
