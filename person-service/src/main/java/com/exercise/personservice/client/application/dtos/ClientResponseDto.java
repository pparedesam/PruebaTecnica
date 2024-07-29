package com.exercise.personservice.client.application.dtos;

public record ClientResponseDto(
        Long id,
        String name,
        String address,
        String phone
) {
}
