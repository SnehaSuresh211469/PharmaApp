package com.pharam.pharamaApp.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
         @ExceptionHandler(PharmaBusinessException .class)
         public ResponseEntity<String> handlePharmaException(PharmaBusinessException e){
             return  ResponseEntity.status(e.getErrorCode().getErrorCodeMsg()).body(e.getMessage());
         }
}
