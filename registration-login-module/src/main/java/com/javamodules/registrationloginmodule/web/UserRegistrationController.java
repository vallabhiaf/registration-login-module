package com.javamodules.registrationloginmodule.web;

import org.hibernate.loader.custom.EntityFetchReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javamodules.registrationloginmodule.service.UserService;
import com.javamodules.registrationloginmodule.web.dto.UserRegistrationDto;

//Tell spring to handle HTTP requests 
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	public String showRegistrationForm() {
	       return "registration";
	       
	}
	//Returns a empty User Object
	//Themeleaf get user object from here 
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@PostMapping
	//Binds form data to the dto 
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		userService.save(userRegistrationDto);
		return "redirect:/registration?success";

}}
