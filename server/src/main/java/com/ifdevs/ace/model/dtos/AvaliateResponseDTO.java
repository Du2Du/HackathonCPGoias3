package com.ifdevs.ace.model.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliateResponseDTO {
  private UUID questionUUID;
  private float score;
  private String observation;
}
