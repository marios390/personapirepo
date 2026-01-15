package com.example.personapi.exception;

public class PersonNotFoundException extends RuntimeException {
  public PersonNotFoundException(long id) {
    super("Person not found: " + id);
  }
}
