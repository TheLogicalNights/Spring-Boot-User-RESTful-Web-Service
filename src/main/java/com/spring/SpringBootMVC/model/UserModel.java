package com.spring.SpringBootMVC.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@NotNull(message = "firstName cannot be null")
	private String firstName;
	@NotNull(message = "lastName cannot be null")
	private String lastName;
	@NotNull(message = "email cannot be null")
	@Email(message = "Invalid email id, please enter valid email id")
	private String email;

	public UserModel(int userId, @NotNull(message = "firstName cannot be null") String firstName,
			@NotNull(message = "lastName cannot be null") String lastName,
			@NotNull(message = "email cannot be null") @Email(message = "Invalid email id, please enter valid email id") String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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
