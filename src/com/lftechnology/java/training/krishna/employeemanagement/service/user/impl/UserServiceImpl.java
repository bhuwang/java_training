
package com.lftechnology.java.training.krishna.employeemanagement.service.user.impl;

import java.util.List;

import com.lftechnology.java.training.krishna.employeemanagement.dao.user.impl.UserDaoImpl;
import com.lftechnology.java.training.krishna.employeemanagement.domain.User;
import com.lftechnology.java.training.krishna.employeemanagement.service.user.UserService;

/**
 * Implementation of user service interface.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

	private UserDaoImpl userDaoImpl;

	public UserServiceImpl() {

		this.userDaoImpl = new UserDaoImpl();
	}

	@Override
	public User login(String username, String password) {

		User user = new User();
		user.setUsername(username);;
		user.setPassword(password);
		User userAuthenticate = this.userDaoImpl.authenticate(user);
		return userAuthenticate;
	}


	@Override
	public List<User> findAll(String key) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String fullname) {

		// TODO Auto-generated method stub
		return false;
	}


}
