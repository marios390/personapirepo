package com.example.personapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PersonUpdateRequest(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @NotBlank @Email String email
) {}
