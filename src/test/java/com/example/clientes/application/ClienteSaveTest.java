package com.example.clientes.application;

import static org.junit.jupiter.api.Assertions.*;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteSaveService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteSaveTest {
  @InjectMocks
  private ClienteSave clienteSave;
  @Mock
  private ClienteSaveService clienteSaveService;

  @Test
  void saveCliente() {
    Cliente cliente = Cliente.builder().id("123").tipoId("CC")
        .nombre("Jario").apellido("Herrera").estado(Boolean.TRUE).build();

    Mockito.when(clienteSaveService.saveCliente(cliente)).thenReturn(cliente);
    var response = clienteSave.saveCliente(cliente);
    Mockito.verify(clienteSaveService,Mockito.times(1)).saveCliente(cliente);
    Assertions.assertEquals(response, cliente);
  }
}