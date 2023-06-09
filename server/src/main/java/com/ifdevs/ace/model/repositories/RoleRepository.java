package com.ifdevs.ace.model.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifdevs.ace.model.entities.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {

}
