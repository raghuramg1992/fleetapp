package com.raghu.fleetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.User;
import com.raghu.fleetapp.models.UserPrincipal;
import com.raghu.fleetapp.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired UserRepository userRepository;
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException("Username Not found!");
		}
		return new UserPrincipal(user);
	}

}
