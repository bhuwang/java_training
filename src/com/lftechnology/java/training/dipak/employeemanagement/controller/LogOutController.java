
package com.lftechnology.java.training.dipak.employeemanagement.controller;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

/**
 * <p>This class is used to provide logout functionality.</p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */

public class LogOutController {
	private LogOutController() {
		
	}
	/**
	 * <p>This method changes the values of the employee object by emptying the
	 * fields or placing random values.</p>
	 * 
	 * @param e
	 * @return e
	 */
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
