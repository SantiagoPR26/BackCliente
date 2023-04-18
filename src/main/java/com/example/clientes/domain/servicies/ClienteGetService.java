package com.example.clientes.domain.servicies;

import com.example.clientes.domain.entities.Cliente;
import java.util.List;

public interface ClienteGetService {
  Cliente getCliente(String id);
  List<Cliente> getListClientes();
}
