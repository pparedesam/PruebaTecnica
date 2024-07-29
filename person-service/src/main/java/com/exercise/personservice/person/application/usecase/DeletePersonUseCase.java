package com.exercise.personservice.person.application.usecase;

import com.exercise.personservice.person.application.port.DeletePersonPort;
import com.exercise.personservice.person.domain.repository.DeletePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonUseCase implements DeletePersonPort {

    @Autowired
    DeletePersonRepository deletePersonRepository;

    @Override
    public void deleteById(Long idPerson) {

        deletePersonRepository.deleteById(idPerson);

    }
}
