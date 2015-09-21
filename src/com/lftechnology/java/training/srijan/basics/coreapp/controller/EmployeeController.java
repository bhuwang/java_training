
package com.lftechnology.java.training.srijan.basics.coreapp.controller;

import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.SearchEmployee;
import com.lftechnology.java.training.srijan.basics.coreapp.service.EmployeeServiceImpl;
import com.lftechnology.java.training.srijan.basics.coreapp.service.ServiceFactory;

import java.util.List;

public class EmployeeController {

	EmployeeServiceImpl employeeServiceImpl =
		ServiceFactory.getEmployeeService();
	List<Employee> employees;
	SearchEmployee empSearch = new SearchEmployee();

	public EmployeeController() {

	}

	public Boolean addEmployee(Employee e) {

		return employeeServiceImpl.addEmployee(e);
	}

	public List<Employee> viewAllUser(Employee e) {

		return employeeServiceImpl.viewAllUser(e);

	}

	public List<Employee> search(SearchEmployee empSearch) {
		
		return employeeServiceImpl.search(empSearch);
	}

	public Boolean terminate(int terminateEmployee) {

		return employeeServiceImpl.terminate(terminateEmployee);
	}

	public Employee findUserByUserName(Employee e) {

		return employeeServiceImpl.findUserByUserName(e);
	}

	public Boolean updateProfile(Employee changedProfileDetails) {

		return employeeServiceImpl.updateProfile(changedProfileDetails);
	}

	public Boolean checkUsernameValidation(Employee e) {

		return employeeServiceImpl.checkUsernameValidation(e);
	}

}
