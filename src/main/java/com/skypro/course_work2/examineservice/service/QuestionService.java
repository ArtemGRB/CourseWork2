package com.skypro.course_work2.examineservice.service;

import com.skypro.course_work2.examineservice.domain.Question;

import java.util.Collection;

public interface QuestionService {
    public Collection<Question> getAll();
    public Question getRandomQuestion();
    public Question add(String question, String answer);
    public Question remove(Question question);

}
