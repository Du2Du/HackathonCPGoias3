package com.ifdevs.ace.model.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifdevs.ace.model.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

}
