package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.port.UpdateClientPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UpdateClientController.class)
public class UpdateClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UpdateClientPort updateClientPort;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateClient_ShouldUpdateClient() throws Exception {

    }
}
