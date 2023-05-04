package com.encora.exception;

import com.encora.model.ErrorResponseDTO;
import com.encora.model.WrapperResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebInputException;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionSystem(Exception ex) {
        log.error(ex.getMessage(), ex);
        WrapperResponseDTO response = WrapperResponseDTO.builder()
                                                  .status("error")
                                                  .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                                  .error(ErrorResponseDTO.builder()
                                                                      .errorMessage("Se ha producido un error interno en el servidor")
                                                                      .build())
                                                  .build();
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(ServerWebInputException.class)
    public ResponseEntity<Object> serverWebExceptionSystem(ServerWebInputException ex) {
        log.error(ex.getMessage(), ex);
        WrapperResponseDTO response = WrapperResponseDTO.builder()
                                                  .status("error")
                                                  .statusCode(HttpStatus.BAD_REQUEST.value())
                                                  .error(ErrorResponseDTO.builder()
                                                                      .errorMessage("La solicitud posee una sintaxis incorrecta o falta parametro(s) requerido(s)")
                                                                      .build())
                                                  .build();
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> validationException(ValidationException ex) {
        log.error(ex.getMessage(), ex);
        WrapperResponseDTO response = WrapperResponseDTO.builder()
                .status("error")
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .error(ErrorResponseDTO.builder()
                                    .errorMessage(ex.getMessage())
                                    .build())
                .build();

        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
