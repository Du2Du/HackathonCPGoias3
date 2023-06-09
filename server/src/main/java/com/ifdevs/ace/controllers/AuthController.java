package com.ifdevs.ace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifdevs.ace.model.services.AuthService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/auth")
public class AuthController {

  @Autowired
  AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<String> login() {
    return authService.login();
  }

  @PostMapping("/refresh-token")
  public ResponseEntity<String> refreshToken() {
    return authService.refreshToken();
  }
}
