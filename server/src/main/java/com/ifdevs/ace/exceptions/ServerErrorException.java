package com.ifdevs.ace.exceptions;

public class ServerErrorException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ServerErrorException(String message) {
    super(message);
  }
}
