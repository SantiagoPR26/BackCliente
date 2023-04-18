package com.example.clientes.infraestructure.adapter;

import static org.junit.jupiter.api.Assertions.*;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.infraestructure.mapper.ClienteMapper;
import com.example.clientes.infraestructure.repository.ClienteRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteGetAdapterTest {
  @InjectMocks
  private ClienteGetAdapter clienteGetAdapter;
  @Mock
  private ClienteRepository clienteRepository;
  @Mock
  private ClienteMapper clienteMapper;

  @Test
  void getCliente() {
    Cliente cliente = Cliente.builder().id("123").tipoId("CC")
        .nombre("Jario").apellido("Herrera").estado(Boolean.TRUE).build();

    clienteGetAdapter.getCliente(cliente.getId());
    Mockito.verify(clienteRepository, Mockito.times(1)).findById(cliente.getId());
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

    //Mockito.when(clienteGetAdapter.getListClientes()).thenReturn(clienteList);
    clienteGetAdapter.getListClientes();
    Mockito.verify(clienteRepository, Mockito.times(1)).findAll();
  }
}