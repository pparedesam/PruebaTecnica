package com.exercise.personservice.client.domain.repository;

import com.exercise.personservice.client.domain.entities.Client;

public interface CreateClientRepository {
    Client create(Client client);
}
