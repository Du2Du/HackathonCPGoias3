package com.ifdevs.ace.model.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifdevs.ace.exceptions.ResourceNotFoundException;
import com.ifdevs.ace.exceptions.ServerErrorException;
import com.ifdevs.ace.model.dtos.AvaliateResponseDTO;
import com.ifdevs.ace.model.dtos.AvaliateStudentDTO;
import com.ifdevs.ace.model.dtos.UserDTO;
import com.ifdevs.ace.model.entities.BehavioralProfile;
import com.ifdevs.ace.model.repositories.BehavioralProfileRepository;
import com.ifdevs.ace.utils.enums.RoleEnum;

import jakarta.transaction.Transactional;

@Service
public class BehavioralProfileService {

  @Autowired
  BehavioralProfileRepository behavioralProfileRepository;

  @Autowired
  UserService userService;

  @Transactional
  public ResponseEntity<String> avaliateEstudent(AvaliateStudentDTO avaliateStudentDTO) {
    BehavioralProfile behavioralProfile = this.getBehavioralProfileByEstudentUUID(avaliateStudentDTO.getStudentUUID());
    List<AvaliateResponseDTO> avaliateResponseDTOs = avaliateStudentDTO.getAvaliateResponses();
    try {
      avaliateResponseDTOs.forEach(avaliation -> this.calculateAvaliation(behavioralProfile, avaliation));
      return ResponseEntity.ok("Estudante avaliado com sucesso");
    } catch (Exception e) {
      throw new ServerErrorException("Erro ao avaliar estudante");
    }
  }

  private BehavioralProfile getBehavioralProfileByEstudentUUID(UUID uuid) {
    this.verifyIfEstudentExists(uuid);
    return behavioralProfileRepository.getByEstudentUUID(uuid);
  }

  private UserDTO verifyIfEstudentExists(UUID uuid) {
    UserDTO user = userService.getByUUID(uuid).getBody();
    if (user == null || user.getRoleName() != RoleEnum.STUDENT.valueName)
      throw new ResourceNotFoundException("Estudante não encontrado");
    return user;
  }

  private void calculateAvaliation(BehavioralProfile behavioralProfile, AvaliateResponseDTO avaliation) {
    float avaliationScore = avaliation.getScore();
    float newScore = (behavioralProfile.getBehavioralRating() * behavioralProfile.getQuantityAvaliations()
        + avaliationScore) / (behavioralProfile.getQuantityAvaliations() + 1);
    behavioralProfile.setBehavioralRating(newScore);
    behavioralProfileRepository.save(behavioralProfile);
  }

}
