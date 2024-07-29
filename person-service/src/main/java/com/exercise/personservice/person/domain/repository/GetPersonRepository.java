package com.exercise.personservice.person.domain.repository;

import com.exercise.personservice.person.domain.entities.Person;

import java.util.List;

public interface GetPersonRepository {
    List<Person> findAll();
}
