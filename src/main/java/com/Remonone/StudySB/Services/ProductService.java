package com.Remonone.StudySB.Services;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.Remonone.StudySB.Models.Product;
import com.Remonone.StudySB.Models.User;

@Repository
public interface ProductService extends MongoRepository<Product, String>{
	@Query("{name: '?0'}") User findItemByName(String name);
	@Query("{id: '?0'}") User findItemById(String id);
	
	@Query(value="{}", fields="{'name': 1, 'description': 1, 'price': 1, 'rating': 1, 'images': 1}") List<Product> findAll();
}
