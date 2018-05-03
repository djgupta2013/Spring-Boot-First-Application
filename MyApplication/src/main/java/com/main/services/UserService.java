package com.main.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.controller.ApplicationController;
import com.main.model.User;
import com.main.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	ApplicationController applicationController;
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	 
	//Register
	public String saveMyUser(User user) {
		//Optional<User> user1=userRepository.findById(user.getEmail());
//		 Long email=(long) user.getEmail().hashCode();
		List<User> user1=userRepository.findByEmail(user.getEmail());
		System.out.println(user.getEmail());
	
		if(!user1.isEmpty() && user1.get(0).getEmail().equals(user.getEmail())) {
			return "User already exist";
		}
		else {
		userRepository.save(user);
		}
		return "";
	}
	
	//login
	public String login(User user) {
		User user2= userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		List<User> user1=userRepository.findByEmail(user.getEmail());
		String pageName = "";
		 try {
			 if (user2!=null ) {
					if( user2.getEmail().equalsIgnoreCase(user.getEmail())&&user2.getPassword().equals(user.getPassword())) {
						pageName = applicationController.welcome();
					}	
				}
			 else if(user1.get(0).getEmail().equals(user.getEmail())){
			pageName = applicationController.incorrect();				
		}
		 } catch (Exception e) {
			 pageName = applicationController.registerFirst();
		}
		return pageName;
	}
	
	//Forget password logic
	public String emailPasswordVarify(User user) {
		List<User> user2=  userRepository.findByEmail(user.getEmail());
		
		String page="";
		try {
			if(user2.get(0).getEmail().equalsIgnoreCase(user.getEmail())) {
				if(user.getPassword().equals(user.getRepassword())) {
				int flag=userRepository.setPasswordByEmail(user.getPassword(), user.getEmail());
				if(flag == 1)
				System.out.println(flag);
				page=applicationController.userLogin();
				}
			}
		} catch (Exception e) {
			page=applicationController.registerFirst();
		}
		return page;
		
	}

	

}
