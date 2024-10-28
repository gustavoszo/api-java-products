package br.com.api.infra.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.infra.security.JwtToken;
import br.com.api.infra.security.JwtUserDetailsService;
import br.com.api.infra.web.dto.AuthDto;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @PostMapping
    public ResponseEntity<JwtToken> auth(@RequestBody AuthDto authDto) {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        JwtToken token = jwtUserDetailsService.getToken(authDto.getUsername());
        return ResponseEntity.ok(token);
    }

}
