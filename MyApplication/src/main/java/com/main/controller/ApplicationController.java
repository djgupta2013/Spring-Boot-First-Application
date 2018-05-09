package com.main.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.model.User;
import com.main.servicesImpl.UserServiceImpl;

@Controller
@SessionAttributes("user")
public class ApplicationController {
	@Autowired
	private UserServiceImpl userService;
	User user;
	
	
	
	@Autowired
	HttpSession session;
	

	@RequestMapping("/")
	public String homepage() {
		return "welcomepage";
	}
	
	
	
	 @RequestMapping(value="/register", method = RequestMethod.GET)
	    public String saveUser(ModelMap model){
	        return "register";
	    }
	 
	 @RequestMapping(value="/register", method = RequestMethod.POST)
	 public String saveUser(ModelMap model,@RequestParam String email,@RequestParam String firstname,@RequestParam String lastname,
			 @RequestParam int age,@RequestParam String password){
		 int otp=new Random().nextInt(99999);
		 User user=new User(email, firstname,lastname,age,password,otp);
		 session.setAttribute("email", email);
		 return userService.saveMyUser(user);  
		
	 }
	 
	 @RequestMapping(value="/otpVerify", method = RequestMethod.GET)
	    public String otpVerify1(){
	        return "otpVerify";
	    }	
	 
	    @RequestMapping(value="/otpVerify", method = RequestMethod.POST)
	    public String otpVerify1(@RequestParam int otp){
	    	System.out.println(session.getAttribute("email"));
	    	String email=(String) session.getAttribute("email");
	    	User user=new User(email);
	    	return userService.otpVerify(user, otp);
	        
	    }
	    
	    
	    @RequestMapping(value="/login", method = RequestMethod.GET)
	    public String userLogin(){
	        return "login";
	    }	
	 @RequestMapping(value="/login", method = RequestMethod.POST)
	 public String userLogin(ModelMap model,@RequestParam String email,@RequestParam String password) {
		 int otp=0;
		 User user=new User(email, password,otp);
		 return userService.login(user);
	 }
	 
	 
		
	 /*
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	 public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response){
		 ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new User());
		    return mav;
	    }	
	 @RequestMapping(value="/login", method = RequestMethod.POST)
	 public String userLogin(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("login") User user) {
		 ModelAndView mav = null;
//		 User user=new User(email, password);
System.out.println("user email : " +user.getEmail());
		 return userService.login(user);
	 }*/
	 
		
	 
	 @RequestMapping(value="/forgotpassword", method = RequestMethod.GET)
	    public String emailPasswordVarify(ModelMap model){
	        return "forgotpassword";
	    }
	 
	 @RequestMapping(value="/forgotpassword",method = RequestMethod.POST)
		public String emailPasswordVarify(ModelMap model,@RequestParam String email,@RequestParam String password,@RequestParam String repassword) {
		if(password==repassword) {
		 User user=new User(email, password);
		 return userService.emailPasswordVarify(user);	
		}else
		return "passwordcheck";
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
		 public User getUser() {
				return user;
			}
		public void setUser(User user) {
			this.user = user;
		}	 
	 
	 
	


}
