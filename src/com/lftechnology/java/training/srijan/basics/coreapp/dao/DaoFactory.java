package com.lftechnology.java.training.srijan.basics.coreapp.dao;

public class DaoFactory {
	private DaoFactory() {

	}

	public static EmployeeDaoImpl getEmployeeDao() {
		return new EmployeeDaoImpl();
	}
}
