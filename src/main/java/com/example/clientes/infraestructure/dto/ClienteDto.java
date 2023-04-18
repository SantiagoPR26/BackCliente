package com.example.clientes.infraestructure.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ClienteDto {
  @Id
  private String id;
  private String tipoId;
  private String nombre;
  private String apellido;
  private Boolean estado;
}
