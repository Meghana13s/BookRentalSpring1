package com.hm.books.authservice.service;

import java.util.List;

import com.hm.books.authservice.exception.DuplicateUserNameException;
import com.hm.books.authservice.model.User;

public interface UserService {
	
	public User getUserByUsername(String username);
	
	public User saveUser(User user) throws DuplicateUserNameException;
	
	public List<User> getAllUsers();


}
