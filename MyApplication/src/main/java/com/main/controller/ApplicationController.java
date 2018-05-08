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
	
	
	//@RequestMapping(value="/incorrect", method = RequestMethod.GET)
	
	
	
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
		 return userService.saveMyUser(user);   
	 }
	 
	 public String userExists() {
			return "userExists";
		}
	 
	 @RequestMapping("/newUser")
		public String registerFirstPopUp() {
			return "registerFirstPopUp";
		}
	 
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	    public String userLogin(){
	        return "login";
	    }	
	 @RequestMapping(value="/login", method = RequestMethod.POST)
	 public String userLogin(ModelMap model,@RequestParam String email,@RequestParam String password) {
		 User user=new User(email, password);
		 return userService.login(user);
	 }
	 
	 @RequestMapping("/incorrect")
		public String incorrect() {
			//incorrect1();
		return	"incorrect";	
		}
		
	 
	 @RequestMapping(value="/forgotpassword", method = RequestMethod.GET)
	    public String emailPasswordVarify(ModelMap model){
	        return "forgotpassword";
	    }
	 
	 @RequestMapping(value="/forgotpassword",method = RequestMethod.POST)
		public String emailPasswordVarify(ModelMap model,@RequestParam String email,@RequestParam String password,@RequestParam String repassword) {
		 User user=new User(email, password, repassword);
		 return userService.emailPasswordVarify(user);	
		}
	 
	 
	 /*@RequestMapping("/login/forgotpassword")
		public String forgetPassword() {
			return "forgotPassword";
		}
	 
	 @RequestMapping(value="/login/forgotpassword",method = RequestMethod.POST)
		public String forgetPassword(ModelMap model,@RequestParam() String password,@RequestParam() String repassword) {
			
		 
		 //User user=new User(password,repassword);
		 //return userService.emailVarify(user);
		 return repassword;
		}*/
	 
	 
	 
	


}
