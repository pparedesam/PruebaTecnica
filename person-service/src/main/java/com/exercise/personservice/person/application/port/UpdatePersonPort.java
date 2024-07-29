package com.exercise.personservice.person.application.port;

import com.exercise.personservice.person.domain.entities.Person;

public interface UpdatePersonPort {
    Person update(Person person);
}
