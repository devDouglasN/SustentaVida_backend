package com.douglas.nutrisimples.infra.security;

import java.io.IOException;
import java.util.Optional;

import com.douglas.nutrisimples.api.user.UserRepository;
import com.douglas.nutrisimples.domain.User;
import com.douglas.nutrisimples.exceptions.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.douglas.nutrisimples.infra.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		var tokenJWT = recuperarToken(request);

		if (tokenJWT != null) {
			try {
				var email = tokenService.getSubject(tokenJWT);
				UserDetails userDetails = authenticationService.loadUserByUsername(email);
				var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} catch (Exception e) {
				log.error("Authentication error: " + e.getMessage(), e);
				SecurityContextHolder.clearContext();
			}
		}

		filterChain.doFilter(request, response);
	}



	private String recuperarToken(HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		if (authorizationHeader != null) {
			return authorizationHeader.replace("Bearer ", "").trim();
		}
		return null;
	}
}
