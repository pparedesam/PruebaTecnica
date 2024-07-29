package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.port.DeleteClientPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DeleteClienteController.class)
public class DeleteClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeleteClientPort deleteClientPort;

    @Test
    public void deleteClient_ShouldDeleteClient() throws Exception {
        Long idClient = 1L;

        mockMvc.perform(delete("/v1/client")
                        .param("idClient", idClient.toString()))
                .andExpect(status().isOk());

        verify(deleteClientPort, times(1)).deleteById(idClient);
    }
}
