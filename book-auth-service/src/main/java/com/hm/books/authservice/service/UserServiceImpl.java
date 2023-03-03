package com.hm.books.authservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.books.authservice.exception.DuplicateUserNameException;
import com.hm.books.authservice.model.User;
import com.hm.books.authservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public User saveUser(User user) {
		List<User> findAll = repo.findAll();
		
		for(User user1: findAll) {
			if (user1.getUsername().equals(user.getUsername())) {
				throw new DuplicateUserNameException("Already user is exist");
		}
		}
		return repo.save(user);

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.findUserByUsername(username);
	}

}
