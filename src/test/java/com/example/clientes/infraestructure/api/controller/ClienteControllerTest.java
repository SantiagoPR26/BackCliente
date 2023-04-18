package com.example.clientes.infraestructure.api.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.clientes.application.ClienteDelete;
import com.example.clientes.application.ClienteEdit;
import com.example.clientes.application.ClienteGet;
import com.example.clientes.application.ClienteSave;
import com.example.clientes.domain.entities.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = ClienteController.class)
class ClienteControllerTest {
  @Autowired
  private MockMvc mockMvc;
  private ObjectMapper objectMapper = new ObjectMapper();
  @MockBean
  private ClienteSave clienteSave;
  @MockBean
  private ClienteGet clienteGet;
  @MockBean
  private ClienteEdit clienteEdit;
  @MockBean
  private ClienteDelete clienteDelete;

  @Test
  void saveCliente() {
  }

  @Test
  void editCliente() {
  }

  @Test
  void changeStatus() {
  }

  @Test
  void getCliente() throws Exception {
    Cliente cliente = Cliente.builder().id("123").tipoId("CC")
        .nombre("Jario").apellido("Herrera").estado(Boolean.TRUE).build();

    Mockito.when(clienteGet.getCliente(cliente.getId())).thenReturn(cliente);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cliente/search/{id}",cliente.getId())
        .accept(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    MockHttpServletResponse response = result.getResponse();
    Cliente cli = objectMapper.readValue(response.getContentAsString(), Cliente.class);

    assertEquals(HttpStatus.OK.value(), response.getStatus());
    assertEquals(cli, cliente);
  }

  @Test
  void getListClientes() {
  }
}