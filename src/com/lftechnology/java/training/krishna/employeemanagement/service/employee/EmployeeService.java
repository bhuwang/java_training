
package com.lftechnology.java.training.krishna.employeemanagement.service.employee;

import com.lftechnology.java.training.krishna.employeemanagement.domain.Employee;
import com.lftechnology.java.training.krishna.employeemanagement.service.GenericService;

/**
 * This program is used to perform terminate,save and update users.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public interface EmployeeService extends GenericService<Employee> {

	/**
	 * terminate user according to fullname
	 *
	 * @param fullname
	 *            {@link String}
	 * @return boolean
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public boolean terminate(String fullname);

	/**
	 * save employees
	 *
	 * @param username
	 *            {@link String}
	 * @param password
	 *            {@link String}
	 * @param fullname
	 *            {@link String}
	 * @param department
	 *            {@link String}
	 * @param address
	 *            {@link String}
	 * @param role
	 *            {@link String}
	 * @return Employee {@link Employee}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public Employee saveEmployee(
		String username, String password, String fullname, String department,
		String address, String role);

	/**
	 * update employees
	 *
	 * @param fullname
	 *            {@link String}
	 * @param department
	 *            {@link String}
	 * @param address
	 *            {@link String}
	 * @return Employee {@link Employee}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public Employee updateEmployee(
		int id, String fullname, String department, String address);

	/**
	 * find employee by id
	 *
	 * @param id
	 *            {@link Integer}
	 * @return Employee
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */

	public Employee findById(Integer id);
}
