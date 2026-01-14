package com.example.personapi.dto;

public record PersonResponse(
    Long id,
    String firstName,
    String lastName,
    String email
) {}
