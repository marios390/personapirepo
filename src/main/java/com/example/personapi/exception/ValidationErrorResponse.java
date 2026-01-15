package com.example.personapi.exception;

import java.util.List;

public record ValidationErrorResponse(String message, List<FieldErrorItem> fieldErrors) {}
