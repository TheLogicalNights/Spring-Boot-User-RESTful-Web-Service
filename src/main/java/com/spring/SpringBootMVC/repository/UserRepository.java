package com.spring.SpringBootMVC.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.spring.SpringBootMVC.model.UserModel;

@Service
public interface UserRepository extends CrudRepository<UserModel, Integer>{
	public UserModel findById(int userId);
}
