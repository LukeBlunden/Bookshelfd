package com.example.Bookshelfd.dtos;

import com.example.Bookshelfd.enums.UserRole;

public record SignUpDto(String username, String password, String email, UserRole role) {
}
