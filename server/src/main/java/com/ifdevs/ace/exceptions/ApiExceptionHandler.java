package com.ifdevs.ace.exceptions;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(EntityExistsException.class)
  public ResponseEntity<Object> handleEntityExistsException(EntityExistsException exception) {
    return buildResponseEntity(HttpStatus.CONFLICT, exception.getMessage(),
        Collections.singletonList(exception.getMessage()));
  }

  @ExceptionHandler(ServerErrorException.class)
  public ResponseEntity<Object> handleEntityExistsException(ServerErrorException exception) {
    return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(),
        Collections.singletonList(exception.getMessage()));
  }

  private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, String message, List<String> errors) {
    ApiError apiError = ApiError.builder()
        .code(httpStatus.value())
        .status(httpStatus.getReasonPhrase())
        .message(message)
        .errors(errors)
        .timestamp(LocalDateTime.now())
        .build();
    return ResponseEntity.status(httpStatus).body(apiError);
  }
}
