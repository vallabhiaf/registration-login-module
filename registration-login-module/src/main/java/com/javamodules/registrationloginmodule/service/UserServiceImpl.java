package com.javamodules.registrationloginmodule.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    //Userdetails and user are provided with Spring Security  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= userRepository.findByEmail(username);
		
		if (user==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), mapRolesToAuthorities(user.getRoles()));
		
	}
	//Spring Expects authroities (converting roles into authoroties
	private Collection<? extends GrantedAuthority > mapRolesToAuthorities (Collection<Role>roles ){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
