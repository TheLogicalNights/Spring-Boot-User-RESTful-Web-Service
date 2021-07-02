package com.spring.SpringBootMVC.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringBootMVC.model.UserModel;
import com.spring.SpringBootMVC.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserModel returnValue;
	@Override
	public UserModel createUser(UserModel userObj) {
		returnValue.setUserId(userObj.getUserId());
		returnValue.setFirstName(userObj.getFirstName());
		returnValue.setLastName(userObj.getLastName());
		returnValue.setEmail(userObj.getEmail());
		
		return returnValue;
	}
	@Override
	public UserModel updateUser(String userId, UserModel userDetails) {
		returnValue.setUserId(userId);
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());
		
		return returnValue;
	} 

}
