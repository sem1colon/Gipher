package com.stackroute.accountmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@Column(name = "id")
	@Size(max = 70, message = "UserID cannot exceed 70 characters!")
	private String userId;

	@NotNull(message = "Name cannot be empty!")
	@Column(name = "name")
	@Size(max = 70, message = "Name cannot exceed 70 characters!")
	private String name;

	@NotNull(message = "Password cannot be empty!")
	@Size(min = 6, max = 128, message = "Password must be 6 to 30 characters!")
	@Column(name = "password", length = 1000)
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

	public User(@Size(max = 70, message = "UserID cannot exceed 70 characters!") String userId,
			@NotNull(message = "Name cannot be empty!") @Size(max = 70, message = "Name cannot exceed 70 characters!") String name,
			@NotNull(message = "Password cannot be empty!") @Size(min = 6, max = 128, message = "Password must be 6 to 30 characters!") String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + "]";
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
