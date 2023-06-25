package com.ai.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.EntityClasses.Answer;

//AnswerRepository.java
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
 // Custom query methods if needed
}