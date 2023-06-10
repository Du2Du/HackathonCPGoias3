package com.ifdevs.ace.utils.enums;

public enum RoleEnum {
  ESTUDENT("ESTUDENT"),
  ADMIN("ADMIN"),
  TEACHER("TEACHER"),
  RESPONSIBLE("RESPONSIBLE");

  public String valueName;

  RoleEnum(String value) {
    valueName = value;
  }
}
