package com.report.user.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.user.dao.UserRepository;
import com.report.user.domain.User;

/**
 * UserService
 * @author root
 * This Service is for providing various User APIs
 */
@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	/**
	 * This service fetch all Users
	 * @return
	 */
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
	/**
	 * This Service can be used for adding the user.
	 * @param user
	 * @return
	 */
	public String addUser(User user) {
		if(user != null) {
			if(getUser(user.getUserName()) == null) {
				repository.save(user);
				return "User "+user.getUserName()+", added successfully";
			}else {
				return "User already Exist";
			}
		}
		return "Failed to Add User";
	}
	
	/**
	 * This method provider the User object based on the username
	 * @param username
	 * @return
	 */
	public User getUser(String username) {
		if(username != null && !"".equals(username)) {
			List<User> lstUser = repository.findByUserName(username);
			if(lstUser != null && !lstUser.isEmpty()) {
				return lstUser.get(0);
			}
		}
		return null;
	}
	
	/**
	 * This service allow to change the password
	 * @param username
	 * @param pass
	 * @return
	 */
	public String changePassword(String username,String pass) {
		if(username != null && !"".equals(username) && pass != null && !"".equals(pass)) {
			User user = getUser(username);
			if(user != null) {
				user.setPassword(pass); 
				repository.save(user);
				return "Password "+user.getUserName()+", changed successfully";
			}else {
				return "User does not exist";
			}
		}
		return "Enter Valid details";
	}
	
	/**
	 * This service validate the user's login
	 * @param username
	 * @param pass
	 * @return
	 */
	public String login(String username,String pass) {
		if(username != null && !"".equals(username) && pass != null && !"".equals(pass)) {
			User user = getUser(username);
			if(user != null) {
				if(pass.equals(user.getPassword())) {
					return "Success";
				} else {
					return "Enter Valid username/password";
				}
			}else {
				return "User does not exist";
			}
		}
		return "Invalid inputs";
	}
}
