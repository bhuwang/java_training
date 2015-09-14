
package com.lftechnology.java.training.krishna.employeemanagement.service.employee.impl;

import java.util.List;

import com.lftechnology.java.training.krishna.employeemanagement.dao.employee.impl.EmployeeDaoImpl;
import com.lftechnology.java.training.krishna.employeemanagement.domain.Employee;
import com.lftechnology.java.training.krishna.employeemanagement.service.employee.EmployeeService;
import com.lftechnology.java.training.krishna.employeemanagement.utils.DateUtils;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDaoImpl employeeDaoImpl;

	public EmployeeServiceImpl() {

		this.employeeDaoImpl = new EmployeeDaoImpl();
	}


	@Override
	public boolean delete(String fullname) {

		Employee emp = new Employee();
		emp.setFullname(fullname);
		boolean isDeleted = this.employeeDaoImpl.delete(emp);
		return isDeleted;
	}

	@Override
	public List<Employee> findAll(String key) {

		List<Employee> empList = this.employeeDaoImpl.findAll(key);
		return empList;
	}

	@Override
	public boolean terminate(String fullname) {

		Employee emp = new Employee();
		emp.setFullname(fullname);
		emp.setModifiedAt(DateUtils.getCurrentTimeStamp());
		boolean isTerminated = this.employeeDaoImpl.terminate(emp);
		return isTerminated;
	}

	@Override
	public Employee saveEmployee(
		String username, String password, String fullname, String department,
		String address, String role) {

		Employee emp = new Employee();
		emp.setUsername(username);
		emp.setPassword(password);
		emp.setFullname(fullname);
		emp.setDepartment(department);
		emp.setAddress(address);
		emp.setRole(role);
		emp.setCreatedAt(DateUtils.getCurrentTimeStamp());
		Employee employee = this.employeeDaoImpl.create(emp);
		return employee;
	}


	@Override
	public Employee updateEmployee(int id,
		String fullname, String department, String address) {
		Employee emp = new Employee();
		emp.setId(id);
		emp.setFullname(fullname);
		emp.setDepartment(department);
		emp.setAddress(address);
		emp.setModifiedAt(DateUtils.getCurrentTimeStamp());
		Employee employee =this.employeeDaoImpl.update(emp);
		return employee;
	}

}
