package com.hm.books.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.books.authservice.dto.JwtToken;
import com.hm.books.authservice.dto.UserCredentials;
import com.hm.books.authservice.exception.InvalidCredentialsException;
import com.hm.books.authservice.model.User;
import com.hm.books.authservice.repository.UserRepository;
import com.hm.books.authservice.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class UserAuthService {
	
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public JwtToken validateCredentials(UserCredentials credentials ) {
		
		User user = repo.findUserByUsername(credentials.getUsername());
		
		if(!user.getPassword().equals(credentials.getPassword())){
			throw new InvalidCredentialsException("Incorrect Password");
		}
		
		String username = user.getUsername();
		String jwt = jwtUtil.generateJwt(user.getUsername());
		
		JwtToken jwtToken = new JwtToken(jwt,username);
		log.info("successfully generated jwt token for the user:"+jwtToken.getUsername());
		return jwtToken;
		
	

	}
}
