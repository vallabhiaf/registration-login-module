package com.javamodules.registrationloginmodule.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.javamodules.registrationloginmodule.model.User;
import com.javamodules.registrationloginmodule.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	
	User save(UserRegistrationDto registrationDto);

}
