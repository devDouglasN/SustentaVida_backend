package com.douglas.nutrisimples.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.nutrisimples.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
