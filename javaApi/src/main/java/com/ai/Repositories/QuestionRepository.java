package com.ai.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.EntityClasses.Question;

//QuestionRepository.java
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
 // Custom query methods if needed
}