package com.example.clientes.application;

import static org.junit.jupiter.api.Assertions.*;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteEditService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteEditTest {
  @InjectMocks
  private ClienteEdit clienteEdit;
  @Mock
  private ClienteEditService clienteEditService;

  @Test
  void editCliente() {
    Cliente cliente = Cliente.builder().id("123").tipoId("CC")
        .nombre("Jario").apellido("Herrera").estado(Boolean.TRUE).build();

    clienteEdit.editCliente(cliente);
    Mockito.verify(clienteEditService, Mockito.times(1)).editCliente(cliente);
  }
}