package com.douglas.nutrisimples.api.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.nutrisimples.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
