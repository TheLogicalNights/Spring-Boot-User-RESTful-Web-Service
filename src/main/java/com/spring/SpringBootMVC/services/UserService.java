package com.spring.SpringBootMVC.services;

import com.spring.SpringBootMVC.model.UserModel;

public interface UserService 
{
	UserModel createUser(UserModel userObj);
	UserModel updateUser(String userId,UserModel userDetails);
}
