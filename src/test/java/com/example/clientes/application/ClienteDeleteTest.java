package com.example.clientes.application;

import static org.junit.jupiter.api.Assertions.*;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteDeleteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteDeleteTest {
  @InjectMocks
  private ClienteDelete clienteDelete;
  @Mock
  private ClienteDeleteService clienteDeleteService;

  @Test
  void deleteCliente() {
    Cliente cliente = Cliente.builder().id("123").tipoId("CC")
        .nombre("Jario").apellido("Herrera").estado(Boolean.TRUE).build();

    clienteDelete.deleteCliente(cliente);
    Mockito.verify(clienteDeleteService, Mockito.times(1)).deleteCliente(cliente);
  }
}