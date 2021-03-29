package com.example.demo.controllerAdvice;

import com.example.demo.exception.Mensagem;
import com.example.demo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Mensagem> handlerNotFoundException(NotFoundException nfException){
            Mensagem mensagem = new Mensagem(nfException.getMessage() );
            return new ResponseEntity<Mensagem>(mensagem , HttpStatus.NOT_FOUND);
    }

}
