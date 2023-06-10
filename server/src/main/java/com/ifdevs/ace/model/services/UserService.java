package com.ifdevs.ace.model.services;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ifdevs.ace.exceptions.EntityExistsException;
import com.ifdevs.ace.exceptions.ServerErrorException;
import com.ifdevs.ace.model.dtos.BehavioralProfileDTO;
import com.ifdevs.ace.model.dtos.RegisterProfessionalUserDTO;
import com.ifdevs.ace.model.dtos.UserDTO;
import com.ifdevs.ace.model.entities.BehavioralProfile;
import com.ifdevs.ace.model.entities.User;
import com.ifdevs.ace.model.repositories.UserRepository;
import com.ifdevs.ace.utils.enums.RoleEnum;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleService roleService;

  public ResponseEntity<String> registerProfessionalUser(RegisterProfessionalUserDTO registerProfessionalUserDTO) {
    this.verifyIfUserAlreadyExists(registerProfessionalUserDTO.getCpf(), registerProfessionalUserDTO.getEmail());
    this.generateNewUserEntity(registerProfessionalUserDTO);
    return new ResponseEntity<String>("Usuário cadastrado com sucesso!", HttpStatus.CREATED);
  }

  private Response verifyIfUserAlreadyExists(String cpf, String email) {
    boolean userExistsWithEmail = userRepository.findByEmail(email).isPresent();
    boolean userExistsWithCpf = userRepository.findByCpf(cpf).isPresent();
    if (userExistsWithCpf || userExistsWithEmail)
      throw new EntityExistsException("Usuário ja cadastrado");
    return null;
  }

  private Response generateNewUserEntity(RegisterProfessionalUserDTO registerProfessionalUserDTO) {
    User userToSave = new User();
    BeanUtils.copyProperties(registerProfessionalUserDTO, userToSave);
    userToSave.setRole(roleService.getRoleByName(RoleEnum.TEACHER.valueName));
    userToSave.setPassword(new BCryptPasswordEncoder().encode(userToSave.getPassword()));
    try {
      userRepository.save(userToSave);
      return null;
    } catch (Exception e) {
      throw new ServerErrorException("Ocorreu um erro, tente novamente mais tarde!");
    }
  }

  public ResponseEntity<UserDTO> getByUUID(UUID uuid) {
    User user = userRepository.getByUUID(uuid);
    UserDTO userDTO = new UserDTO();
    BeanUtils.copyProperties(user, userDTO);
    userDTO.setRoleName(user.getRole().getRoleName());
    return ResponseEntity.ok(userDTO);
  }

  public ResponseEntity<UserDTO> raffleStudent() {
    User user = this.getUserByIndex();
    UserDTO userDTO = new UserDTO();
    BeanUtils.copyProperties(user, userDTO);
    userDTO.setRoleName(user.getRole().getRoleName());
    return ResponseEntity.ok(userDTO);
  }

  private User getUserByIndex() {
    double indexSorted = this.generateStudentIndex();
    List<User> users = userRepository.findAll();
    return users.get((int) indexSorted - 1);
  }

  private double generateStudentIndex() {
    Long studentCount = userRepository.count();
    return Math.floor(Math.random() * studentCount) + 1;
  }

  public ResponseEntity<List<UserDTO>> getAllStudents() {
    List<User> users = this.userRepository.findAllStudents();
    List<UserDTO> usersDTO = new ArrayList<>();
    users
        .forEach(user -> this.transformBehavioralToDTO(user, usersDTO));
    return ResponseEntity.ok(usersDTO);
  }

  private void transformBehavioralToDTO(User user,
      List<UserDTO> usersDTO) {
    UserDTO userDTO = new UserDTO();
    BeanUtils.copyProperties(user, userDTO);
    userDTO.setRoleName(user.getRole().getRoleName());
    usersDTO.add(userDTO);
  }

}
