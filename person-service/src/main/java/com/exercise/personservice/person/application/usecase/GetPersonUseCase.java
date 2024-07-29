package com.exercise.personservice.person.application.usecase;


import com.exercise.personservice.person.application.port.GetPersonPort;
import com.exercise.personservice.person.domain.entities.Person;
import com.exercise.personservice.person.domain.repository.GetPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonUseCase implements GetPersonPort {

    @Autowired
    private GetPersonRepository getPersonRepository;

    @Override
    public List<Person> execute() {
        return getPersonRepository.findAll();
    }
}
