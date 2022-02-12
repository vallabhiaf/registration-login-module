package com.javamodules.registrationloginmodule.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	//Handles Login requests
	@GetMapping("/login")
	public String login() {
		return "login";
	}
    
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

}
