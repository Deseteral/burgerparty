package com.deseteral.burgerparty.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionMapper {
    @ExceptionHandler(KeyNotFoundException.class)
    public ResponseEntity<Error> handleException(KeyNotFoundException exception) {
        Error error = new Error.Builder()
            .withStatus(404)
            .withMessage("Nie odnaleziono zasobu z podanym kluczem")
            .build();

        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
}

