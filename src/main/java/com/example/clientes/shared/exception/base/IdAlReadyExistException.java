package com.example.clientes.shared.exception.base;

import org.springframework.http.HttpStatus;

public class IdAlReadyExistException extends BaseException{

  public IdAlReadyExistException(String message){
    super(false, HttpStatus.CONFLICT, message, ExceptionCode.CLIENT_ALREADY_EXIST);
  }

}
