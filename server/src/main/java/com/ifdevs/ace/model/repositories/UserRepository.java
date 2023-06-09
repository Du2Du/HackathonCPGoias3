package com.ifdevs.ace.model.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifdevs.ace.model.dtos.UserDTO;
import com.ifdevs.ace.model.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  public Optional<UserDTO> findByEmail(String email);

  public Optional<UserDTO> findByCpf(String cpf);
}
