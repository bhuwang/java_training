
package com.lftechnology.java.training.dipak.employeemanagement.service;

import com.lftechnology.java.training.dipak.employeemanagement.api.UserApi;
import com.lftechnology.java.training.dipak.employeemanagement.dao.DaoFactory;
import com.lftechnology.java.training.dipak.employeemanagement.dao.LoginDao;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.User;

public class LoginService implements UserApi {

	@Override
	public Employee validateLogin(User u) {

		Employee employee = new Employee();
		LoginDao ld = DaoFactory.getLoginDao();
		String userNameFormat = "[a-zA-z][a-zA-z0-9._@]+";
		if (u.getUserName().matches(userNameFormat)) {
			employee = ld.validateLogin(u);
		}
		else {
			employee.setId(-1);
		}
		return employee;
	}
}
