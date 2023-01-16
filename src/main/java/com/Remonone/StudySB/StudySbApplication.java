package com.Remonone.StudySB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;

import com.Remonone.StudySB.Models.User;
import com.Remonone.StudySB.Services.UserService;

@SpringBootApplication
@EnableMongoRepositories
public class StudySbApplication{
	@Autowired
	UserService users;
	
	public static void main(String[] args) {
		SpringApplication.run(StudySbApplication.class, args);
	}
	
	@GetMapping("/users")
	public List<User> getuser() {
		return users.findAll();
	}

	
	
}
