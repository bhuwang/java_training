package com.lftechnology.java.training.srijan.basics.coreapp.dao;

public class DaoFactory {

	public static EmployeeDaoImpl getEmployeeDao(){
		return new EmployeeDaoImpl();
	}
}
