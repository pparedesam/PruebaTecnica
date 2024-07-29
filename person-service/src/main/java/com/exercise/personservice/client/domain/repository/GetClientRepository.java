package com.exercise.personservice.client.domain.repository;

import com.exercise.personservice.client.domain.entities.Client;

import java.util.List;

public interface GetClientRepository {
    List<Client> findAll();

    Client findById(Long idClient);

    List<Client> findByName(String name);


}
