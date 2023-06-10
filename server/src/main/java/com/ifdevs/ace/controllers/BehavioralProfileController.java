package com.ifdevs.ace.controllers;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifdevs.ace.model.dtos.AvaliateStudentDTO;
import com.ifdevs.ace.model.dtos.BehavioralProfileDTO;
import com.ifdevs.ace.model.dtos.StudentDTO;
import com.ifdevs.ace.model.dtos.UserDTO;
import com.ifdevs.ace.model.entities.BehavioralProfile;
import com.ifdevs.ace.model.services.BehavioralProfileService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/behavioral-profile")
public class BehavioralProfileController {

  @Autowired
  BehavioralProfileService behavioralProfileService;

  @PostMapping("/avaliate")
  public ResponseEntity<String> avaliateEstudent(@RequestBody AvaliateStudentDTO avaliateStudentDTO) {
    return behavioralProfileService.avaliateEstudent(avaliateStudentDTO);
  }

  @GetMapping("/{studentUUID}")
  public ResponseEntity<BehavioralProfileDTO> getBehavioralProfile(@RequestParam("studentUUID") UUID studentUUID) {
    return behavioralProfileService.getBehavioralProfile(studentUUID);
  }

  @GetMapping("")
  public ResponseEntity<List<StudentDTO>> getAllStudents() {
    return behavioralProfileService.getAllStudents();
  }

}
