package com.spring.SpringBootMVC.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringBootMVC.model.UserModel;
import com.spring.SpringBootMVC.servicesImpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController 
{
	Map<String, UserModel> user;
	@Autowired
	UserServiceImpl userServiceObj;
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
	public ResponseEntity<String> createUser(@Valid @RequestBody UserModel userObj)
	{
		UserModel returnValue = userServiceObj.createUser(userObj);
		if(user==null)
		{
			user = new HashMap<>();
		}
		user.put(returnValue.getUserId(), returnValue);
		return new ResponseEntity<String>("User created successfully",HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}",consumes = {MediaType.APPLICATION_JSON_VALUE,
											 MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> updateUser(@PathVariable String userId,@RequestBody UserModel userDetails)
	{
		UserModel returnValue = userServiceObj.updateUser(userId, userDetails);
		user.put(userId, returnValue);
		return new ResponseEntity<String>("User updated successfully",HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId)
	{
		user.remove(userId);
		return new ResponseEntity<String>("User Deleted Successfully",HttpStatus.OK);
	}
}
