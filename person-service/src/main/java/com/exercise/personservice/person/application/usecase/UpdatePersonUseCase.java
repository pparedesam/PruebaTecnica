package com.exercise.personservice.person.application.usecase;

import com.exercise.personservice.person.application.port.UpdatePersonPort;
import com.exercise.personservice.person.domain.entities.Person;
import com.exercise.personservice.person.domain.repository.UpdatePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonUseCase implements UpdatePersonPort {

    @Autowired
    private UpdatePersonRepository updatePersonRepository;

    @Override
    public Person update(Person person) {
        return updatePersonRepository.update(person);
    }
}
