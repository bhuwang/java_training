
package com.lftechnology.java.training.dipak.employeemanagement.controller;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

public class LogOutController {

	public static Employee logOut(Employee e) {

		e.setId(0);
		e.setUserName("");
		e.setPassword("");
		e.setAddress("");
		e.setDepartment("");
		e.setRole(UserType.INVALID);
		e.setFullName("");
		e.setIsTerminated(true);
		return e;
	}
}
