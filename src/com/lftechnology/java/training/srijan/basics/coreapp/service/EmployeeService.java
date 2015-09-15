package com.lftechnology.java.training.srijan.basics.coreapp.service;

import java.util.List;

import com.lftechnology.java.training.srijan.basics.coreapp.api.EmployeeApi;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;


public interface EmployeeService extends EmployeeApi{
	List<Employee> viewAllUser(Employee e);
	void terminate(int terminateEmployee);
}
