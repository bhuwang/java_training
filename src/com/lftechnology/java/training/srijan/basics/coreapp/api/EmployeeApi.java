
package com.lftechnology.java.training.srijan.basics.coreapp.api;

import com.lftechnology.java.training.srijan.basics.coreapp.domain.Employee;
import com.lftechnology.java.training.srijan.basics.coreapp.domain.SearchEmployee;

public interface EmployeeApi {

	/**
	 * <p>Establish Connection with database</p> <p>Add Employee in database</p>
	 * 
	 * @author srijan
	 */
	public void addEmployee(Employee e);

	/**
	 * <p>Finds Employee by their Id</p>
	 * 
	 * @author srijan
	 */
	public Employee findById(int e);

	/**
	 * <p>Update user profile</p>
	 * 
	 * @author srijan
	 */
	public void updateProfile(Employee changedProfileDetails);

	/**
	 * <p>Terminates user profile</p>
	 * 
	 * @param terminateEmployee
	 * @author srijan
	 */
	public void terminate(int terminateEmployee);

	/**
	 * <p>Inputs choice of search and value of search from user and finds user
	 * according to the inputs</p>
	 * 
	 * @param searchEmp
	 * @return
	 * @author srijan
	 */
	public Employee search(SearchEmployee searchEmp);
}
