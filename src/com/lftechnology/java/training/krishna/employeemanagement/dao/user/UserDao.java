
package com.lftechnology.java.training.krishna.employeemanagement.dao.user;

import com.lftechnology.java.training.krishna.employeemanagement.dao.GenericDao;
import com.lftechnology.java.training.krishna.employeemanagement.domain.User;

/**
 * This program is used to authenticate user.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public interface UserDao extends GenericDao<User, Integer> {

	/**
	 * authenticate users
	 *
	 * @param entity
	 *            {@link User}
	 * @return User
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public User authenticate(User entity);
}
