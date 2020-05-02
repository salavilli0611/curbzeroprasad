package com.curbzero.rest.auth.jwt.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.curbzero.rest.auth.jwt.JwtUserDetails;
import com.curbzero.rest.entity.model.Customer;
import com.curbzero.rest.entity.model.repository.CustomerRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	CustomerRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer user = userRepository.findByName(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		} else {
			return create(user);
		}
	}

	public static JwtUserDetails create(Customer user) {
		return new JwtUserDetails(user.getId(), user.getName(), user.getPassword(), user.getRole());
	}
}
