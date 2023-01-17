package com.Remonone.StudySB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class StudySbApplication{
	public static void main(String[] args) {
		SpringApplication.run(StudySbApplication.class, args);
	}
}
