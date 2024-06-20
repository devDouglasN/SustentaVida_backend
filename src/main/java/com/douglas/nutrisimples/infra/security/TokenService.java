package com.douglas.nutrisimples.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	public String generateToken(UserSS user) {
		try {
		    var algoritimo = Algorithm.HMAC256(secret);
		    String token = JWT.create()
		        .withIssuer("NutriSimples")
		        .withSubject(user.getUsername())
		        .withExpiresAt(expirationDate())
		        .sign(algoritimo);

			return token;

		} catch (JWTCreationException exception){
			throw new RuntimeException("erro ao gerar token jwt", exception);
		}
	}
	
	public String getSubject (String tokenJWT) {
		try {
			var algoritimo = Algorithm.HMAC256(secret);
			return JWT.require(algoritimo)
					.withIssuer("NutriSimples")
					.build()
					.verify(tokenJWT)
					.getSubject();
		} catch (JWTVerificationException exception) {
			throw new RuntimeException("TokenJWT inválido ou expirado");
		}
		
	}
	
	private Instant expirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}

