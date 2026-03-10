package com.romulo.databasemongo.common.exceptions;

import com.romulo.databasemongo.common.dto.response.ErroResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErroResponse> handleObjectNotFoundException(ObjectNotFoundException ex,HttpServletRequest request){

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErroResponse erro = new ErroResponse(Instant.now().toEpochMilli(), httpStatus.value(),
                                        "Não encontrado!", ex.getMessage(), request.getRequestURI() );
        return ResponseEntity.status(httpStatus).body(erro);
    }
}
