package com.skypro.course_work2.examineservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloblalHandlerException {

    @ExceptionHandler(AmountException.class)
    public ResponseEntity<String> handlerException(AmountException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
