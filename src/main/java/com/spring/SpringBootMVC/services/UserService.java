package com.spring.SpringBootMVC.services;

import java.util.List;

import com.spring.SpringBootMVC.model.UserModel;

public interface UserService 
{
	public List<UserModel> getUsers();
	public UserModel getUser(int userId);
	public Boolean createUser(UserModel userObj);
	public Boolean updateUser(String userId,UserModel userDetails);
	public Boolean deleteUsers();
	public Boolean deleteUser(int userId);
}
