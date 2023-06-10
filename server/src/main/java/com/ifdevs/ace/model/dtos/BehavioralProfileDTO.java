package com.ifdevs.ace.model.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BehavioralProfileDTO {

  private UUID uuid;
  private UUID studentUUID;
  private float behavioralRating;
}
