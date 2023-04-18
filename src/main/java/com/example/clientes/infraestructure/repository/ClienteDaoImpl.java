package com.example.clientes.infraestructure.repository;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.infraestructure.dao.ClienteDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDao {
  private final String INSERT_SQL = "insert into cliente_dto (id, tipo_id, nombre, apellido, estado) values (:id, :tipoId, :nombre, :apellido, :estado)";
  private final String GET_BY_ID_SQL = "select * from cliente_dto where id = :id";
  private final String GET_ALL_SQL = "select * from cliente_dto";

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public Cliente saveCliente(final Cliente cliente){
    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", cliente.getId())
        .addValue("tipoId", cliente.getTipoId())
        .addValue("nombre", cliente.getNombre())
        .addValue("apellido", cliente.getApellido())
        .addValue("estado", cliente.getEstado());

    /*Map<String, Object> map = new HashMap<String, Object>();
    map.put("id", cliente.getId());
    map.
    map.put("nombre", cliente.getNombre());*/

    namedParameterJdbcTemplate.execute(INSERT_SQL, parameters, new PreparedStatementCallback<Object>() {
      public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
        return ps.executeUpdate();
      }
    });
    return cliente;
  }

}
