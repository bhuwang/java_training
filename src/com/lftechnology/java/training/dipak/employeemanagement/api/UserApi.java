package com.lftechnology.java.training.dipak.employeemanagement.api;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.User;

public interface UserApi {
	public Employee validateLogin(User u);
}
