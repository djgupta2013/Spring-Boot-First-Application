package com.main.model;

public class UserPassword {
	private String password;
	private String repassword;
	private String email;
	
	public UserPassword(String email) {
		this.email=email;
		
	}
public UserPassword(String password, String repassword) {
		
		this.password = password;
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

}
