package com.springcamp.api.controller;

import com.springcamp.api.common.GeneralException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Getter
@Setter
@AllArgsConstructor
public class GeneralExceptionController {

    @ExceptionHandler(value = GeneralException.class)
    public ResponseEntity<ErrorMessage> exception(GeneralException exception){
        return new ResponseEntity<>(new ErrorMessage(exception.getMessage()),HttpStatus.BAD_REQUEST);
    }
}

class ErrorMessage{
    private String errorMessage;
    public ErrorMessage(String message) {
    }
}

