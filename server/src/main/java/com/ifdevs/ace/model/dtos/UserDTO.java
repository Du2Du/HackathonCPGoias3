package com.ifdevs.ace.model.dtos;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class UserDTO {
  private String name;
  @Email
  private String email;

  @Builder
  public UserDTO(String name, String email) {
    this.name = name;
    this.email = email;
  }
}
