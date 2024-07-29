package com.exercise.personservice.client.application.port;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;

public interface CreateClientPort {
    void execute(ClientRequestDto clientRequestDto);
}
