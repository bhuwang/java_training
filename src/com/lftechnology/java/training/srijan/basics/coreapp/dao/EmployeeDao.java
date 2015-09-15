package com.lftechnology.java.training.srijan.basics.coreapp.dao;

import java.util.List;

import com.lftechnology.java.training.srijan.basics.coreapp.api.EmployeeApi;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.UserRole;

public interface EmployeeDao extends EmployeeApi {

	UserRole loginValidation(Employee e);
	List<Employee> viewEmployeeDetails();
	void terminate(int idToTerminate);
}
