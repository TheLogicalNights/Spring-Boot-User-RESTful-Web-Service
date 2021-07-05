package com.spring.SpringBootMVC.controller;

import java.util.List;
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
	@Autowired
	UserServiceImpl userServiceObj;
	
	@GetMapping(path="/{userId}")
	public ResponseEntity<UserModel> getUser(@PathVariable int userId)
	{
		UserModel user = userServiceObj.getUser(userId);
		return new ResponseEntity<UserModel>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserModel>> getStudents()
	{
		List<UserModel> users = userServiceObj.getUsers();
		return new ResponseEntity<List<UserModel>>(users,HttpStatus.OK);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							 MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> createUser(@Valid @RequestBody UserModel userObj)
	{
		Boolean bRet = userServiceObj.createUser(userObj);
		if(bRet)
		{
			return new ResponseEntity<String>("User created successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Unable to crerate user",HttpStatus.NOT_MODIFIED);
		}
	}
	
	@PutMapping(path="/{userId}",consumes = {MediaType.APPLICATION_JSON_VALUE,
											 MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> updateUser(@PathVariable int userId,@RequestBody UserModel userDetails)
	{
		Boolean bRet = userServiceObj.updateUser(userId, userDetails);
		if(bRet)
		{
			return new ResponseEntity<String>("User updated successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Unable to update user",HttpStatus.NOT_MODIFIED);
		}
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId)
	{
		Boolean bRet = userServiceObj.deleteUser(userId);
		if(bRet)
		{
			return new ResponseEntity<String>("User deleted successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Unable to delete user",HttpStatus.NOT_MODIFIED);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteUsers()
	{
		Boolean bRet = userServiceObj.deleteUsers();
		if(bRet)
		{
			return new ResponseEntity<String>("Users deleted successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Unable to delete users",HttpStatus.NOT_MODIFIED);
		}
	}
}
