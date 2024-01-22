package com.example.uscitizenshiptestbackend.controller;

import com.example.uscitizenshiptestbackend.model.Question;
import com.example.uscitizenshiptestbackend.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citizenship")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("{/id}")
    public Optional<Question> findById(@PathVariable Long id){
        return questionService.findById(id);
    }
    @GetMapping
    public List<Question> findAll(){
        return questionService.findAll();
    }
    @PostMapping("/addquestion")
    public Question addQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }

    @PostMapping("/addQuestions")
    public List<Question> addQuestions(@RequestBody List<Question> questions){
        return questionService.saveQuestions(questions);
    }

    @PutMapping("/update")
    public Question updateQuestion(@RequestBody Question question){
        return questionService.ubdateQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id){
        return questionService.deleteQuestion(id);
    }
}
