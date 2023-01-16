package com.Remonone.StudySB.Services;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.Remonone.StudySB.Models.User;

@Repository
public interface UserService extends MongoRepository<User, String>{
	
	@Query("{name: '?0'}") User findItemByName(String name);
	@Query("{id: '?0'}") User findItemById(String id);
	
	@Query(value="{}", fields="{'name': 1, 'email': 1}") List<User> findAll();
}
