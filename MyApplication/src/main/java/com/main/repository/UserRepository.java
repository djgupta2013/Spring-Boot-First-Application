package com.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.main.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
