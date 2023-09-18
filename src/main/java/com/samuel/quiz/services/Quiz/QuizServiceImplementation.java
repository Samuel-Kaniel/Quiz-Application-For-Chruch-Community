package com.samuel.quiz.services.Quiz;

import com.samuel.quiz.exceptions.ResourceNotFound;
import com.samuel.quiz.model.DTO.QuestionWrapper;
import com.samuel.quiz.model.DTO.Response;
import com.samuel.quiz.model.Question;
import com.samuel.quiz.model.Quiz;
import com.samuel.quiz.repository.QuestionRepository;
import com.samuel.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImplementation implements QuizService{

    private QuizRepository quizRepository;

    @Autowired
    public QuizServiceImplementation(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String title) {

        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numberOfQuestions);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("Successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quizOptional = quizRepository.findById(id);

        if (quizOptional.isPresent()) {
            Quiz quiz = quizOptional.get();
            List<Question> questionFromDB = quiz.getQuestions();
            List<QuestionWrapper> questionsForUser = new ArrayList<>();

            for (Question question : questionFromDB) {
                QuestionWrapper qw = new QuestionWrapper(question.getId(), question.getQuestionTitle(),
                        question.getOption1(), question.getOption2(), question.getOption3(),
                        question.getOption4());
                questionsForUser.add(qw);
            }

            return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
        } else {
            // Handle the case where the Quiz with the given id was not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();

        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;

        for (Response response: responses) {

            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
            {
                right++;
            }
            i++;
        }



        return new ResponseEntity<>(right, HttpStatus.OK);
    }


}
