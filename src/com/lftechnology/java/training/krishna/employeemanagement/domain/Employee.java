
package com.lftechnology.java.training.krishna.employeemanagement.domain;

/**
 * This program store employee information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class Employee extends User {

	private String fullname;
	private String department;
	private String address;
	private String role;

	//constructor
	public Employee() {

	}


	public String getFullname() {

		return fullname;
	}

	public void setFullname(String fullname) {

		this.fullname = fullname;
	}

	public String getDepartment() {

		return department;
	}

	public void setDepartment(String department) {

		this.department = department;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public String getRole() {

		return role;
	}

	public void setRole(String role) {

		this.role = role;
	}



	@Override
	public String toString() {

		return "Employee [fullname=" + fullname + ", department=" + department +
			", address=" + address + ", role=" + role + ", getId()=" + getId() +
			", getUsername()=" + getUsername() + ", getPassword()=" +
			getPassword() + ", getIsTerminated()=" + getIsTerminated() +
			", getCreatedAt()=" + getCreatedAt() + ", getModifiedAt()=" +
			getModifiedAt() + ", toString()=" + super.toString() +
			", getClass()=" + getClass() + "]";
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result =
			prime * result + ((department == null) ? 0 : department.hashCode());
		result =
			prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		}
		else if (!address.equals(other.address))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		}
		else if (!department.equals(other.department))
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		}
		else if (!fullname.equals(other.fullname))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		}
		else if (!role.equals(other.role))
			return false;
		return true;
	}

}
