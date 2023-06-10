package com.ifdevs.ace.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifdevs.ace.model.entities.Role;
import com.ifdevs.ace.model.repositories.RoleRepository;
import com.ifdevs.ace.utils.enums.RoleEnum;

@Service
public class RoleService {

  @Autowired
  RoleRepository roleRepository;

  public void generateNewRole(String roleEnum) {
    Role role = new Role();
    role.setRoleName(roleEnum);
    roleRepository.save(role);
  }

  public Role getRoleByName(String roleEnum) {
    return roleRepository.findByRoleName(roleEnum);
  }
}
