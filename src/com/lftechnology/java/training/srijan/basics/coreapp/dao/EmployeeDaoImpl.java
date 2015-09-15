package com.lftechnology.java.training.srijan.basics.coreapp.dao;

import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class.getName());

	public void addEmployee(Employee e) {
		Connection con = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareStatementInsertEmployeeDetails = null;
		PreparedStatement prepareStatementLoginDetails = null;
		try {
			if (con != null) {
				String queryEmployee = "INSERT INTO employeeDetails (username,fullname,department,address,employee_role,is_terminated) VALUES(?,?,?,?,?,?)";
				String queryLogin = "INSERT INTO userCredential(user_name,password,is_terminated,user_role) VALUES(?,?,?,?)";
				prepareStatementInsertEmployeeDetails = con.prepareStatement(queryEmployee);
				prepareStatementLoginDetails = con.prepareStatement(queryLogin);
				prepareStatementInsertEmployeeDetails.setString(1, e.getUserName());
				prepareStatementInsertEmployeeDetails.setString(2, e.getFullName());
				prepareStatementInsertEmployeeDetails.setString(3, e.getDepartment());
				prepareStatementInsertEmployeeDetails.setString(4, e.getAddress());
				prepareStatementInsertEmployeeDetails.setString(5, e.getUserRole().name());
				prepareStatementInsertEmployeeDetails.setBoolean(6, e.getIsTerminated());
				prepareStatementLoginDetails.setString(1, e.getUserName());
				prepareStatementLoginDetails.setString(2, e.getPassword());
				prepareStatementLoginDetails.setBoolean(3, e.getIsTerminated());
				prepareStatementLoginDetails.setString(4, e.getUserRole().name());
				prepareStatementInsertEmployeeDetails.executeUpdate();
				prepareStatementLoginDetails.executeUpdate();
			}
		} catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception{0}", ex);
		} finally {
			try {
				prepareStatementInsertEmployeeDetails.close();
				prepareStatementLoginDetails.close();
				con.close();
			} catch (SQLException e1) {
				LOGGER.log(Level.INFO, "SQL Exception{0}", e1);
			}
		}
	}

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
					employee.setIsTerminated(resultSet.getBoolean("is_terminated"));
				}
			}
		} catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception:{0}", ex);
		} finally {
			try {
				resultSet.close();
				prepareStatementUpdateInfo.close();
				con.close();
			} catch (SQLException ex) {
				LOGGER.log(Level.INFO, "SQL Exception {0}", ex);
			}
		}
		return employee;
	}

	@Override
	public UserRole loginValidation(Employee e) {
		ResultSet resultSet = null;
		Connection con = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareStatementLoginCheck = null;
		try {
			if (con != null) {
				String query = "Select * from userCredential where user_name = ? and password = ?";
				prepareStatementLoginCheck = con.prepareStatement(query);
				prepareStatementLoginCheck.setString(1, e.getUserName());
				prepareStatementLoginCheck.setString(2, e.getPassword());
				resultSet = prepareStatementLoginCheck.executeQuery();
				if (resultSet.next()) {
					LOGGER.log(Level.INFO, "Login Successful");
					UserRole role = UserRole.valueOf(resultSet.getString("user_role"));
					return role;
				} else {
					LOGGER.log(Level.INFO, "Entry not found in Database");
				}
			} else {
				LOGGER.log(Level.INFO, "Failed to connect to database");
			}
		} catch (SQLException e1) {
			LOGGER.log(Level.INFO, "SQl Exception{0}", e1);
		} finally {
			try {
				resultSet.close();
				if (prepareStatementLoginCheck != null) {
					prepareStatementLoginCheck.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e1) {
				LOGGER.log(Level.INFO, "SQLException{0}", e1);
			}

		}
		return UserRole.INVALID;
	}

	@Override
	public List<Employee> viewEmployeeDetails() {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection con = null;
		List<Employee> employees = new ArrayList<>();
		con = DbConnection.dbConnection();
		if (con != null) {
			System.out.println("inside view employeedetails");
			String query = "Select * from employeeDetails";
			try {
				statement = con.createStatement();
				resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					Employee employee = new Employee();
					employee.setId(resultSet.getInt("id"));
					employee.setUserName(resultSet.getString("username"));
					employee.setFullName(resultSet.getString("fullName"));
					employee.setDepartment(resultSet.getString("department"));
					employee.setAddress(resultSet.getString("address"));
					employee.setIsTerminated(resultSet.getBoolean("is_terminated"));
					employees.add(employee);
				}
			} catch (SQLException e1) {
				LOGGER.log(Level.INFO, "SQL Exception{0}", e1);
			} finally {
				try {
					statement.close();
					con.close();
				} catch (SQLException e1) {
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
					String queryUpdate = "UPDATE employeeDetails SET is_terminated = ? where id = ? ";
					prepareUpdate = con.prepareStatement(queryUpdate);
					prepareUpdate.setBoolean(1, status);
					prepareUpdate.setInt(2, idToTerminate);
					prepareUpdate.executeUpdate();
				}
			}
		} catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception:{0}", ex);
		} finally {
			try {
				resultSet.close();
				prepareStatementUpdateInfo.close();
				prepareUpdate.close();
				con.close();
			} catch (SQLException ex) {
				LOGGER.log(Level.INFO, "SQL Exception {0}", ex);
			}
		}
	}

	public void updateEmployee(Employee e) {

	}

	public Employee findUser(String userName) {
		Connection con = null;
		ResultSet resultSet = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareStatementFindUser = null;
		Employee user = new Employee();
		try {
			if (con != null) {
				String query = "Select * from employeeDetails where username = ?";
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
		} catch (Exception ex) {
			LOGGER.log(Level.INFO, "Exception:{0}", ex);
		} finally {
			try {
				resultSet.close();
				prepareStatementFindUser.close();
				con.close();
			} catch (SQLException ex) {
				LOGGER.log(Level.INFO, "SQL Exception {0}", ex);
			}
		}
		return user;
	}

	public void updateProfile(Employee changedProfileDetails,Employee employee){
		Connection con = null;
		ResultSet resultSet = null;
		con = DbConnection.dbConnection();
		PreparedStatement prepareUpdateProfile = null;
		PreparedStatement prepareUpdate = null;
		try{
			if(con!=null){
				String query = "Select * from employeeDetails where id = ?";
				prepareUpdateProfile = con.prepareStatement(query);
				prepareUpdateProfile.setInt(1, employee.getId());
				resultSet = prepareUpdateProfile.executeQuery();
				while(resultSet.next()){
					String queryUpdate = "UPDATE employeeDetails SET username = ?,fullname = ?,department = ?,address = ? where id = ? ";
					prepareUpdateProfile = con.prepareStatement(queryUpdate);
					if(!"".equals(changedProfileDetails.getUserName()))
						prepareUpdateProfile.setString(1, changedProfileDetails.getUserName());
					else
						prepareUpdateProfile.setString(1, employee.getUserName());
					if(!"".equals(changedProfileDetails.getFullName()))
						prepareUpdateProfile.setString(2, changedProfileDetails.getFullName());
					else
						prepareUpdateProfile.setString(2, employee.getFullName());
					if(!"".equals(changedProfileDetails.getDepartment()))
						prepareUpdateProfile.setString(3, changedProfileDetails.getDepartment());
					else
						prepareUpdateProfile.setString(3, employee.getDepartment());
					if(!"".equals(changedProfileDetails.getAddress()))	
						prepareUpdateProfile.setString(4, changedProfileDetails.getAddress());
					else
						prepareUpdateProfile.setString(4, employee.getAddress());
					
					prepareUpdateProfile.setInt(5, employee.getId());
					prepareUpdateProfile.executeUpdate();
					String qryUpdate = "UPDATE userCredential SET user_name = ? where user_name = ?";
					prepareUpdate = con.prepareStatement(qryUpdate);
					if(!"".equals(changedProfileDetails.getUserName()))
						prepareUpdate.setString(1, changedProfileDetails.getUserName());
					else
						prepareUpdate.setString(1, employee.getUserName());
					prepareUpdate.setString(2, employee.getUserName());
					prepareUpdate.executeUpdate();
				}
			}	
		}catch(Exception ex){
			LOGGER.log(Level.INFO, "Exception:{0}", ex);
		}finally{	
			try {
				resultSet.close();
				prepareUpdate.close();
				prepareUpdateProfile.close();
				con.close();
			} catch (SQLException ex) {
				LOGGER.log(Level.INFO, "SQL Exception {0}", ex);
			}
		}
	}
}
