package com.spring.SpringBootMVC.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringBootMVC.model.UserModel;

@RestController
@RequestMapping("/users")
public class UserController 
{
	Map<String, UserModel> user;
	@GetMapping(path="/{userId}")
	public ResponseEntity<UserModel> getUser(@PathVariable String userId)
	{
		if(user.containsKey(userId))
		{
			return new ResponseEntity<UserModel>(user.get(userId),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							 MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> createUser(@Valid @RequestBody UserModel studentObj)
	{
		UserModel returnValue = new UserModel();
		returnValue.setUserId(studentObj.getUserId());
		returnValue.setFirstName(studentObj.getFirstName());
		returnValue.setLastName(studentObj.getLastName());
		returnValue.setEmail(studentObj.getEmail());
		
		if(user==null)
		{
			user = new HashMap<>();
		}
		user.put(returnValue.getUserId(), returnValue);
		return new ResponseEntity<String>("User created successfully",HttpStatus.OK);
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
