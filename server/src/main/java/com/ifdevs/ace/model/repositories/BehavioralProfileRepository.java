package com.ifdevs.ace.model.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifdevs.ace.model.entities.BehavioralProfile;

public interface BehavioralProfileRepository extends JpaRepository<BehavioralProfile, UUID> {
  @Query("select b from BehavioralProfile b where b.student.uuid = ?1")
  public BehavioralProfile getByEstudentUUID(UUID uuid);
}
