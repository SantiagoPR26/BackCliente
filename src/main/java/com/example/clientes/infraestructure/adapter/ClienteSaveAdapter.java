package com.example.clientes.infraestructure.adapter;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteSaveService;
import com.example.clientes.infraestructure.mapper.ClienteMapper;
import com.example.clientes.infraestructure.repository.ClienteDaoImpl;
import com.example.clientes.infraestructure.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteSaveAdapter implements ClienteSaveService {
  //private final ClienteRepository clienteRepository;
  private final ClienteMapper clienteMapper;
  private final ClienteDaoImpl clienteDao;

  @Override
  public Cliente saveCliente(Cliente cliente) {
    return clienteDao.saveCliente(cliente);
  }
}
