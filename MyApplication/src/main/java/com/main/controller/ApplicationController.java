package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.model.User;
import com.main.services.UserService;

@Controller
public class ApplicationController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/welcome")
	public String Welcome() {
		return "welcomepage";
	}
	
	/*@RequestMapping("/error")
	public String error() {
		return "error";
	}*/
	
	 @RequestMapping(value="/register", method = RequestMethod.GET)
	    public String saveUser(ModelMap model){
	        return "register";
	    }
	 
	 @RequestMapping(value="/register", method = RequestMethod.POST)
	 public String saveUser(ModelMap model,@RequestParam String email,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password){
		
		 User user=new User(email, firstname,lastname,age,password);
		 userService.saveMyUser(user);
			return "login"; 
	       
	 }
	 
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	    public String userLogin(ModelMap model){
	        return "login";
	    }
	 @RequestMapping(value="/login", method = RequestMethod.POST)
	 public String userLogin(ModelMap model,@RequestParam String email,@RequestParam String password) {
		 User user=new User(email, password);
		 userService.login(user);
		 
		 
		 return "welcome";
	 }
	 
	
	 
	


}
