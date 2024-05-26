package com.example.Bookshelfd.controllers;
import com.example.Bookshelfd.dtos.UsernameDto;
import com.example.Bookshelfd.entities.User;
import com.example.Bookshelfd.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    // Gets user details based on username - not currently in use
    @GetMapping("/{username}")
    public ResponseEntity<UserDetails> getUser(@PathVariable("username") String username) {
        UserDetails user = authService.loadUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Returns true if the user is authenticated
    @GetMapping("/auth")
    public ResponseEntity<Boolean> getAuth() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    // Returns users username if authenticated
    @GetMapping("/signedIn")
    public ResponseEntity<UsernameDto> signedIn(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(new UsernameDto(user.getUsername()), HttpStatus.OK);
    }
}
