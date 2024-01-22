package com.example.uscitizenshiptestbackend.repository;

import com.example.uscitizenshiptestbackend.model.Question;
import org.springframework.data.repository.ListCrudRepository;

public interface QuestionRepository  extends ListCrudRepository<Question, Long> {
}
