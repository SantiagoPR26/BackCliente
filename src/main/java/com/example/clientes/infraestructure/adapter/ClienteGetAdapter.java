package com.example.clientes.infraestructure.adapter;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteGetService;
import com.example.clientes.infraestructure.dto.ClienteDto;
import com.example.clientes.infraestructure.mapper.ClienteMapper;
import com.example.clientes.infraestructure.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteGetAdapter implements ClienteGetService {
  private final ClienteRepository clienteRepository;
  private final ClienteMapper clienteMapper;

  @Override
  public Cliente getCliente(String id) {
    Optional<ClienteDto> clienteDto = clienteRepository.findById(id);
    return clienteDto.map(clienteMapper::toClienteEntity).orElse(null);
  }

  @Override
  public List<Cliente> getListClientes() {
    List<ClienteDto> clientesDto = clienteRepository.findAll();
    return clientesDto.stream()
        .filter(clienteDto -> clienteDto.getEstado() == Boolean.TRUE)
        .map(clienteMapper::toClienteEntity).toList();
  }
}
