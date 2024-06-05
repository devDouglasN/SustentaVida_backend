package com.douglas.nutrisimples.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.nutrisimples.infra.DataTokenJWT;
import com.douglas.nutrisimples.infra.security.DataAuthentication;
import com.douglas.nutrisimples.infra.security.TokenService;
import com.douglas.nutrisimples.userss.UserSS;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<DataTokenJWT> efetuarLogin (@RequestBody @Valid DataAuthentication data) {
		
		var authenticationToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		
		var authentication = manager.authenticate(authenticationToken);
		var tokenJWT = tokenService.generateToken((UserSS) authentication.getPrincipal());
		
		return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
	}
	
}
