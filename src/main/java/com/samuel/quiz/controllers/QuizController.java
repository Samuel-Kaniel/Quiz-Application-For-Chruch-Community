package com.samuel.quiz.controllers;

import com.samuel.quiz.model.DTO.QuestionWrapper;
import com.samuel.quiz.model.DTO.Response;
import com.samuel.quiz.model.Question;
import com.samuel.quiz.services.Quiz.QuizService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numberOfQuestions,
                                             @RequestParam String title)
    {
        return quizService.createQuiz(category, numberOfQuestions, title);
    }

    @GetMapping("get/{id}")
    public  ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
    {
        return quizService.getQuizQuestion(id);
    }


    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,
                                              @RequestBody List<Response> responses)
    {
        return quizService.calculateResult(id, responses);
    }
}
