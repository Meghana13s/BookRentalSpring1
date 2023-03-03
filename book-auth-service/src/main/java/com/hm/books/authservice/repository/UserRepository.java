package com.hm.books.authservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.hm.books.authservice.model.User;

public interface UserRepository extends MongoRepository<User,Integer> {
	
	public User findUserByUsername(String username);
		
	}


