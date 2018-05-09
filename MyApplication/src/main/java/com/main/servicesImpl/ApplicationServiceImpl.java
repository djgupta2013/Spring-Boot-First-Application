package com.main.servicesImpl;

import org.springframework.stereotype.Service;

import com.main.services.ApplicationService;

@Service
public class ApplicationServiceImpl  implements ApplicationService{
	
	public String homepage() {
		return "welcomepage";
	}
	
	public String welcome() {
		return "welcome";
	}
	
	public String welcomeLogin() {
		return "welcomeLogin";
	}
	
	public String successSignUpMsg() {
		return "successSignUpMsg";
	}
	
	 public String userExists() {
			return "userExists";
		}
	 
	 public String otpVerify() {
		 return "otpVerify";
	 }
	 public String otpWrong() {
		 return "otpWrong";
	 }

		public String incorrect() {
			
		return	"incorrect";	
		}
		public String registerFirstPopUp() {
			return "registerFirstPopUp";
		}

}
