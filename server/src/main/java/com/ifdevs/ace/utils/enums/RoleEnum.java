package com.ifdevs.ace.utils.enums;

public enum RoleEnum {
  STUDENT("STUDENT"),
  ADMIN("ADMIN"),
  TEACHER("TEACHER"),
  RESPONSIBLE("RESPONSIBLE");

  public String valueName;

  RoleEnum(String value) {
    valueName = value;
  }
}
