package com.exercise.personservice.client.application.port;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;

import java.util.List;

public interface GetClientByNamePort {

   List<ClientResponseDto> findByName(String name);
}
