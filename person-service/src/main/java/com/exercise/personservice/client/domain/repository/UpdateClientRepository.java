package com.exercise.personservice.client.domain.repository;

import com.exercise.personservice.client.domain.entities.Client;

public interface UpdateClientRepository {

    Client update(Client client);
}
