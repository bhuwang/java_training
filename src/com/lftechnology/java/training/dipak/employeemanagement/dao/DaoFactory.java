
package com.lftechnology.java.training.dipak.employeemanagement.dao;

public class DaoFactory {

	public static EmployeeDao getEmployeeDao() {

		return new EmployeeDao();
	}

	public static LoginDao getLoginDao() {

		return new LoginDao();
	}
}
