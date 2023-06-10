package com.ifdevs.ace.model.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifdevs.ace.model.entities.BehavioralProfile;

public interface BehavioralProfileRepository extends JpaRepository<BehavioralProfile, UUID> {
  @Query(value = "select b from behavioral_profile b where b.student_uuid = ?1", nativeQuery = true)
  Optional<BehavioralProfile> getByEstudentUUID(UUID uuid);
}
