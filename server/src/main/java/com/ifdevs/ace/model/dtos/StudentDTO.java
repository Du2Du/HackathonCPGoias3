package com.ifdevs.ace.model.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class StudentDTO {
  private UUID uuid;
  private String name;
  @Email
  private String email;
  private String roleName;
  private int age;
  private float score;

  @Builder
  public StudentDTO(UUID uuid, String name, String email, String roleName, int age, float score) {
    this.uuid = uuid;
    this.name = name;
    this.email = email;
    this.roleName = roleName;
    this.age = age;
    this.score = score;
  }
}
