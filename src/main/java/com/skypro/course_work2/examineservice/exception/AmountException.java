package com.skypro.course_work2.examineservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountException extends RuntimeException {
    public AmountException(String message) {
        super(message);
    }
}
