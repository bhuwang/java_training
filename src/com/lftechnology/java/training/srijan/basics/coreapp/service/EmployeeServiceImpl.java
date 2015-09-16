
package com.lftechnology.java.training.srijan.basics.coreapp.service;

import com.lftechnology.java.training.srijan.basics.coreapp.dao.DaoFactory;
import com.lftechnology.java.training.srijan.basics.coreapp.dao.EmployeeDaoImpl;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.SearchEmployee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.UserRole;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeServiceImpl implements EmployeeService {

	private String nullUserNameMsg;
	private String nullPasswordMsg;
	private static final Logger LOGGER =
		Logger.getLogger(EmployeeServiceImpl.class.getName());

	public EmployeeServiceImpl() {
		this.nullUserNameMsg = "Username cannot be Empty";
		this.nullPasswordMsg = "Password cannot be Empty";
	}

	@Override
	public void addEmployee(Employee e) {

		if (!"".equals(e.getUserName()) && !"".equals(e.getPassword()) &&
			!"".equals(e.getFullName()) && !"".equals(e.getDepartment())) {
			EmployeeDaoImpl addEmployeeToDb = DaoFactory.getEmployeeDao();
			addEmployeeToDb.addEmployee(e);
		}
		else {
			LOGGER.log(Level.INFO, "please fill up all information");
		}

	}

	@Override
	public Employee findById(int idToEdit) {

		EmployeeDaoImpl updateEmployeeDetails = DaoFactory.getEmployeeDao();
		return updateEmployeeDetails.findById(idToEdit);
	}

	public UserRole save(Employee e) {

		if (!"".equals(e.getUserName()) && !"".equals(e.getPassword())) {
			EmployeeDaoImpl loginValidator = DaoFactory.getEmployeeDao();
			return loginValidator.loginValidation(e);
		}
		if ("".equals(e.getUserName())) {
			LOGGER.log(Level.INFO, "{0}", this.nullUserNameMsg);
		}
		else if ("".equals(e.getPassword())) {
			LOGGER.log(Level.INFO, "{0}", this.nullPasswordMsg);
		}
		return UserRole.INVALID;
	}

	@Override
	public List<Employee> viewAllUser(Employee e) {

		EmployeeDaoImpl viewEmployeeDetailsInDb = DaoFactory.getEmployeeDao();
		List<Employee> employees =
			viewEmployeeDetailsInDb.viewEmployeeDetails();
		return employees;
	}

	@Override
	public void terminate(int terminateEmployee) {

		EmployeeDaoImpl terminateStatus = DaoFactory.getEmployeeDao();
		terminateStatus.terminate(terminateEmployee);
	}

	/**
	 * <p>Finds user by their userName</p>
	 * 
	 * @param userName
	 * @return
	 * @author srijan
	 */
	public Employee findUserByUserName(String userName) {

		EmployeeDaoImpl findUserByUserName = DaoFactory.getEmployeeDao();
		return findUserByUserName.findUser(userName);
	}

	@Override
	public void updateProfile(Employee changedProfileDetails) {

		EmployeeDaoImpl update = DaoFactory.getEmployeeDao();
		update.updateProfile(changedProfileDetails);
	}

	@Override
	public Employee search(SearchEmployee searchEmp) {

		EmployeeDaoImpl searchUser = DaoFactory.getEmployeeDao();
		return searchUser.search(searchEmp);
	}
}
