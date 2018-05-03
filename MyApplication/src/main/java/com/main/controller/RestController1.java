package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.User;
import com.main.services.UserService;

@RestController
public class RestController1 {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/abc")
	public String hello() {
		return "This is home Page";
	}
	
	 
	 
	@GetMapping("/save.user")
	public String saveUser(@RequestParam String email,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password) {
		User user=new User(email, firstname, lastname, age, password);
		userService.saveMyUser(user);
		return "User Saved"; 
	}
	
}
