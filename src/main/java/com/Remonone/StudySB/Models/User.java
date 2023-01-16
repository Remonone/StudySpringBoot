package com.Remonone.StudySB.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

	@Id
	private String id;
	
	private String name;
	private String email;
	
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
		LocalDateTime time = LocalDateTime.now();
		this.createdOn = time;
		this.updatedOn = time;
	}
	
	@Override
	public String toString() {
		return String.format("User[id='%s', name='%s']", id, name);
	}
}
