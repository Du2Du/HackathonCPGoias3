package com.ifdevs.ace.model.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "behavioral_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BehavioralProfile {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uuid;

  @OneToOne
  private User student;

  private Long quantityAvaliations;

  @Max(value = 10)
  @Min(value = 0)
  private float behavioralRating;

}
