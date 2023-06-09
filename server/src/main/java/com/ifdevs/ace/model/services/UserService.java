package com.ifdevs.ace.model.services;

import org.apache.catalina.connector.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifdevs.ace.exceptions.EntityExistsException;
import com.ifdevs.ace.exceptions.ServerErrorException;
import com.ifdevs.ace.model.dtos.RegisterProfessionalUserDTO;
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
    boolean userExistsWithEmail = userRepository.findByEmail(cpf)
        .isPresent();
    boolean userExistsWithCpf = userRepository.findByCpf(email)
        .isPresent();
    if (userExistsWithCpf || userExistsWithEmail)
      throw new EntityExistsException("Usuário ja cadastrado");
    return null;
  }

  private Response generateNewUserEntity(RegisterProfessionalUserDTO registerProfessionalUserDTO) {
    User userToSave = new User();
    BeanUtils.copyProperties(registerProfessionalUserDTO, userToSave);
    System.out.println(userToSave.getName());
    this.roleService.generateNewRole(RoleEnum.TEACHER);
    try {
      userRepository.save(userToSave);
      return null;
    } catch (Exception e) {
      throw new ServerErrorException("Ocorreu um erro, tente novamente mais tarde!");
    }
  }
}