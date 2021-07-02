package com.spring.SpringBootMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@GetMapping("/{userId}")
	public String getUser(@PathVariable String userId)
	{
		return "getUser() was called with userId = " + userId;
	}
	
	@PostMapping
	public String createUser()
	{
		return "createUser() was called";
	}
	
	@PutMapping
	public String updateUser()
	{
		return "updateUser() was called";
	}
	
	public String deleteUser()
	{
		return "deleteUser() was called";
	}
}
