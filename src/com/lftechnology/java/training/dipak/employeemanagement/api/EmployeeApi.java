package com.lftechnology.java.training.dipak.employeemanagement.api;

import java.sql.ResultSet;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;

public interface EmployeeApi {
	public int addEmployee(Employee e);
	
	public ResultSet viewEmployee(Employee e);
	
//	public int deleteEmployee(Employee e);
	
	public int terminateEmployee(Employee e);
	
	public Employee editEmployeeDetails(Employee e);
}
