
package com.lftechnology.java.training.krishna.employeemanagement.dao.employee.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.krishna.employeemanagement.dao.employee.EmployeeDao;
import com.lftechnology.java.training.krishna.employeemanagement.domain.Employee;
import com.lftechnology.java.training.krishna.employeemanagement.jdbc.DbConnectionFactory;
import com.lftechnology.java.training.krishna.employeemanagement.utils.ConstantUtils;

/**
 * Implementation of employee DAO interface.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger LOGGER =
		Logger.getLogger(EmployeeDaoImpl.class.getName());

	Connection connection = DbConnectionFactory.getDbConnection();
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	private static final String INSERT_USER_QUERY =
		"INSERT INTO user (username, password, fullname, department, address,role, isTerminated, createdAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SEARCH_USER_QUERY =
		"SELECT * FROM user WHERE fullname LIKE ? OR department LIKE ? OR address LIKE ?";
	private static final String DELETE_USER_QUERY =
		"DELETE FROM user WHERE fullname = ?";
	private static final String TERMINATE_USER_QUERY =
		"UPDATE user SET isTerminated = ?, modifiedAt= ?  WHERE fullname = ?";
	private static final String SEARCH_BY_ID_QUERY =
		"SELECT * FROM user WHERE id = ?";
	private static final String SEARCH_BY_USERNAME_QUERY =
		"SELECT * FROM user WHERE username = ?";
	
	

	public EmployeeDaoImpl() {

	}

	@Override
	public Employee create(Employee entity) {

		try {
			preparedStatement =
				connection.prepareStatement(
					INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, entity.getUsername());
			preparedStatement.setString(2, entity.getPassword());
			preparedStatement.setString(3, entity.getFullname());
			preparedStatement.setString(4, entity.getDepartment());
			preparedStatement.setString(5, entity.getAddress());
			preparedStatement.setString(6, entity.getRole());
			preparedStatement.setInt(7, entity.getIsTerminated());
			preparedStatement.setDate(8, entity.getCreatedAt());
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(
					"Creating user failed, no rows affected.");
			}
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				entity.setId(generatedKeys.getInt(1));
			}
		}
		catch (SQLException e) {
			LOGGER.log(
				Level.SEVERE, ConstantUtils.EXCEPTION_STATEMENT, e);
		}
		finally {
			DbConnectionFactory.closePreparedStatement();
		}
		return entity;
	}

	@Override
	public List<Employee> findAll(String key) {

		List<Employee> empList = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(SEARCH_USER_QUERY);
			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setString(2, "%" + key + "%");
			preparedStatement.setString(3, "%" + key + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee emp = new Employee();
				emp.setUsername(resultSet.getString("username"));
				emp.setFullname(resultSet.getString("fullname"));
				emp.setDepartment(resultSet.getString("department"));
				emp.setAddress(resultSet.getString("address"));
				emp.setRole(resultSet.getString("role"));
				empList.add(emp);
			}
		}
		catch (SQLException e) {
			LOGGER.log(
				Level.SEVERE,  ConstantUtils.EXCEPTION_STATEMENT, e);
		}
		finally {
			DbConnectionFactory.closePreparedStatement();
		}
		return empList;
	}

	@Override
	public Employee findById(Integer id) {

		Employee emp = new Employee();
		try {
			preparedStatement = connection.prepareStatement(SEARCH_BY_ID_QUERY);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				emp.setUsername(resultSet.getString("username"));
				emp.setFullname(resultSet.getString("fullname"));
				emp.setDepartment(resultSet.getString("department"));
				emp.setAddress(resultSet.getString("address"));
				emp.setRole(resultSet.getString("role"));
			}
		}
		catch (SQLException e) {
			LOGGER.log(
				Level.SEVERE,  ConstantUtils.EXCEPTION_STATEMENT, e);
		}
		finally {
			DbConnectionFactory.closePreparedStatement();
		}
		return emp;
	}

	@Override
	public Employee update(Employee entity) {

		try {
			String sqlQuery = "UPDATE user SET";
			if (entity.getFullname() != null) {
				sqlQuery += " fullname = ? ";
			}
			else if (entity.getAddress() != null) {
				sqlQuery += " address = ? ";
			}
			else if (entity.getDepartment() != null) {
				sqlQuery += " department = ? ";
			}
			sqlQuery += ", modifiedAt = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlQuery);
			if (entity.getFullname() != null) {
				preparedStatement.setString(1, entity.getFullname());
			}
			if (entity.getDepartment() != null) {
				preparedStatement.setString(1, entity.getDepartment());
			}
			if (entity.getAddress() != null) {
				preparedStatement.setString(1, entity.getAddress());
			}
			preparedStatement.setDate(2, entity.getModifiedAt());
			preparedStatement.setInt(3, entity.getId());
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(
					"Updating user failed, no rows affected.");
			}
			entity.setId(entity.getId());

		}
		catch (SQLException e) {
			LOGGER.log(
				Level.SEVERE,  ConstantUtils.EXCEPTION_STATEMENT, e);
		}
		finally {
			DbConnectionFactory.closePreparedStatement();
		}
		return entity;
	}

	@Override
	public boolean delete(Employee entity) {

		boolean isDeleted = false;
		try {
			preparedStatement = connection.prepareStatement(DELETE_USER_QUERY);
			preparedStatement.setString(1, entity.getFullname());
			int affectedRows = preparedStatement.executeUpdate();
			isDeleted = (affectedRows != 0) ? true : false;
		}
		catch (SQLException e) {
			LOGGER.log(
				Level.SEVERE,  ConstantUtils.EXCEPTION_STATEMENT, e);
		}
		finally {
			DbConnectionFactory.closePreparedStatement();
		}
		return isDeleted;

	}

	@Override
	public boolean terminate(Employee entity) {

		boolean isTerminated = false;
		try {
			preparedStatement =
				connection.prepareStatement(TERMINATE_USER_QUERY);
			preparedStatement.setInt(1, ConstantUtils.INACTIVE);
			preparedStatement.setDate(2, entity.getModifiedAt());
			preparedStatement.setString(3, entity.getFullname());
			int affectedRows = preparedStatement.executeUpdate();
			isTerminated = (affectedRows != 0) ? true : false;
		}
		catch (SQLException e) {
			LOGGER.log(
				Level.SEVERE,  ConstantUtils.EXCEPTION_STATEMENT, e);
		}
		finally {
			DbConnectionFactory.closePreparedStatement();
		}
		return isTerminated;
	}

	@Override
	public boolean isDuplicate(String username) {

		boolean isDuplicate = false;
		try {
			preparedStatement =
				connection.prepareStatement(SEARCH_BY_USERNAME_QUERY);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				isDuplicate = true;
			}
		}
		catch (SQLException e) {
			LOGGER.log(
				Level.SEVERE,  ConstantUtils.EXCEPTION_STATEMENT, e);
		}
		finally {
			DbConnectionFactory.closePreparedStatement();
		}
		return isDuplicate;
	}

}
