package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.main.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	List<User> findByEmail(String email);
	
	@Modifying
	@Query("update User u set u.password = :password where u.email = :email")
	int setPasswordByEmail(@Param("password") String password, @Param("email") String email);
	//public User updatePassword(String password);
	
	public User findByEmailAndPassword(String email,String password);

}
