
package com.lftechnology.java.training.dipak.employeemanagement.api;

import java.sql.ResultSet;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;

/**
 * <p>Defines the interface for the application.</p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public interface EmployeeApi {

	/**
	 * <p>This method adds employee.</p>
	 * 
	 * @param e
	 * @return
	 */
	public int addEmployee(Employee e);

	/**
	 * <p>This method is used to view the employee based on the filters
	 * provided.</p>
	 * 
	 * @param e
	 * @return
	 */
	public ResultSet viewEmployee(Employee e);

	/**
	 * <p> This method is used to terminate users from the database.</p>
	 * 
	 * @param e
	 * @return
	 */
	public int terminateEmployee(Employee e);

	/**
	 * This method is used to edit the employee details.
	 * 
	 * @param e
	 * @return
	 */
	public Employee editEmployeeDetails(Employee e);
}
