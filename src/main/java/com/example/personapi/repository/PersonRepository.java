package com.example.personapi.repository;

import com.example.personapi.model.Person;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
public interface PersonRepository extends CrudRepository<Person, Long> {
  List<Person> findByLastNameContainingIgnoreCase(String lastName);
}
