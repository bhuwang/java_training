
package com.lftechnology.java.training.krishna.employeemanagement.service;

import java.util.List;

/**
 * This program is used to perform delete and list users.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public interface GenericService<T> {

	/**
	 * Delete user according to fullname
	 *
	 * @param fullname
	 *            {@link String}
	 * @return boolean
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public boolean delete(String fullname);

	/**
	 * List users
	 *
	 * @param fullname
	 *            {@link String}
	 * @return T {@link List}
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public List<T> findAll(String key);
}
