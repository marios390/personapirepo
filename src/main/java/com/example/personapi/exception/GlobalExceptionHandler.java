package com.example.personapi.exception;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(PersonNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(PersonNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse(ex.getMessage()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
    List<FieldErrorItem> errors = ex.getBindingResult().getFieldErrors().stream()
        .map(this::toFieldError)
        .toList();
    ValidationErrorResponse response = new ValidationErrorResponse("Validation failed", errors);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(BindException.class)
  public ResponseEntity<ValidationErrorResponse> handleBindException(BindException ex) {
    List<FieldErrorItem> errors = ex.getBindingResult().getFieldErrors().stream()
        .map(this::toFieldError)
        .toList();
    ValidationErrorResponse response = new ValidationErrorResponse("Validation failed", errors);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  private FieldErrorItem toFieldError(FieldError fieldError) {
    String message = fieldError.getDefaultMessage();
    return new FieldErrorItem(fieldError.getField(), message == null ? "Invalid value" : message);
  }
}
