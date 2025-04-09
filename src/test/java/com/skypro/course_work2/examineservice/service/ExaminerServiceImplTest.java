package com.skypro.course_work2.examineservice.service;

import com.skypro.course_work2.examineservice.domain.Question;
import com.skypro.course_work2.examineservice.exception.AmountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestion_whenAmountGreaterThanSizeCollection_thenThrowException() {
        Collection<Question> test = new HashSet<>();
        test.add(new Question("test", "test"));

        Mockito.when(questionService.getAll()).thenReturn(test);

        Assertions.assertThrows(AmountException.class, () -> examinerService.getQuestion(4));
    }

    @Test
    void getQuestion_whenAmountLessThanSizeCollection_thenCollection() {
        Collection<Question> test = new HashSet<>();
        test.add(new Question("test1", "test1"));
        test.add(new Question("test2", "test2"));

        Collection<Question> result = new HashSet<>();
        result.add(new Question("test2", "test2"));

        Mockito.when(questionService.getAll()).thenReturn(test);
        Mockito.when(questionService.getRandomQuestion())
                .thenReturn(new Question("test2", "test2"));

        Assertions.assertEquals(result, examinerService.getQuestion(1));
    }

    @Test
    void getQuestion_whenAmountIsEqualSizeCollection_thenCollection() {
        Collection<Question> test = new HashSet<>();
        test.add(new Question("test2", "test2"));

        Collection<Question> result = new HashSet<>();
        result.add(new Question("test2", "test2"));

        Mockito.when(questionService.getAll()).thenReturn(test);

        assertEquals(result, examinerService.getQuestion(1));
    }

}