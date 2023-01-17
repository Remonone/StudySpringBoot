package com.Remonone.StudySB.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document("user")
public class User {

	@Id
	private String id;
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("createdOn")
	private LocalDateTime createdOn;
	@JsonProperty("updatedOn")
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
