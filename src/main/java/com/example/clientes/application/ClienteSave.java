package com.example.clientes.application;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteSaveService;
import com.example.clientes.infraestructure.repository.ClienteRepository;
import com.example.clientes.shared.exception.base.ClientNotFoundException;
import com.example.clientes.shared.exception.base.IdAlReadyExistException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ClienteSave {
  private final ClienteSaveService clienteSaveService;
  private final ClienteRepository clienteRepository;

  public Cliente saveCliente(Cliente cliente)
  {
    if (clienteRepository.existsById(cliente.getId())){
      throw new IdAlReadyExistException("La id " + cliente.getId()+ " ya existe");
  }
    return clienteSaveService.saveCliente(cliente);
  }
}
