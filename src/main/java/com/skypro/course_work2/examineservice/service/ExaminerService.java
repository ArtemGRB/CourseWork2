package com.skypro.course_work2.examineservice.service;

import com.skypro.course_work2.examineservice.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
