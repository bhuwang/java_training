
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
	public Boolean addEmployee(Employee e) {
		Boolean addStatus = false;
		if (!"".equals(e.getUserName()) && !"".equals(e.getPassword()) &&
			!"".equals(e.getFullName()) && !"".equals(e.getDepartment())) {
			EmployeeDaoImpl addEmployeeToDb = DaoFactory.getEmployeeDao();
			addStatus = addEmployeeToDb.addEmployee(e);
		}
		return addStatus;
	}

	@Override
	public Employee findById(int idToEdit) {

		EmployeeDaoImpl updateEmployeeDetails = DaoFactory.getEmployeeDao();
		return updateEmployeeDetails.findById(idToEdit);
	}

	public UserRole save(Employee e) {
		UserRole role;
		if (!"".equals(e.getUserName()) && !"".equals(e.getPassword())) {
			EmployeeDaoImpl loginValidator = DaoFactory.getEmployeeDao();
			role =  loginValidator.loginValidation(e);
			return role;
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
	public Boolean terminate(int terminateEmployee) {

		EmployeeDaoImpl terminateStatus = DaoFactory.getEmployeeDao();
		return terminateStatus.terminate(terminateEmployee);
	}

	/**
	 * <p>Finds user by their userName</p>
	 * 
	 * @param userName
	 * @return
	 * @author srijan
	 */
	public Employee findUserByUserName(Employee e) {

		EmployeeDaoImpl findUserByUserName = DaoFactory.getEmployeeDao();
		return findUserByUserName.findUser(e);
	}

	
	public Boolean updateProfile(Employee changedProfileDetails) {
		Boolean updateStatus = false;
		EmployeeDaoImpl update = DaoFactory.getEmployeeDao();
	    updateStatus = update.updateProfile(changedProfileDetails);
	    return updateStatus;
	}

	@Override
	public  List<Employee> search(SearchEmployee searchEmp) {

		EmployeeDaoImpl searchUser = DaoFactory.getEmployeeDao();
		return searchUser.search(searchEmp);
	}
	
	@Override
	public Boolean checkUsernameValidation(Employee e){
		Boolean checkUser = false;
		if(!"".equals(e.getUserName())){
			EmployeeDaoImpl checkUserValidity = DaoFactory.getEmployeeDao();
			checkUser =checkUserValidity.checkUsernameValidation(e);
		}
		else{
			checkUser = true;
		}
		return checkUser;
	}
}
