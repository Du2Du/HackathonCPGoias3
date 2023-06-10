package com.ifdevs.ace.model.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class UserDTO {
  private UUID uuid;
  private String name;
  @Email
  private String email;
  private String roleName;

  @Builder
  public UserDTO(UUID uuid, String name, String email, String roleName) {
    this.uuid = uuid;
    this.name = name;
    this.email = email;
    this.roleName = roleName;
  }
}
