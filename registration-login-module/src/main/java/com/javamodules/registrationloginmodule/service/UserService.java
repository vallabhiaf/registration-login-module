package com.javamodules.registrationloginmodule.service;

import com.javamodules.registrationloginmodule.model.User;
import com.javamodules.registrationloginmodule.web.dto.UserRegistrationDto;

public interface UserService {
	
	User save(UserRegistrationDto registrationDto);

}
