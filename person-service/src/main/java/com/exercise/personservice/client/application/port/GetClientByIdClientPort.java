package com.exercise.personservice.client.application.port;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.person.domain.entities.Person;

public interface GetClientByIdClientPort {

    ClientResponseDto findByName(String name);

    Person fingByIdClient(Long idClient);
}
