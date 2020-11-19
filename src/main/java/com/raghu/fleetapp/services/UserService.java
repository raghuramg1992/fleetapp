package com.raghu.fleetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.User;
import com.raghu.fleetapp.repositories.UserRepository;

@Service
public class UserService 
{

	@Autowired private BCryptPasswordEncoder encoder;
	
	@Autowired UserRepository userRepository;
	
	public void save(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		userRepository.save(user);
		
	}

}
