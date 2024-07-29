package com.exercise.personservice.person.application.usecase;

import com.exercise.personservice.person.application.port.CreatePersonPort;
import com.exercise.personservice.person.domain.entities.Person;
import com.exercise.personservice.person.domain.repository.CreatePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonUseCase implements CreatePersonPort {

    @Autowired
    private CreatePersonRepository createPersonRepository;

    @Override
    public Person execute(Person person) {
        return createPersonRepository.create(person);
    }
}
