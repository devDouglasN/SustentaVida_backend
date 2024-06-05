package com.douglas.nutrisimples.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.douglas.nutrisimples.userss.UserSSRepository;

public class AuthenticationService implements UserDetailsService {
	
	@Autowired
    private UserSSRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return repository.findByEmail(email);
	}

}
