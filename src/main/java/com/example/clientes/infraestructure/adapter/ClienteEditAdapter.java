package com.example.clientes.infraestructure.adapter;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteEditService;
import com.example.clientes.infraestructure.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClienteEditAdapter implements ClienteEditService {
  private final ClienteRepository clienteRepository;

  @Transactional
  public void editCliente(Cliente cliente) {
    clienteRepository.updateCliente(cliente.getId(),
                                    cliente.getNombre(),
                                    cliente.getApellido());
  }
}
