package com.example.clientes.application;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteDeleteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteDelete {
  private final ClienteDeleteService clienteDeleteService;

  public void deleteCliente(Cliente cliente){
    clienteDeleteService.deleteCliente(cliente);
  }
}
