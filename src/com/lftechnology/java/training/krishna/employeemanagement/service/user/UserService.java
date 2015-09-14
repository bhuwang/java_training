
package com.lftechnology.java.training.krishna.employeemanagement.service.user;

import com.lftechnology.java.training.krishna.employeemanagement.domain.User;
import com.lftechnology.java.training.krishna.employeemanagement.service.GenericService;

/**
 * This program is used to perform login.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public interface UserService extends GenericService<User> {

	/**
	 * login user according to username and password
	 *
	 * @param username
	 *            {@link String}
	 * @param password
	 *            {@link String}
	 * @return User
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public User login(String username, String password);
}
