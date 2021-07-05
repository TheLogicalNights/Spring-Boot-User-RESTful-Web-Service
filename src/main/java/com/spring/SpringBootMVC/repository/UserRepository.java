package com.spring.SpringBootMVC.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.SpringBootMVC.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer>{

}
