package com.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.main.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	List<User> findByEmail(String email);

}
