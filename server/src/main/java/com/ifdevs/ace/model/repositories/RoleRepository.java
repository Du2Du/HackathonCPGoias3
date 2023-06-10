package com.ifdevs.ace.model.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifdevs.ace.model.entities.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {
  @Query("select r from Role r where r.roleName = ?1")
  Role findByRoleName(String roleName);
}
