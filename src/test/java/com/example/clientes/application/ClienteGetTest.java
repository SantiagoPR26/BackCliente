package com.example.clientes.application;

import static org.junit.jupiter.api.Assertions.*;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteGetService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteGetTest {
  @InjectMocks
  private ClienteGet clienteGet;
  @Mock
  private ClienteGetService clienteGetService;

  @Test
  void getCliente() {
    Cliente cliente = Cliente.builder().id("123").tipoId("CC")
        .nombre("Jario").apellido("Herrera").estado(Boolean.TRUE).build();

    Mockito.when(clienteGetService.getCliente(cliente.getId())).thenReturn(cliente);
    var response = clienteGet.getCliente(cliente.getId());
    Assertions.assertEquals(response, cliente);
    Assertions.assertEquals(response.getEstado(),Boolean.TRUE);
  }

  @Test
  void getListClientes() {
    Cliente cliente1 = Cliente.builder().id("123").tipoId("CC")
        .nombre("Jario").apellido("Herrera").estado(Boolean.TRUE).build();
    Cliente cliente2 = Cliente.builder().id("456").tipoId("CC")
        .nombre("Camila").apellido("Bello").estado(Boolean.TRUE).build();
    Cliente cliente3 = Cliente.builder().id("789").tipoId("CC")
        .nombre("Julie").apellido("Ramirez").estado(Boolean.TRUE).build();

    List<Cliente> clienteList = List.of(cliente1, cliente2, cliente3);

    Mockito.when(clienteGetService.getListClientes()).thenReturn(clienteList);
    var response = clienteGet.getListClientes();
    Assertions.assertEquals(response, clienteList);
  }
}