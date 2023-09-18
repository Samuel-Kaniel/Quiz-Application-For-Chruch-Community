package com.samuel.quiz.controllers;

import com.samuel.quiz.model.Question;
import com.samuel.quiz.services.Question.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {



    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    // Create

    @PostMapping("/single-questions")
    public ResponseEntity<Question> saveQuestions(@RequestBody Question question)
    {
        return new ResponseEntity<Question>(questionService.addQuestion(question), HttpStatus.CREATED);
    }


    @PostMapping("/all-questions")
    public ResponseEntity<List<Question>> saveQuestions(@RequestBody List<Question> question)
    {
        return new ResponseEntity<List<Question>>(questionService.addAllQuestion(question), HttpStatus.CREATED);
    }



//  Read

    @GetMapping
    public List<Question> getAllQuestion()
    {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category)
    {
        return new ResponseEntity<List<Question>>(questionService.getAllQuestionByCategories(category), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id)
    {
        return new ResponseEntity<Question>(questionService.getAllQuestionById(id), HttpStatus.OK);
    }

//    Update

//    @PostMapping("category/{id}")
//    public ResponseEntity<Question> updateQuestionBasedOnId(@PathVariable Integer id, @RequestBody Question question)
//    {
//        return new ResponseEntity<Question>(questionService.updateQuestion(question, id), HttpStatus.OK);
//    }
    @PutMapping("{id}")
    public ResponseEntity<Question> updateQuestionBasedOnId(@PathVariable Integer id, @RequestBody Question question)
    {
        return new ResponseEntity<Question>(questionService.updateQuestion(question, id), HttpStatus.OK);
    }
// Delete
@DeleteMapping("{id}")
public ResponseEntity<String> deleteQuestion(@PathVariable Integer id)
{
    questionService.deleteQuestion(id);
    return new ResponseEntity<String>("Question deleted Successfully!", HttpStatus.OK);
}
}
