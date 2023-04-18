package com.example.clientes.domain.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
  @Id
  private String id;
  private String tipoId;
  private String nombre;
  private String apellido;
  private Boolean estado;
}
