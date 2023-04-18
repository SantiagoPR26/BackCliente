package com.example.clientes.infraestructure.dao;

import com.example.clientes.domain.entities.Cliente;
import java.util.List;

public interface ClienteDao {
  Cliente saveCliente(Cliente cliente);
  /*Cliente getCliente(String id);
  List<Cliente> getListClientes();*/
}
