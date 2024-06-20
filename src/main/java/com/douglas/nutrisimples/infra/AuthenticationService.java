package com.douglas.nutrisimples.infra;

import com.douglas.nutrisimples.domain.User;
import com.douglas.nutrisimples.api.user.UserRepository;
import com.douglas.nutrisimples.infra.security.UserSS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("Procurando usuário com email: " + email);
		Optional<User> user = userRepository.findByEmail(email);
		if (user.isPresent()) {

			List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
			return new UserSS(user.get().getId(), user.get().getEmail(), user.get().getPassword(), authorities);
		}
		throw new UsernameNotFoundException("Usuário não encontrado com e-mail: " + email);
	}

}
