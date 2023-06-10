package com.ifdevs.ace.model.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uuid;

  private String description;

  @Column(name = "author_id")
  private String authorId;

  @ManyToMany
  private List<User> users;
}
