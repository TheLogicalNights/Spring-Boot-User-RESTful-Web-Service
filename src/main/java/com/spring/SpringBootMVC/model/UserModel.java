package com.spring.SpringBootMVC.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

@Service
public class UserModel {
	@NotNull(message = "userId cannot be null")
	private String userId;
	@NotNull(message = "firstName cannot be null")
	private String firstName;
	@NotNull(message = "lastName cannot be null")
	private String lastName;
	@NotNull(message = "email cannot be null")
	@Email(message = "Invalid email id, please enter valid email id")
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
