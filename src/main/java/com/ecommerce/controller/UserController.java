package com.ecommerce.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;
import com.ecommerce.to.User;

@Controller
public class UserController {
	
	//This method is the register method which is called when the user clicks on the register button on the index page
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(String username, String password, String firstName, String lastName, String email)
			throws Exception {
		System.out.println("inside register method.." + username + ", " + password + ", " + firstName + ", " + lastName
				+ ", " + email);

		UserRepository userRepository = new UserRepository();

		User user = new User(username, password, firstName, lastName, email);

		userRepository.save(user);

		// userRepository.save(username, password, firstName, lastName, email);

		return "index";
	}
	
	//This method is the login method which is called when the user clicks on the login button on the index page
	@RequestMapping("/login")
	public ModelAndView login(String username, String password) throws Exception {

		System.out.println("The username is " + username + ", the password is " + password);
		// This would return the index or login page back to user if either username or password or both are incorrect
		if (username.equals("") || password.equals("")) {
															
			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("loginErrorMessage", "Please do Not submit empty fields!!");

			return modelAndView;
		}

		UserService userService = new UserService();

		User user = userService.validateUser(username, password);

		if (user != null) {

			ModelAndView modelAndView = new ModelAndView("welcomePage");
			modelAndView.addObject("userData", user);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("loginErrorMessage", "Incorrect Credentials, please try again!!");

			return modelAndView;
		}

	}
	
	//This method is the deleteUser method which is called when the user clicks on the delete button on the masterUserPage
	@RequestMapping("delete/{uid}")
	public ModelAndView deleteUser(@PathVariable String uid) throws Exception {

		System.out.println("the userid is " + uid);

		UserService userService = new UserService();

		userService.deleteUser(uid);

		List<User> users = userService.getAllUsers();

		ModelAndView modelAndView = new ModelAndView("masterUserPage");

		modelAndView.addObject("allUsers", users);

		return modelAndView;
	}
	
	//This method is the updateUser method which is called when the user clicks on the update button on the masterUserPage
	@RequestMapping("/update/{username}")
	public ModelAndView updateUser(@PathVariable String username) throws Exception {

		System.out.println("inside updateUser " + username);

		ModelAndView modelAndView = new ModelAndView("updateUserPage");

		UserService userService = new UserService();

		User user = userService.getUser(username);

		modelAndView.addObject("userData", user);

		return modelAndView;

	}

}