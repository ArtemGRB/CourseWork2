package com.skypro.course_work2.examineservice.controller;

import com.skypro.course_work2.examineservice.domain.Question;
import com.skypro.course_work2.examineservice.exception.AmountException;
import com.skypro.course_work2.examineservice.service.ExaminerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) throws AmountException {
        if (amount > examinerService.getAmountQuestion()) {
            throw new AmountException("Ведены некорректные данные: хотите получить больше вопросов чем есть в базе");
        }
        return examinerService.getQuestion(amount);
    }

}
