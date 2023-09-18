package com.samuel.quiz.services.Quiz;

import com.samuel.quiz.model.DTO.QuestionWrapper;
import com.samuel.quiz.model.DTO.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String title);


    ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id);

    ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);
}
