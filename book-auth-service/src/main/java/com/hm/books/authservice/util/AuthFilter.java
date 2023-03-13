package com.hm.books.authservice.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hm.books.authservice.exception.InvalidCredentialsException;
import com.hm.books.authservice.model.User;
import com.hm.books.authservice.service.UserService;

@Component
public class AuthFilter implements Filter {
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserService service;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Filter Intercepted the Request"); //request object needs httpservletrequest
		HttpServletRequest httpRequest=(HttpServletRequest) request;  // typecasting servelt request to httpServelt request
		
		if(httpRequest.getRequestURI().startsWith("/auth/public")) {
			System.out.println("Filter Intercepted the Request 1"); 
			chain.doFilter(httpRequest, response);
			return;
		}
		
		String header = httpRequest.getHeader("auth");
		if(header==null || header.isEmpty()) {
			System.err.println("Token Not Present");
			throw new InvalidCredentialsException("Invalid Token/Credentials");
		}
		
		String username = util.decodeJwt(header);
		
		User user = service.getUserByUsername(username);
		if(user==null) {
			System.err.println("Token Not Present 1");
			throw new InvalidCredentialsException("Invalid Token/Credentials");
		}
		System.out.println("Filter Intercepted the Request 1");
		chain.doFilter(request, response);
		
	}
	
}
