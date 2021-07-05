package com.spring.SpringBootMVC.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringBootMVC.model.UserModel;
import com.spring.SpringBootMVC.repository.UserRepository;
import com.spring.SpringBootMVC.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepositoryObj;

	@Override
	public Boolean createUser(UserModel userObj) {
		userRepositoryObj.save(userObj);
		return true;
	}

	@Override
	public List<UserModel> getUsers() {
		List<UserModel> returnList = (List<UserModel>) userRepositoryObj.findAll();
		return returnList;
	}

	@Override
	public UserModel getUser(int userId) {
		UserModel returnObj = userRepositoryObj.findById(userId);
		return returnObj;
	}

	@Override
	public Boolean updateUser(int userId, UserModel userDetails) {
		userDetails.setUserId(userId);
		userRepositoryObj.save(userDetails);
		return true;
	}

	@Override
	public Boolean deleteUsers() {
		userRepositoryObj.deleteAll();
		return null;
	}

	@Override
	public Boolean deleteUser(int userId) {
		userRepositoryObj.deleteById(userId);
		return null;
	}
}
