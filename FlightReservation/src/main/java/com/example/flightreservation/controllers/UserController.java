package com.example.flightreservation.controllers;

import org.apache.tomcat.jni.Mmap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.flightreservation.entities.User;
import com.example.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@RequestMapping("/login")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String regiter(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "login/login";
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String Login(@RequestParam("email")String email, @RequestParam("password")String password,ModelMap modelMap){
		User user = userRepository.findByEmail(email);
		if(user.getPassword().equals(password)) {
			return "findFlights";
		}
		else {
			modelMap.addAttribute("msg", "Invalid Username and Password. Please try again.");
		}
		return "login/login";
		
	}
}
