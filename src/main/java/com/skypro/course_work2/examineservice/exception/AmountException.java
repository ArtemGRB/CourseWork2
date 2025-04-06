package com.skypro.course_work2.examineservice.exception;

public class AmountException extends RuntimeException {
    public AmountException() {
        super("400 BAD_REQUEST");
    }
}
