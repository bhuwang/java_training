
package com.lftechnology.java.training.krishna.employeemanagement.service.employee.impl;

import java.util.List;

import com.lftechnology.java.training.krishna.employeemanagement.dao.employee.impl.EmployeeDaoImpl;
import com.lftechnology.java.training.krishna.employeemanagement.domain.Employee;
import com.lftechnology.java.training.krishna.employeemanagement.service.employee.EmployeeService;
import com.lftechnology.java.training.krishna.employeemanagement.utils.DateUtils;

/**
 * Implementation of employee service interface.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDaoImpl employeeDaoImpl;

	public EmployeeServiceImpl() {

		this.employeeDaoImpl = new EmployeeDaoImpl();
	}

	@Override
	public boolean delete(String fullname) {

		Employee emp = new Employee();
		emp.setFullname(fullname);
		return this.employeeDaoImpl.delete(emp);
	}

	@Override
	public List<Employee> findAll(String key) {

		return this.employeeDaoImpl.findAll(key);
	}

	@Override
	public boolean terminate(String fullname) {

		Employee emp = new Employee();
		emp.setFullname(fullname);
		emp.setModifiedAt(DateUtils.getCurrentTimeStamp());
		return this.employeeDaoImpl.terminate(emp);
	}

	@Override
	public Employee saveEmployee(
		String username, String password, String fullname, String department,
		String address, String role) {

		Employee employee = null;
		boolean isDuplicate = this.employeeDaoImpl.isDuplicate(username);
		if (!isDuplicate) {
			Employee emp = new Employee();
			emp.setUsername(username);
			emp.setPassword(password);
			emp.setFullname(fullname);
			emp.setDepartment(department);
			emp.setAddress(address);
			emp.setRole(role);
			emp.setCreatedAt(DateUtils.getCurrentTimeStamp());
			employee = this.employeeDaoImpl.create(emp);
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(
		int id, String fullname, String department, String address) {

		Employee emp = new Employee();
		emp.setId(id);
		emp.setFullname(fullname);
		emp.setDepartment(department);
		emp.setAddress(address);
		emp.setModifiedAt(DateUtils.getCurrentTimeStamp());
		return this.employeeDaoImpl.update(emp);
	}

	@Override
	public Employee findById(Integer id) {

		return this.employeeDaoImpl.findById(id);
	}

}
