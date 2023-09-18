package com.samuel.quiz.services.Question;

import com.samuel.quiz.model.Question;

import java.util.List;

public interface QuestionService {

    Question addQuestion(Question question);



    List<Question> getAllQuestions();
    List<Question> getAllQuestionByCategories(String category);

    Question getAllQuestionById(Integer id);

    Question updateQuestion(Question question, Integer id);

//    Question updateQuestionBasedOnCategory(Question question, String category);

    void deleteQuestion(Integer id);

    List<Question> addAllQuestion(List<Question> question);
}
