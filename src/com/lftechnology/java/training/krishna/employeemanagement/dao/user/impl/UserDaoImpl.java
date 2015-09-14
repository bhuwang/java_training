
package com.lftechnology.java.training.krishna.employeemanagement.dao.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.krishna.employeemanagement.dao.user.UserDao;
import com.lftechnology.java.training.krishna.employeemanagement.domain.User;
import com.lftechnology.java.training.krishna.employeemanagement.jdbc.DbConnectionFactory;

/**
 * DAO of User.
 */

public class UserDaoImpl implements UserDao {

	private static final Logger LOGGER =
		Logger.getLogger(UserDaoImpl.class.getName());

	Connection connection = DbConnectionFactory.getDbConnection();
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	private User activeUser;

	private static final String GET_USER_QUERY =
		"SELECT * FROM user WHERE username = ? AND password = ? AND isTerminated = ?";

	public UserDaoImpl() {

	}

	@Override
	public User authenticate(User entity) {

		activeUser = null;
		try {
			preparedStatement = connection.prepareStatement(GET_USER_QUERY);
			preparedStatement.setString(1, entity.getUsername());
			preparedStatement.setString(2, entity.getPassword());
			preparedStatement.setInt(3, 0);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				activeUser =
					new User(
						resultSet.getInt("id"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						resultSet.getInt("isTerminated"),
						resultSet.getDate("createdAt"),
						resultSet.getDate("modifiedAt"));
			}
		}
		catch (SQLException e) {
			LOGGER.log(
				Level.SEVERE, "Exception while creating statement: {0}", e);
		}
		finally {
			try {
				preparedStatement.close();
			}
			catch (SQLException e) {
				LOGGER.log(Level.SEVERE, "Error closing statement: {0}", e);
			}
		}
		return activeUser;
	}

	@Override
	public User create(User entity) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User entity) {

		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User findById(Integer id) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll(String key) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(User entity) {

		// TODO Auto-generated method stub
		return false;
	}

}
