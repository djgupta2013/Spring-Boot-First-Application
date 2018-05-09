package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.User;
import com.main.servicesImpl.UserServiceImpl;

@RestController
public class RestController1 {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/abc")
	public String hello() {
		return "This is home Page";
	}
	
	 
	 
	@GetMapping("/save.user")
	public String saveUser(@RequestParam String email,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password) {
		int otp=0;
		User user=new User(email, firstname, lastname, age, password,otp);
		userService.saveMyUser(user);
		return "User Saved"; 
	}
	
}
