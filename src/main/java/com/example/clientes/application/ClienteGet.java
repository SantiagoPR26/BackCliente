package com.example.clientes.application;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteGetService;
import com.example.clientes.shared.exception.base.ClientInactiveException;
import com.example.clientes.shared.exception.base.ClientNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ClienteGet {
  private final ClienteGetService clienteGetService;

  public Cliente getCliente(String id){
    Cliente cliente = clienteGetService.getCliente(id);
    if(cliente == null){
      throw new ClientNotFoundException("No existe un cliente con la Id ingresada");
    }
    if(!cliente.getEstado()){
      throw new ClientInactiveException("El cliente se encuentra inactivo");
    }
    return cliente;
  }

  public List<Cliente> getListClientes(){
    return clienteGetService.getListClientes();
  }
}
