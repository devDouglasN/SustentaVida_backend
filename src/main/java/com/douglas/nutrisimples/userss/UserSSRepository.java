package com.douglas.nutrisimples.userss;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserSSRepository extends JpaRepository<UserSS, Integer> {

	UserDetails findByEmail(String email);

}
