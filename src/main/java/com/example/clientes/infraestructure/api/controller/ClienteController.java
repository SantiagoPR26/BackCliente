package com.example.clientes.infraestructure.api.controller;

import com.example.clientes.application.ClienteDelete;
import com.example.clientes.application.ClienteEdit;
import com.example.clientes.application.ClienteGet;
import com.example.clientes.application.ClienteSave;
import com.example.clientes.domain.entities.Cliente;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/cliente")
public class  ClienteController {
  private final ClienteSave clienteSave;
  private final ClienteEdit clienteEdit;
  private final ClienteGet clienteGet;
  private final ClienteDelete clienteDelete;

  @PostMapping(value = "/create")
  public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
    return new ResponseEntity<>(clienteSave.saveCliente(cliente), HttpStatus.CREATED);
  }
  @PutMapping(value = "/edit")
  public void editCliente(@RequestBody Cliente cliente){
    clienteEdit.editCliente(cliente);
  }
  @PutMapping(value = "/changeStatus")
  public void changeStatus(@RequestBody Cliente cliente){
    clienteDelete.deleteCliente(cliente);
  }
  @GetMapping(value = "/search/{id}")
  public ResponseEntity<Cliente> getCliente(@PathVariable("id") String id){
    return ResponseEntity.ok(clienteGet.getCliente(id));
  }
  @GetMapping(value = "/searchAll")
  public ResponseEntity<List<Cliente>> getListClientes(){
    return ResponseEntity.ok(clienteGet.getListClientes());
  }
}
