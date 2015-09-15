package com.lftechnology.java.training.srijan.basics.coreapp.api;



import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;

public interface EmployeeApi {
	public void addEmployee(Employee e);
	public Employee findById(int e);
	public void updateEmployee(Employee e);
	void updateProfile(Employee changedProfileDetails,Employee employee);
}
