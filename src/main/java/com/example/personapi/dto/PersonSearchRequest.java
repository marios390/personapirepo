package com.example.personapi.dto;

import jakarta.validation.constraints.NotBlank;

public record PersonSearchRequest(@NotBlank String lastName) {}
