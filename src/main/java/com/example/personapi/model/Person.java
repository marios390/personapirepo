package com.example.personapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("persons")
public record Person(
    @Id @Column("ID") Long id,
    @Column("first_name") String firstName,
    @Column("last_name") String lastName,
    @Column("email") String email
) {}
