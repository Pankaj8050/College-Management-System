package com.example.collegemanagementsystem.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.collegemanagementsystem.entity.User;
import com.example.collegemanagementsystem.service.UserServices;


public class UserController {

@Autowired
UserServices userServices;
	
	@PostMapping("/createUser")
	public User createUser(User user) {
		return userServices.createUser(user);
	}
}
