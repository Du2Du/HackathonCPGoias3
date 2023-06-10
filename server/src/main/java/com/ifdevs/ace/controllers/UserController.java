package com.ifdevs.ace.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifdevs.ace.model.dtos.BehavioralProfileDTO;
import com.ifdevs.ace.model.dtos.RegisterProfessionalUserDTO;
import com.ifdevs.ace.model.dtos.UserDTO;
import com.ifdevs.ace.model.services.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("")
  public ResponseEntity<String> registerProfessionalUser(
      @RequestBody RegisterProfessionalUserDTO registerProfessionalUserDTO) {
    return userService.registerProfessionalUser(registerProfessionalUserDTO);
  }

  @GetMapping("/raffle-student")
  public ResponseEntity<UserDTO> raffleStudent() {
    return userService.raffleStudent();
  }

  @GetMapping("")
  public ResponseEntity<List<UserDTO>> getAllStudents() {
    return userService.getAllStudents();
  }

}
