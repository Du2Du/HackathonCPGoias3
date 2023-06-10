package com.ifdevs.ace.model.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifdevs.ace.model.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

  @Query("select u from User u where u.email = ?1")
  public Optional<User> findByEmail(String email);

  @Query("select u from User u where u.cpf = ?1")
  public Optional<User> findByCpf(String cpf);

  @Query("select u from User u where u.role.roleName = 'STUDENT'")
  public List<User> findAllStudents();
}
