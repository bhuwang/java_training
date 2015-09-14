
package com.lftechnology.java.training.krishna.employeemanagement.domain;

import java.sql.Date;

/**
 * This program store user information
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class User {

	private int id;
	private String username;
	private String password;
	private int isTerminated;
	private Date createdAt;
	private Date modifiedAt;

	public User() {

	}

	public User(
		int id, String username, String password, int isTerminated,
		Date createdAt, Date modifiedAt) {

		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isTerminated = isTerminated;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public int getIsTerminated() {

		return isTerminated;
	}

	public void setIsTerminated(int isTerminated) {

		this.isTerminated = isTerminated;
	}

	public Date getCreatedAt() {

		return createdAt;
	}

	public void setCreatedAt(Date timestamp) {

		this.createdAt = timestamp;
	}

	public Date getModifiedAt() {

		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {

		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {

		return "User [id=" + id + ", username=" + username + ", password=" +
			password + ", isTerminated=" + isTerminated + ", createdAt=" +
			createdAt + ", modifiedAt=" + modifiedAt + "]";
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result =
			prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + isTerminated;
		result =
			prime * result + ((modifiedAt == null) ? 0 : modifiedAt.hashCode());
		result =
			prime * result + ((password == null) ? 0 : password.hashCode());
		result =
			prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		}
		else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (isTerminated != other.isTerminated)
			return false;
		if (modifiedAt == null) {
			if (other.modifiedAt != null)
				return false;
		}
		else if (!modifiedAt.equals(other.modifiedAt))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		}
		else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		}
		else if (!username.equals(other.username))
			return false;
		return true;
	}

}
