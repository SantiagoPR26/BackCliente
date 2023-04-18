package com.example.clientes.infraestructure.mapper;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.infraestructure.dto.ClienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ClienteMapper {
  Cliente toClienteEntity(ClienteDto clienteDto);
  ClienteDto toClienteDto(Cliente cliente);
}
