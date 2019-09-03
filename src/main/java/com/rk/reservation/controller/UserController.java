package com.rk.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rk.reservation.entities.User;
import com.rk.reservation.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user)
	{
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@RequestMapping(value="/logincheck",method=RequestMethod.POST)
	public String logincheck(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap modelMap)
	{
		User user=userRepository.findByEmail(email);
		if(user.getPassword().equals(password))
			return "login/findFlights";
		
		modelMap.addAttribute("msg", "Invalid Username or Password !!!!!");
		return "login/login";
	}
}
