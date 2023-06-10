package com.ifdevs.ace.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifdevs.ace.exceptions.ResourceNotFoundException;
import com.ifdevs.ace.exceptions.ServerErrorException;
import com.ifdevs.ace.model.dtos.AvaliateResponseDTO;
import com.ifdevs.ace.model.dtos.AvaliateStudentDTO;
import com.ifdevs.ace.model.dtos.BehavioralProfileDTO;
import com.ifdevs.ace.model.dtos.UserDTO;
import com.ifdevs.ace.model.entities.BehavioralProfile;
import com.ifdevs.ace.model.repositories.BehavioralProfileRepository;
import com.ifdevs.ace.utils.enums.RoleEnum;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
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
      behavioralProfile.setQuantityAvaliations(behavioralProfile.getQuantityAvaliations() + 1);
      behavioralProfileRepository.save(behavioralProfile);
      return ResponseEntity.ok("Estudante avaliado com sucesso");
    } catch (Exception e) {
      throw new ServerErrorException("Erro ao avaliar estudante");
    }
  }

  private BehavioralProfile getBehavioralProfileByEstudentUUID(UUID uuid) {
    this.verifyIfEstudentExists(uuid);
    return behavioralProfileRepository.getByEstudentUUID(uuid).get();
  }

  private UserDTO verifyIfEstudentExists(UUID uuid) {
    UserDTO user = userService.getByUUID(uuid).getBody();
    if (user == null || !RoleEnum.STUDENT.valueName.equals(user.getRoleName()))
      throw new ResourceNotFoundException("Estudante não encontrado");
    return user;
  }

  private void calculateAvaliation(BehavioralProfile behavioralProfile, AvaliateResponseDTO avaliation) {
    float avaliationScore = avaliation.getScore();
    float newScore = (behavioralProfile.getBehavioralRating() * behavioralProfile.getQuantityAvaliations()
        + avaliationScore) / (behavioralProfile.getQuantityAvaliations() + 1);
    behavioralProfile.setBehavioralRating(newScore);
  }

  public ResponseEntity<BehavioralProfileDTO> getBehavioralProfile(UUID studentUuid) {
    BehavioralProfile behavioralProfile = this.getBehavioralProfileByEstudentUUID(studentUuid);
    BehavioralProfileDTO behavioralProfileDTO = new BehavioralProfileDTO();
    BeanUtils.copyProperties(behavioralProfile, behavioralProfileDTO);
    return ResponseEntity.ok(behavioralProfileDTO);
  }
}
