package com.example.clientes.application;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteEditService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteEdit {
  private final ClienteEditService clienteEditService;

  public void editCliente(Cliente cliente){
    clienteEditService.editCliente(cliente);
  }
}
