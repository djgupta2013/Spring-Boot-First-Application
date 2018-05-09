package com.main.servicesImpl;

import java.util.List;
import java.util.Random;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.User;
import com.main.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl {
	
	@Autowired
	ApplicationServiceImpl applicationServiceImpl;
	
	

	@Autowired
	private UserRepository userRepository;
	
	public boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}
	 
	//Register
	public String saveMyUser(User user) {
		List<User> user1=userRepository.findByEmail(user.getEmail());
		System.out.println(user.getEmail());
		String pageName = "";
	
 		if(!user1.isEmpty() && user1.get(0).getEmail().equals(user.getEmail())&&user1.get(0).getOtp()==0) {
			pageName=applicationServiceImpl.userExists();
		}
		else if(!user1.isEmpty() && user1.get(0).getEmail().equals(user.getEmail())&&user1.get(0).getOtp()!=0) {
			
		userRepository.deleteByEmail(user.getEmail());
			userRepository.save(user);
			SendMailServiceImpl.sendMail(user.getEmail(),"Spring Boot ","OTP "+user.getOtp());
	    	
			pageName = applicationServiceImpl.otpVerify();
		}
		
		
		
		else  {
			
//			user.setOtp(otp);
			//int flag=userRepository.setOtpByEmail(user.getOtp(), user.getEmail());
		userRepository.save(user);
		SendMailServiceImpl.sendMail(user.getEmail(),"Spring Boot ","OTP "+user.getOtp());
		pageName = applicationServiceImpl.otpVerify();
		
		}
		return pageName;
	}
	
	// Opt verify
	public String otpVerify(User user,int otp) {
		List<User> user1=userRepository.findByEmail(user.getEmail());
		String pageName = "";
		if(user1.get(0).getEmail().equalsIgnoreCase(user.getEmail())&&user1.get(0).getOtp()==otp) {
			int flag=userRepository.setOtpByEmail(0, user.getEmail());
			System.out.println(flag);
			pageName=applicationServiceImpl.welcomeLogin();
			
		}
		else {
			pageName=applicationServiceImpl.otpWrong();
		}
		return pageName;
		
		
	}
	
	//login
	public String login(User user) {
		
		User user2= userRepository.findByEmailAndPasswordAndOtp(user.getEmail(), user.getPassword(),user.getOtp());
		//System.out.println(user2.getOtp());
		List<User> user1=userRepository.findByEmail(user.getEmail());
		System.out.println(user1.get(0).getOtp());
		
		String pageName = "";
		try {
			 if (user2!=null  ) {
					if( user2.getEmail().equalsIgnoreCase(user.getEmail())&&user2.getPassword().equals(user.getPassword())) {
						pageName = applicationServiceImpl.welcome();
					}	
				}
			 else if(user1.get(0).getEmail().equalsIgnoreCase(user.getEmail())){
				if(user1.get(0).getOtp()==0)
				 pageName = applicationServiceImpl.incorrect();
				else {
					pageName = applicationServiceImpl.registerFirstPopUp();
				}
			 }
		 } catch (Exception e) {
			 pageName = applicationServiceImpl.registerFirstPopUp();
		}
		return pageName;
	}
	
	//Forget password logic
	public String emailPasswordVarify(User user) {
		List<User> user2=  userRepository.findByEmail(user.getEmail());
		
		String page="";
		try {
			if(user2.get(0).getEmail().equalsIgnoreCase(user.getEmail())) {
				
				int flag=userRepository.setPasswordByEmail(user.getPassword(), user.getEmail());
				if(flag == 1)
				System.out.println(flag);
				page=applicationServiceImpl.homepage();
				
			}
		} catch (Exception e) {
			page=applicationServiceImpl.registerFirstPopUp();
		}
		return page;
		
	}
}
