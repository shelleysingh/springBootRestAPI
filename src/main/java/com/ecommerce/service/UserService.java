package com.ecommerce.service;

import java.util.List;

import com.ecommerce.repository.UserRepository;
import com.ecommerce.to.User;


public class UserService {
	public User validateUser(String username, String password) throws Exception {

		UserRepository userRepository = new UserRepository();

		User user = userRepository.validateUserCredentials(username, password);
		
		return user;
	}
	
	public List<User> getAllUsers() throws Exception {
		
		UserRepository userDao = new UserRepository();
		
		List<User> users = userDao.getUsers();
		
		return users;
	}
	
	public void deleteUser(String username) throws Exception {
		
		UserRepository userRepository = new UserRepository();
		
		userRepository.delete(username);
	}
	
	public User getUser(String username) throws Exception {
		
		UserRepository userRepository = new UserRepository();
		
		User user = userRepository.getUser(username);
		
		return user;
	}
	
}
