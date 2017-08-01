package com.report.user.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * This is User domain object to keep the user information in the mongodb.
 * @author root
 *
 */
public class User implements Serializable{

	@Id
	String id;
	String userName;
	String role;
	String password;
	
	public User(String userName,String role,String password) {
		this.userName = userName;
		this.role = role;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return String.format("User [id=%s, userName='%s' ", id,userName);
	}
}
