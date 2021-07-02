package com.spring.SpringBootMVC.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.SpringBootMVC.model.UserModel;

public interface UserService 
{
	UserModel createUser(UserModel userObj);
	UserModel updateUser(String userId,UserModel userDetails);
}
