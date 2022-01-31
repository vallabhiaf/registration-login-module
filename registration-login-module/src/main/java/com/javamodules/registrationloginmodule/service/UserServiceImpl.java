package com.javamodules.registrationloginmodule.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamodules.registrationloginmodule.model.Role;
import com.javamodules.registrationloginmodule.model.User;
import com.javamodules.registrationloginmodule.repository.UserRepository;
import com.javamodules.registrationloginmodule.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
    @Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user=new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(),registrationDto.getPassword(),Arrays.asList(new Role("Role User")));
		
		return userRepository.save(user);
	}

}
