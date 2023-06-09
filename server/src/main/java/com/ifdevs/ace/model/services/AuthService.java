package com.ifdevs.ace.model.services;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifdevs.ace.model.repositories.UserRepository;

@Service
public class AuthService {

  @Autowired
  UserRepository userRepository;

  public ResponseEntity<String> login() {
    return null;
  }

  public ResponseEntity<String> refreshToken() {
    return null;
  }
}
