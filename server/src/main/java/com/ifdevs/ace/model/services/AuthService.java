package com.ifdevs.ace.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifdevs.ace.model.repositories.UserRepository;

@Service
public class AuthService {

  @Autowired
  UserRepository userRepository;
}
