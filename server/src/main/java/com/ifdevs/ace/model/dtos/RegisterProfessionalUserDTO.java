package com.ifdevs.ace.model.dtos;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class RegisterProfessionalUserDTO {
  @NotBlank
  @NotNull
  private String name;

  @NotBlank
  @NotNull
  @Email
  private String email;

  @NotBlank
  @NotNull
  @Min(6)
  private String password;

  @NotBlank
  @NotNull
  @CPF
  private String cpf;

  @Builder
  public RegisterProfessionalUserDTO(String name, String email, String password, String cpf) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.cpf = cpf;
  }
}
