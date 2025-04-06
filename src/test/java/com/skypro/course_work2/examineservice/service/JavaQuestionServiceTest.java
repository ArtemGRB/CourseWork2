package com.skypro.course_work2.examineservice.service;

import com.skypro.course_work2.examineservice.domain.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @InjectMocks
    JavaQuestionService javaQuestionService;

    @Test
    void add_whenAddObj_thenAddObjToCollection() {
        Set<Question> questions = new HashSet<>();
        questions.add(new Question("test1", "test1"));
        javaQuestionService.add("test1", "test1");
        assertEquals(questions, javaQuestionService.getAll());
    }
}