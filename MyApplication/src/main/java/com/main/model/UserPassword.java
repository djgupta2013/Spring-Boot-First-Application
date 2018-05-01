package com.main.model;

public class UserPassword {
	private String password;
	private String repassword;
	public String getPassword() {
		return password;
	}
	public UserPassword(String password, String repassword) {
		
		this.password = password;
		this.repassword = repassword;
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
