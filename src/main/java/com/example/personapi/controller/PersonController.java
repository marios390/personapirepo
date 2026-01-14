package com.example.personapi.controller;

import com.example.personapi.dto.PersonCreateRequest;
import com.example.personapi.dto.PersonResponse;
import com.example.personapi.dto.PersonSearchRequest;
import com.example.personapi.dto.PersonUpdateRequest;
import com.example.personapi.service.PersonService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {
  private final PersonService service;

  public PersonController(PersonService service) {
    this.service = service;
  }

  @GetMapping
  public List<PersonResponse> listAll() {
    return service.listAll();
  }

  @GetMapping("/{id}")
  public PersonResponse getById(@PathVariable long id) {
    return service.getById(id);
  }

  @PostMapping
  public ResponseEntity<PersonResponse> create(@Valid @RequestBody PersonCreateRequest request) {
    PersonResponse response = service.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PutMapping("/{id}")
  public PersonResponse update(@PathVariable long id, @Valid @RequestBody PersonUpdateRequest request) {
    return service.update(id, request);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/search")
  public List<PersonResponse> search(@Valid @ModelAttribute PersonSearchRequest request) {
    return service.searchByLastName(request.lastName());
  }
}
