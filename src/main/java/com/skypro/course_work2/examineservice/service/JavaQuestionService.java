package com.skypro.course_work2.examineservice.service;

import com.skypro.course_work2.examineservice.domain.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private Random random = new Random();

    public Question add(String question, String answer) {
        Question questionObj = new Question(question, answer);
        questions.add(questionObj);
        return questionObj;
    }

    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    public Question getRandomQuestion(){
        Object[] questionsArray = questions.toArray();
        return (Question) questionsArray[random.nextInt(questionsArray.length)];
    }

}
