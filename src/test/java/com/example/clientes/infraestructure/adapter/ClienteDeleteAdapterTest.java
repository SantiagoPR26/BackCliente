package com.example.clientes.infraestructure.adapter;

import static org.junit.jupiter.api.Assertions.*;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.infraestructure.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteDeleteAdapterTest {
  @InjectMocks
  private ClienteDeleteAdapter clienteDeleteAdapter;
  @Mock
  private ClienteRepository clienteRepository;

  @Test
  void deleteCliente() {
    Cliente cliente = Cliente.builder().id("123").tipoId("CC")
        .nombre("Jario").apellido("Herrera").estado(Boolean.TRUE).build();

    clienteDeleteAdapter.deleteCliente(cliente);
    Mockito.verify(clienteRepository, Mockito.times(1))
        .updateStateCliente(cliente.getId(), cliente.getEstado());
  }
}