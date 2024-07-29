package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.application.port.GetClientByNamePort;
import com.exercise.personservice.client.application.port.GetClientPort;
import com.exercise.personservice.client.application.port.GetClientsPort;
import com.exercise.personservice.client.domain.entities.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GetClientController.class)
public class GetClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetClientsPort getClientsPort;

    @MockBean
    private GetClientPort getClientPort;

    @MockBean
    private GetClientByNamePort getClientByNamePort;

    @Test
    public void getClients_ShouldReturnClients() throws Exception {
        List<Client> clients = Arrays.asList(new Client(), new Client());
        when(getClientsPort.execute()).thenReturn(clients);

        mockMvc.perform(get("/v1/client"))
                .andExpect(status().isOk());

        verify(getClientsPort).execute();
    }

    @Test
    public void getClientById_ShouldReturnClient() throws Exception {
        Long id = 1L;
        ClientResponseDto client = mock(ClientResponseDto.class,RETURNS_MOCKS);
        when(getClientPort.findById(id)).thenReturn(client);

        mockMvc.perform(get("/v1/client/{id}", id))
                .andExpect(status().isOk());

        verify(getClientPort).findById(id);
    }

    @Test
    public void getClientByName_ShouldReturnClient() throws Exception {
        String name = "Test Name";
        ClientResponseDto client =  mock(ClientResponseDto.class,RETURNS_MOCKS);
        when(getClientByNamePort.findByName(name)).thenReturn(client);

        mockMvc.perform(get("/v1/client/name").param("name", name))
                .andExpect(status().isOk());

        verify(getClientByNamePort).findByName(name);
    }
}
