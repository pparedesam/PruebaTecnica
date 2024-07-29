package com.exercise.personservice.person.domain.repository;

import com.exercise.personservice.person.domain.entities.Person;

public interface CreatePersonRepository {
    Person create(Person person);
}
