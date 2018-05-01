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
	
	public String login(User user) {
		User user2= userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		String pageName = "";
		
		if(user2!=null) {
			if( user2.getEmail().equals(user.getEmail())&&user2.getPassword().equals(user.getPassword())) {
				pageName = applicationController.welcome();
			}
			else if(user2.getEmail().equals(user.getEmail())){
				pageName = applicationController.incorrect();				
			}
			else {
				pageName = applicationController.registerFirst();
			}
		}else {
			pageName = applicationController.registerFirst();
		}
		return pageName;
	}

	

}
