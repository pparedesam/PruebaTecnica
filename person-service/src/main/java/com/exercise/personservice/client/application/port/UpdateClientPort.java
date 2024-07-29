package com.exercise.personservice.client.application.port;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;
import com.exercise.personservice.client.application.dtos.ClientResponseDto;

public interface UpdateClientPort {
    ClientResponseDto update(ClientRequestDto clientRequestDto);
}
