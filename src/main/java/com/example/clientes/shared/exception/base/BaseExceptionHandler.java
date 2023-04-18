package com.example.clientes.shared.exception.base;


import com.example.clientes.shared.exception.response.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseExceptionHandler {
  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorResponse> errorHandler(BaseException ex) {
    return new ResponseEntity<>(
        ErrorResponse.builder()
            .status(ex.getStatus().value())
            .code(ex.getCode())
            .message(ex.getMessage())
            .date(ex.getDate().toString())
            .build(),
        HttpStatusCode.valueOf(ex.getStatus().value())
    );
  }
}
