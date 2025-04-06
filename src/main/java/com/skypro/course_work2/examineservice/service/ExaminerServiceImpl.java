package com.skypro.course_work2.examineservice.service;


import com.skypro.course_work2.examineservice.domain.Question;
import com.skypro.course_work2.examineservice.exception.AmountException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collection;
import java.util.HashSet;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    QuestionService questionService;

    @ExceptionHandler(AmountException.class)
    public ResponseEntity<String> amountHandler(AmountException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {

        Collection<Question> allQuestion = questionService.getAll();
        Collection<Question> result = new HashSet<>();
        if (allQuestion.size() < amount) {
            throw new AmountException();
        } else if (allQuestion.size() == amount) {
            return allQuestion;
        } else {
            while (result.size() < amount) {
                result.add(questionService.getRandomQuestion());
            }
            return  result;
        }
    }
}
