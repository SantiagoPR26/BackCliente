package com.example.clientes.shared.exception.base;

import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends BaseException {
  public ClientNotFoundException(String message) {
    super(false, HttpStatus.NOT_FOUND, message, ExceptionCode.CLIENT_NOT_FOUND);
  }
}
