package com.example.clientes.infraestructure.adapter;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteDeleteService;
import com.example.clientes.infraestructure.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClienteDeleteAdapter implements ClienteDeleteService {
  private final ClienteRepository clienteRepository;

  @Transactional
  public void deleteCliente(Cliente cliente) {
    clienteRepository.updateStateCliente(cliente.getId(), cliente.getEstado());
  }
}
