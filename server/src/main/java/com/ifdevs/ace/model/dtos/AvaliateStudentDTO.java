package com.ifdevs.ace.model.dtos;

import java.util.UUID;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class AvaliateStudentDTO {
  private UUID studentUUID;
  private List<AvaliateResponseDTO> avaliateResponses;

  @Builder
  public AvaliateStudentDTO(UUID studentUUID, List<AvaliateResponseDTO> avaliateResponses) {
    this.studentUUID = studentUUID;
    this.avaliateResponses = avaliateResponses;
  }
}
