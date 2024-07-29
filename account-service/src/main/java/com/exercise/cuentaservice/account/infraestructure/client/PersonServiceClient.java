package com.exercise.cuentaservice.account.infraestructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "person-service-client", url="http://person-service:8080")
public interface PersonServiceClient {
    @GetMapping("/v1/client/{id}")
    String getClient(@PathVariable("id") Long id);
}
