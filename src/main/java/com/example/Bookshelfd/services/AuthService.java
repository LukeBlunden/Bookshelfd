package com.example.Bookshelfd.services;

import com.example.Bookshelfd.dtos.SignUpDto;
import com.example.Bookshelfd.exceptions.InvalidJwtException;
import com.example.Bookshelfd.entities.User;
import com.example.Bookshelfd.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    public UserDetails signup(SignUpDto data) throws InvalidJwtException {
        if ((repository.findByUsername(data.username()) != null)) {
            throw new InvalidJwtException("Username already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), encryptedPassword, data.email(), data.role());
        return repository.save(newUser);
    }
}
