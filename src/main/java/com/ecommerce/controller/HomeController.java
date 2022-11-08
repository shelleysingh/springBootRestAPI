package com.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	
	//
	@RequestMapping("/")
	public String index() {
		//System.out.println("inside index()");
		return "index";
	}
	
	//
	@RequestMapping("/registrationPage")
	public String registration() {

		return "registrationPage";
	}
	
	//
	@RequestMapping("/home")
	public String homepage() {
		
		return "welcomePage";
		
	}
	
	@RequestMapping("/productsPage")
	public String productspage() {
		
		return "productsPage";
	}
	
}


//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.stereotype.Controller;
//
//import com.ecommerce.repository.UserRepository; 
//import com.ecommerce.to.User;
//
//@Controller
//public class HomeController {
//	
//	@RequestMapping("/")
//	public String index() {
//		System.out.println("inside index()");
//		return "index";
//	}
//	
//	@RequestMapping("/registrationPage")
//	public String registration() {
//		
//		return "registrationPage";
//	}

//@Controller
//public class HomeController { //
//
//	@RequestMapping("/")
//	public ModelAndView index() {
//
//		ModelAndView mv = new ModelAndView("index");
//		return mv;
//	}
//
//	
//	@RequestMapping("/login")
//	public ModelAndView login(String username, String pwd) throws Exception {
//		
//		System.out.println("inside login( )"+username+", "+pwd);
//		
//		User user = UserRepository.findByUsernameAndPassword(username, pwd);
//		
//		if(user != null) {
//			System.out.println("inside if...");
//			ModelAndView modelAndView = new ModelAndView("welcomePage");
//			modelAndView.addObject("userData", user);
//			return modelAndView;
//		}
//		else {
//			System.out.println("inside else...");
//			ModelAndView modelAndView = new ModelAndView("index");
//			return modelAndView;
//		}
//	//
//
//	@RequestMapping("/login")
//	public ModelAndView login() {
//
//		ModelAndView mv = new ModelAndView("welcomePage");
//		return mv;
//	}
//
//	//
//
//	@RequestMapping("/home")
//	public String homepage() {
//		return "welcomePage";
//	}
//	//
//
//	@RequestMapping("/productsPage")
//	public String productspage() {
//		return "productsPage";
//	}
