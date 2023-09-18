package com.samuel.quiz.services.Question;

import com.samuel.quiz.exceptions.ResourceNotFound;
import com.samuel.quiz.model.Question;
import com.samuel.quiz.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImplementation implements QuestionService {

    private QuestionRepository questionRepository;

    public QuestionServiceImplementation(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getAllQuestionByCategories(String category) {
        return questionRepository.findByCategory(category);
    }

    @Override
    public Question getAllQuestionById(Integer id) {
        return questionRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Question", "Id", id));
    }

    @Override
    public Question updateQuestion(Question question, Integer id) {

        Question existingQuestion = questionRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Question", "id", id));

        existingQuestion.setQuestionTitle(question.getQuestionTitle());
        existingQuestion.setOption1(question.getOption1());
        existingQuestion.setOption2(question.getOption2());
        existingQuestion.setOption3(question.getOption3());
        existingQuestion.setOption4(question.getOption4());
        existingQuestion.setRightAnswer(question.getRightAnswer());
        existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
        existingQuestion.setCategory(question.getCategory());

        questionRepository.save(existingQuestion);
        return existingQuestion;
    }

//    @Override
//    public Question updateQuestionBasedOnCategory(Question question, String category) {
//        Question existingQuestion = questionRepository.findByCategory(category).orElseThrow(() -> new ResourceNotFound("Question", "category", category));
//
//        existingQuestion.setQuestionTitle(question.getQuestionTitle());
//        existingQuestion.setOption1(question.getOption1());
//        existingQuestion.setOption2(question.getOption2());
//        existingQuestion.setOption3(question.getOption3());
//        existingQuestion.setOption4(question.getOption4());
//        existingQuestion.setRightAnswer(question.getRightAnswer());
//        existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
//        existingQuestion.setCategory(question.getCategory());
//
//        questionRepository.save(existingQuestion);
//        return existingQuestion;
//    }

    @Override
    public void deleteQuestion(Integer id) {
        questionRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Question", "Id", id));
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> addAllQuestion(List<Question> question) {
        return questionRepository.saveAll(question);
    }
}
