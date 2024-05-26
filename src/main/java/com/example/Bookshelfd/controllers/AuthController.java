package com.example.Bookshelfd.controllers;

import com.example.Bookshelfd.config.auth.TokenProvider;
import com.example.Bookshelfd.dtos.JwtDto;
import com.example.Bookshelfd.dtos.SignInDto;
import com.example.Bookshelfd.dtos.SignUpDto;
import com.example.Bookshelfd.services.AuthService;
import com.example.Bookshelfd.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService service;
    @Autowired
    private TokenProvider tokenService;

    // Takes user data and creates new user in DB
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDto data) {
        service.signup(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Checks username and password are correct and returns accessToken
    @PostMapping("/signin")
    public ResponseEntity<JwtDto> signIn(@RequestBody @Valid SignInDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authUser = authenticationManager.authenticate(usernamePassword);
        var accessToken = tokenService.generateAccessToken((User) authUser.getPrincipal());
        return ResponseEntity.ok(new JwtDto(accessToken));
    }


}
