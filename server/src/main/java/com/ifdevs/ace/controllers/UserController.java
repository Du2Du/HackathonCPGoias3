package com.ifdevs.ace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifdevs.ace.model.dtos.RegisterProfessionalUserDTO;
import com.ifdevs.ace.model.services.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  UserService userService;

  public ResponseEntity<String> registerProfessionalUser(RegisterProfessionalUserDTO registerProfessionalUserDTO) {
    return userService.registerProfessionalUser(registerProfessionalUserDTO);
  }
}
