
package com.lftechnology.java.training.srijan.basics.coreapp.dao;

import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.SearchEmployee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger LOGGER =
		Logger.getLogger(EmployeeDaoImpl.class.getName());

	public void addEmployee(Employee e) {

		Connection con = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareStatementInsertEmployeeDetails = null;
		try {
			if (con != null) {
				String queryEmployee =
					"INSERT INTO employeeDetails (username,fullname,department,address,employee_role,is_terminated,password) VALUES(?,?,?,?,?,?,?)";
				prepareStatementInsertEmployeeDetails =
					con.prepareStatement(queryEmployee);
				prepareStatementInsertEmployeeDetails.setString(
					1, e.getUserName());
				prepareStatementInsertEmployeeDetails.setString(
					2, e.getFullName());
				prepareStatementInsertEmployeeDetails.setString(
					3, e.getDepartment());
				prepareStatementInsertEmployeeDetails.setString(
					4, e.getAddress());
				prepareStatementInsertEmployeeDetails.setString(
					5, e.getUserRole().name());
				prepareStatementInsertEmployeeDetails.setBoolean(
					6, e.getIsTerminated());
				prepareStatementInsertEmployeeDetails.setString(
					7, e.getPassword());
				prepareStatementInsertEmployeeDetails.executeUpdate();
			}
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception{0}", ex);
		}
		finally {
			try {
				prepareStatementInsertEmployeeDetails.close();
				con.close();
			}
			catch (SQLException e1) {
				LOGGER.log(Level.INFO, "SQL Exception{0}", e1);
			}
		}
	}

	@Override
	public Employee findById(int employeeIdToUpdate) {

		Connection con = null;
		ResultSet resultSet = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareStatementUpdateInfo = null;
		Employee employee = new Employee();
		try {
			if (con != null) {
				String query = "Select * from employeeDetails where id = ?";
				prepareStatementUpdateInfo = con.prepareStatement(query);
				prepareStatementUpdateInfo.setInt(1, employeeIdToUpdate);
				resultSet = prepareStatementUpdateInfo.executeQuery();
				while (resultSet.next()) {
					employee.setId(resultSet.getInt("id"));
					employee.setUserName(resultSet.getString("username"));
					employee.setFullName(resultSet.getString("fullName"));
					employee.setDepartment(resultSet.getString("department"));
					employee.setAddress(resultSet.getString("address"));
					employee.setIsTerminated(
						resultSet.getBoolean("is_terminated"));
				}
			}
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception:{0}", ex);
		}
		finally {
			try {
				resultSet.close();
				prepareStatementUpdateInfo.close();
				con.close();
			}
			catch (SQLException ex) {
				LOGGER.log(Level.INFO, "SQL Exception {0}", ex);
			}
		}
		return employee;
	}

	/**
	 * <p>Checks login Validation depending on userName and password</p>
	 * 
	 * @author srijan
	 */
	@Override
	public UserRole loginValidation(Employee e) {

		ResultSet resultSet = null;
		Connection con = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareStatementLoginCheck = null;
		try {
			if (con != null) {
				String query =
					"Select * from employeeDetails where username = ? and password = ? and is_terminated = ?";
				prepareStatementLoginCheck = con.prepareStatement(query);
				prepareStatementLoginCheck.setString(1, e.getUserName());
				prepareStatementLoginCheck.setString(2, e.getPassword());
				prepareStatementLoginCheck.setBoolean(3, false);
				resultSet = prepareStatementLoginCheck.executeQuery();
				if (resultSet.next()) {
					LOGGER.log(Level.INFO, "Login Successful");
					UserRole role =
						UserRole.valueOf(resultSet.getString("employee_role"));
					return role;
				}
				else {
					LOGGER.log(Level.INFO, "Entry not found in Database");
				}
			}
			else {
				LOGGER.log(Level.INFO, "Failed to connect to database");
			}
		}
		catch (SQLException e1) {
			LOGGER.log(Level.INFO, "SQl Exception{0}", e1);
		}
		finally {
			try {
				resultSet.close();
				if (prepareStatementLoginCheck != null) {
					prepareStatementLoginCheck.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException e1) {
				LOGGER.log(Level.INFO, "SQLException{0}", e1);
			}

		}
		return UserRole.INVALID;
	}

	/**
	 * <p>Displays details of all employees</p>
	 * 
	 * @author srijan
	 */
	@Override
	public List<Employee> viewEmployeeDetails() {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection con = null;
		List<Employee> employees = new ArrayList<>();
		con = DbConnection.dbConnection();
		if (con != null) {
			String query =
				"Select * from employeeDetails where is_terminated = ?";
			try {
				statement = con.prepareStatement(query);
				statement.setBoolean(1, false);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Employee employee = new Employee();
					employee.setId(resultSet.getInt("id"));
					employee.setUserName(resultSet.getString("username"));
					employee.setFullName(resultSet.getString("fullName"));
					employee.setDepartment(resultSet.getString("department"));
					employee.setAddress(resultSet.getString("address"));
					employee.setIsTerminated(
						resultSet.getBoolean("is_terminated"));
					employees.add(employee);
				}
			}
			catch (SQLException e1) {
				LOGGER.log(Level.INFO, "SQL Exception{0}", e1);
			}
			finally {
				try {
					statement.close();
					con.close();
				}
				catch (SQLException e1) {
					LOGGER.log(Level.INFO, "SQL Exception{0}", e1);
				}
			}

		}
		return employees;
	}

	@Override
	public void terminate(int idToTerminate) {

		Connection con = null;
		ResultSet resultSet = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareStatementUpdateInfo = null;
		PreparedStatement prepareUpdate = null;
		try {
			if (con != null) {
				String query = "Select * from employeeDetails where id = ?";
				prepareStatementUpdateInfo = con.prepareStatement(query);
				prepareStatementUpdateInfo.setInt(1, idToTerminate);
				resultSet = prepareStatementUpdateInfo.executeQuery();
				while (resultSet.next()) {
					Boolean status = resultSet.getBoolean("is_terminated");
					status = !status;
					String queryUpdate =
						"UPDATE employeeDetails SET is_terminated = ? where id = ? ";
					prepareUpdate = con.prepareStatement(queryUpdate);
					prepareUpdate.setBoolean(1, status);
					prepareUpdate.setInt(2, idToTerminate);
					prepareUpdate.executeUpdate();
				}
			}
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception:{0}", ex);
		}
		finally {
			try {
				resultSet.close();
				prepareStatementUpdateInfo.close();
				prepareUpdate.close();
				con.close();
			}
			catch (SQLException ex) {
				LOGGER.log(Level.INFO, "SQL Exception {0}", ex);
			}
		}
	}

	/**
	 * <p>Find user by username</p>
	 * 
	 * @param userName
	 * @return
	 * @author srijan
	 */
	public Employee findUser(String userName) {

		System.out.println("profile");
		Connection con = null;
		ResultSet resultSet = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareStatementFindUser = null;
		Employee user = new Employee();
		try {
			if (con != null) {
				String query =
					"Select * from employeeDetails where username = ?";
				prepareStatementFindUser = con.prepareStatement(query);
				prepareStatementFindUser.setString(1, userName);
				resultSet = prepareStatementFindUser.executeQuery();
				while (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
					user.setUserName(resultSet.getString("username"));
					user.setFullName(resultSet.getString("fullName"));
					user.setDepartment(resultSet.getString("department"));
					user.setAddress(resultSet.getString("address"));
					user.setIsTerminated(resultSet.getBoolean("is_terminated"));
				}
			}
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception:{0}", ex);
		}
		finally {
			try {
				resultSet.close();
				prepareStatementFindUser.close();
				con.close();
			}
			catch (SQLException ex) {
				LOGGER.log(Level.INFO, "SQL Exception {0}", ex);
			}
		}
		return user;
	}

	@Override
	public void updateProfile(Employee changedProfileDetails) {

		Connection con = null;
		ResultSet resultSet = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareUpdateProfile = null;
		try {
			if (con != null) {
				String query =
					"Select * from employeeDetails where id = ? and is_terminated = ?";
				prepareUpdateProfile = con.prepareStatement(query);
				prepareUpdateProfile.setInt(1, changedProfileDetails.getId());
				prepareUpdateProfile.setBoolean(2, false);
				resultSet = prepareUpdateProfile.executeQuery();
				while (resultSet.next()) {
					String queryUpdate =
						"UPDATE employeeDetails SET username = ?,fullname = ?,department = ?,address = ? where id = ? ";
					prepareUpdateProfile = con.prepareStatement(queryUpdate);
					prepareUpdateProfile.setString(
						1, changedProfileDetails.getUserName());
					prepareUpdateProfile.setString(
						2, changedProfileDetails.getFullName());
					prepareUpdateProfile.setString(
						3, changedProfileDetails.getDepartment());
					prepareUpdateProfile.setString(
						4, changedProfileDetails.getAddress());
					prepareUpdateProfile.setInt(
						5, changedProfileDetails.getId());
					prepareUpdateProfile.executeUpdate();
				}
			}
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception:{0}", ex);
		}
		finally {
			try {
				resultSet.close();
				prepareUpdateProfile.close();
				con.close();
			}
			catch (SQLException ex) {
				LOGGER.log(Level.INFO, "SQL Exception {0}", ex);
			}
		}
	}

	@Override
	public Employee search(SearchEmployee e) {

		Connection con = null;
		ResultSet resultSet = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareSearch = null;
		Employee userSearch = new Employee();
		try {
			if (con != null) {
				String querySearch = "Select * from employeeDetails where " +
					e.getSearchChoice() + " = ? and is_terminated = ?";
				prepareSearch = con.prepareStatement(querySearch);
				prepareSearch.setString(1, e.getChoiceValue());
				prepareSearch.setBoolean(2, false);
				resultSet = prepareSearch.executeQuery();
				while (resultSet.next()) {
					userSearch.setId(resultSet.getInt("id"));
					userSearch.setUserName(resultSet.getString("username"));
					userSearch.setFullName(resultSet.getString("fullName"));
					userSearch.setDepartment(resultSet.getString("department"));
					userSearch.setAddress(resultSet.getString("address"));
					userSearch.setIsTerminated(
						resultSet.getBoolean("is_terminated"));
				}
			}
		}
		catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception:{0}", ex);
		}
		finally {
			try {
				resultSet.close();
				prepareSearch.close();
				con.close();
			}
			catch (SQLException ex) {
				LOGGER.log(Level.INFO, "SQL Exception {0}", ex);
			}
		}
		return userSearch;
	}
}
