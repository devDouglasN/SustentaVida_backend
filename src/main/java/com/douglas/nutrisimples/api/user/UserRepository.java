package com.douglas.nutrisimples.api.user;

import com.douglas.nutrisimples.domain.User;
import com.douglas.nutrisimples.infra.security.UserSS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
