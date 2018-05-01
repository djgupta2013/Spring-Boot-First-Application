package com.main.services;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.User;
import com.main.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	DataSource dataSource;
	
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
		
		try {
			dataSource.u
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	


	


	


	public boolean saveMyUser(String username, String firstname, String lastname, int age, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
