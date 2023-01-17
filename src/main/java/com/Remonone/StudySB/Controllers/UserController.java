package com.Remonone.StudySB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Remonone.StudySB.Models.User;
import com.Remonone.StudySB.Services.UserService;

@RestController
public class UserController {
	@Autowired
	UserService users;
	
	@GetMapping("/users")
	public List<User> getUser() {
		List<User> usersList = users.findAll();
		return usersList;
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		User createdUser = users.save(user);
		return createdUser;
	}
}
