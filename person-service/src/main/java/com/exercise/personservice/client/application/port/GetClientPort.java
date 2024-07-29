package com.exercise.personservice.client.application.port;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;

public interface GetClientPort {

    ClientResponseDto findById(Long idCliente);
}
