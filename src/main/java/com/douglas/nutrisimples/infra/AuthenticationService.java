package com.douglas.nutrisimples.infra;

import com.douglas.nutrisimples.domain.User;
import com.douglas.nutrisimples.api.user.UserRepository;
import com.douglas.nutrisimples.userss.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

		return user.map(value -> new UserSS(value.getId(), value.getEmail(), value.getPassword(), authorities))
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail: " + email));
	}

}
