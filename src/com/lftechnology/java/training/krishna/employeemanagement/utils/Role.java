
package com.lftechnology.java.training.krishna.employeemanagement.utils;

/**
 * This program defines role of employee
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public enum Role {
	ADMIN("Admin"), USER("User");

	private String role;

	private Role(String role) {

		this.role = role;
	}

	public String getRole() {

		return role;
	}

	public void setRole(String role) {

		this.role = role;
	}

}
