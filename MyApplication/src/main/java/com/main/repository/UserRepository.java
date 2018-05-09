package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	List<User> findByEmail(String email);
	List<User> deleteByEmail(String email);
	
	
	
	@Modifying
	@Query("update User u set u.password = :password where u.email = :email")
	int setPasswordByEmail(@Param("password") String password, @Param("email") String email);
	//public User updatePassword(String password);
	//update otp
	@Modifying
	@Query("update User u set u.otp = :otp where u.email = :email")
	int setOtpByEmail(@Param("otp") int otp, @Param("email") String email);
	
	//User findByOtp(int otp);
	
	public User findByEmailAndPasswordAndOtp(String email,String password,int otp);

}
