package com.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="mytable")
public class User {
	
	@Id
	private int id;
	private String email;
	private String firstname;
	private String lastname;
	private int age;
	private String password;
	
	@Transient
	private String repassword;
	
	
	public User() {
		
	}
	public User(String email) {
		this.email = email;	
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(String email, String password, String repassword) {
		super();
		this.email = email;
		this.password = password;
		this.repassword = repassword;
	}
	
	public User(String email, String firstname, String lastname, int age, String password) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", age=" + age + ", password=" + password + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}	

}
