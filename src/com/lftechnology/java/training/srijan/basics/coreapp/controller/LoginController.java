
package com.lftechnology.java.training.srijan.basics.coreapp.controller;

import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.UserRole;
import com.lftechnology.java.training.srijan.basics.coreapp.service.EmployeeServiceImpl;
import com.lftechnology.java.training.srijan.basics.coreapp.service.ServiceFactory;
import com.lftechnology.java.training.srijan.basics.coreapp.ui.EmployeeView;

import java.util.Scanner;

public class LoginController {

	UserRole role;

	public LoginController() {
		this.role = UserRole.NORMAL;
	}
	EmployeeServiceImpl employeeServiceImpl =
		ServiceFactory.getEmployeeService();
	Employee e = new Employee();
	EmployeeView employeeView = new EmployeeView();

	public Employee save(String userName, String password,Scanner inputScanner) {

		e.setUserName(userName);
		e.setPassword(password);
		role = employeeServiceImpl.save(e);
		e.setUserRole(role);
		return e;
	}

	public void determineUserRole(Scanner inputScanner,Employee emp) {
		if (UserRole.ADMIN.equals(emp.getUserRole())) {
			employeeView.adminAccess(inputScanner);
		}
		else if (UserRole.NORMAL.equals(emp.getUserRole())) {
			employeeView.normalAccess(inputScanner,emp);
		}
	}
}
