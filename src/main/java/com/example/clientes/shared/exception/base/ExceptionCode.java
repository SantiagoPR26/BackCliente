package com.example.clientes.shared.exception.base;

import lombok.Getter;

@Getter
public enum ExceptionCode{
  CLIENT_NOT_FOUND("ERR-001", "CLIENT_NOT_FOUND"),

  CLIENT_ALREADY_EXIST("ERR-003", "CLIENT_ALREADY_EXIST"),
  CLIENT_INACTIVE("ERR-002", "CLIENT_INACTIVE");
  private final String code;
  private final String type;

  ExceptionCode(String code, String type) {
    this.code = code;
    this.type = type;
  }
}
