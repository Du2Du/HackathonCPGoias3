package com.ifdevs.ace.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliateResponseDTO {
  private String question;
  private float score;
  private String observation;
}
