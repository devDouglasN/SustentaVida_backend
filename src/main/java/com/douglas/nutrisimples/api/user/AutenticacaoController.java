package com.douglas.nutrisimples.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.nutrisimples.security.DadosAutenticacao;
import com.douglas.nutrisimples.security.DadosTokenJWT;
import com.douglas.nutrisimples.security.TokenService;
import com.douglas.nutrisimples.security.UserSS;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<DadosTokenJWT> efetuarLogin (@RequestBody @Valid DadosAutenticacao dados) {
		
		var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		
		var authentication = manager.authenticate(authenticationToken);
		var tokenJWT = tokenService.generateToken((UserSS) authentication.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}
	
}
