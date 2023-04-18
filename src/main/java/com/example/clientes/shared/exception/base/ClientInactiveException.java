package com.example.clientes.shared.exception.base;

import org.springframework.http.HttpStatus;

public class ClientInactiveException extends BaseException {

  public ClientInactiveException(String message) {
    super(false, HttpStatus.NOT_ACCEPTABLE, message, ExceptionCode.CLIENT_INACTIVE);
  }
}
