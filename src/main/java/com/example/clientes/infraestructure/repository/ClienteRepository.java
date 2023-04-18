package com.example.clientes.infraestructure.repository;

import com.example.clientes.infraestructure.dto.ClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteDto, String> {
  boolean existsById(String id);
  @Query(nativeQuery = true, value = "update cliente_dto set nombre = :nombre, apellido = :apellido where id = :id")
  @Modifying
  void updateCliente(@Param("id") String id,

                     @Param("nombre") String nombre,
                     @Param("apellido") String apellido);

  @Query(nativeQuery = true, value = "update cliente_dto set estado = :estado where id = :id")
  @Modifying
  void updateStateCliente(@Param("id") String id, @Param("estado") Boolean estado);
}
