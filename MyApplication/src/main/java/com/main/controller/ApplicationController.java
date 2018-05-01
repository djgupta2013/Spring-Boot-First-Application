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
	
	
	@RequestMapping("/")
	public String homepage() {
		return "welcomepage";
	}
	@RequestMapping("/incorrect")
	public String incorrect() {
		return "incorrect";
	}
	
	@RequestMapping("/newUser")
	public String registerFirst() {
		return "registerFirst";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
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
		 return userService.login(user);
	 }
	 
	 @RequestMapping("/login/forgetpassword")
		public String forgetPassword() {
			return "forgetPassword";
		}
	 
	 /*@RequestMapping("/login")
	 public String login(HttpServletRequest request) {
		 request.setAttribute("mode", "login");
		 return "welcome";
	 }
	 
	 
	 @RequestMapping("/register")
	 public String loginUser(@ModelAttribute User user,HttpServletRequest request) {
		 if(userService.findByEmailAndPassword(user.getEmail(), user.getPassword())!=null) {
			 return "welcomepage";
		 }
		 else {
			 request.setAttribute("error", "Invalid User and Password");
			 request.setAttribute("mode", "login");
		 }
		 return "welcome";
	 }
	*/
	 
	


}
