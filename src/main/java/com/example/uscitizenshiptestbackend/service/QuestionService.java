package com.example.uscitizenshiptestbackend.service;

import com.example.uscitizenshiptestbackend.model.Question;
import com.example.uscitizenshiptestbackend.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> saveAll(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }

    public Question ubdateQuestion(Question question) {
        Question existingQuestion = questionRepository.findById(question.getId()).orElse(null);
        existingQuestion.setQuestion(question.getQuestion());
        existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
        existingQuestion.setIncorrectAnswer1(question.getIncorrectAnswer1());
        existingQuestion.setIncorrectAnswer2(question.getIncorrectAnswer2());
        existingQuestion.setIncorrectAnswer3(question.getIncorrectAnswer3());

        return questionRepository.save(existingQuestion);
    }

    public String deleteQuestion(Long id){
        questionRepository.deleteById(id);
        return "Question deleted " + id;
    }


}
