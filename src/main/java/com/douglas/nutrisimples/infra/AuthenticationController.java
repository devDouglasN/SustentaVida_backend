package com.douglas.nutrisimples.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.nutrisimples.infra.security.DataAuthentication;
import com.douglas.nutrisimples.infra.security.TokenService;
import com.douglas.nutrisimples.infra.security.UserSS;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAuthentication data) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var authentication = this.manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((UserSS) authentication.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }

}
