
package com.lftechnology.java.training.srijan.basics.coreapp.domain;

public class Employee {

	private int id;
	private String userName;
	private String password;
	private Boolean isTerminated;
	private UserRole role;
	private String fullName;
	private String department;
	private String address;

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public UserRole getRole() {

		return role;
	}

	public void setRole(UserRole role) {

		this.role = role;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public void setIsTerminated(Boolean isTerminated) {

		this.isTerminated = isTerminated;
	}

	public String getUserName() {

		return this.userName;
	}

	public String getPassword() {

		return this.password;
	}

	public Boolean getIsTerminated() {

		return this.isTerminated;
	}

	public UserRole getUserRole() {

		return role;
	}

	public void setUserRole(UserRole role) {

		this.role = role;
	}

	public String getFullName() {

		return fullName;
	}

	public void setFullName(String fullName) {

		this.fullName = fullName;
	}

	public void setDepartment(String department) {

		this.department = department;
	}

	public String getDepartment() {

		return department;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public String getAddress() {

		return address;
	}

	@Override
	public String toString() {

		return "id=" + id + ", userName=" + userName + ", Terminated=" +
			isTerminated + ", role=" + role + ", fullName=" + fullName +
			", department=" + department + ", address=" + address + "\n";
	}

}
