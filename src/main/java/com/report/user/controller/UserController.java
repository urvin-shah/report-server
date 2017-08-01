package com.report.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.report.user.domain.User;
import com.report.user.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    
    /**
     * This is User Login REST API.
     * @param userName
     * @param pass
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam(value="userName") String userName,@RequestParam(value="pass") String pass) {
    	return userService.login(userName,pass);
    }
    
    /**
     * This REST service can be accessed to get all the users
     * @param name
     * @return
     */
    @RequestMapping("/users")
    public List<User> getUsers(@RequestParam(value="name", defaultValue="admin") String name) {
    	return userService.getAllUsers();
    }
    
    /**
     * This REST api can be used to add User
     * @param userName
     * @param role
     * @param pass
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(@RequestParam(value="userName") String userName,@RequestParam(value="role") String role,@RequestParam(value="pass") String pass) {
    	return userService.addUser(new User(userName,role,pass));
    }
    
    /**
     * This REST Api can be used to change the password
     * @param userName
     * @param newPass
     * @return
     */
    @RequestMapping("/changePassword")
    public String changePassword(@RequestParam(value="userName") String userName,@RequestParam(value="newPass") String newPass) {
    	return userService.changePassword(userName,newPass);
    }
    
}
