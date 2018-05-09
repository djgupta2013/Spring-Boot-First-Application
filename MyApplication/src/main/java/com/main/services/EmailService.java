package com.main.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.main.model.User;
@Repository
public interface EmailService extends CrudRepository<User, Integer> {
	
	
	
	
	
//	extends CrudRepository<OtpMsg, Integer>
}
