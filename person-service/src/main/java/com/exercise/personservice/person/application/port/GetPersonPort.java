package com.exercise.personservice.person.application.port;

import com.exercise.personservice.person.domain.entities.Person;

import java.util.List;

public interface GetPersonPort {
    List<Person> execute();


}
