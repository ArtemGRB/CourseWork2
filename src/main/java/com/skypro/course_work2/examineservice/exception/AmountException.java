package com.skypro.course_work2.examineservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AmountException extends IllegalAccessException {
    public AmountException(String message) {
        super(message);
    }
}
