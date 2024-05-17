package com.example.Bookshelfd.controllers;

import com.example.Bookshelfd.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthService authService;

    @GetMapping("/{username}")
    public ResponseEntity<UserDetails> getUser(@PathVariable("username") String username) {
        UserDetails user = authService.loadUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/auth")
    public ResponseEntity<String> getAuth() {
        return new ResponseEntity<>("Authed", HttpStatus.OK);
    }
}
