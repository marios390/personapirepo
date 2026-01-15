package com.example.personapi.service;

import com.example.personapi.dto.PersonCreateRequest;
import com.example.personapi.dto.PersonResponse;
import com.example.personapi.dto.PersonUpdateRequest;
import com.example.personapi.exception.PersonNotFoundException;
import com.example.personapi.model.Person;
import com.example.personapi.repository.PersonRepository;
import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private final PersonRepository repository;

  public PersonService(PersonRepository repository) {
    this.repository = repository;
  }

  public List<PersonResponse> listAll() {
    return StreamSupport.stream(repository.findAll().spliterator(), false)
        .map(this::toResponse)
        .toList();
  }

  public PersonResponse getById(long id) {
    Person person = repository.findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));
    return toResponse(person);
  }

  public PersonResponse create(PersonCreateRequest request) {
    Person saved = repository.save(new Person(
        null,
        request.firstName(),
        request.lastName(),
        request.email()
    ));
    return toResponse(saved);
  }

  public PersonResponse update(long id, PersonUpdateRequest request) {
    Person existing = repository.findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));
    Person saved = repository.save(new Person(
        existing.id(),
        request.firstName(),
        request.lastName(),
        request.email()
    ));
    return toResponse(saved);
  }

  public void delete(long id) {
    if (!repository.existsById(id)) {
      throw new PersonNotFoundException(id);
    }
    repository.deleteById(id);
  }

  public List<PersonResponse> searchByLastName(String lastName) {
    return repository.findByLastNameContainingIgnoreCase(lastName).stream()
        .map(this::toResponse)
        .toList();
  }

  private PersonResponse toResponse(Person person) {
    return new PersonResponse(person.id(), person.firstName(), person.lastName(), person.email());
  }
}
