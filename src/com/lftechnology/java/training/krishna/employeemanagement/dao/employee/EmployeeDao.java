
package com.lftechnology.java.training.krishna.employeemanagement.dao.employee;

import com.lftechnology.java.training.krishna.employeemanagement.dao.GenericDao;
import com.lftechnology.java.training.krishna.employeemanagement.domain.Employee;

/**
 * This program is used to perform terminate user.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public interface EmployeeDao extends GenericDao<Employee, Integer> {

	/**
	 * terminate users
	 *
	 * @param entity
	 *            {@link T}
	 * @return boolean
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public boolean terminate(Employee entity);

	/**
	 * validate whether or not username already exists
	 *
	 * @param username
	 *            {@link String}
	 * @return boolean
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */

	public boolean isDuplicate(String username);
}
