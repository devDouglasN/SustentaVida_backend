package com.douglas.nutrisimples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.douglas.nutrisimples.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	UserDetails findByLogin(String login);

	UserDetails findByEmail(String email);
	
}
