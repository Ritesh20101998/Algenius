package com.ai.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.EntityClasses.Answer;
import com.ai.ExceptionClasses.AnswerNotFoundException;
import com.ai.Repositories.AnswerRepository;
import com.ai.Service.Interface.AnswerService;

//AnswerServiceImpl.java
@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
 private  AnswerRepository answerRepository;

 public AnswerServiceImpl(AnswerRepository answerRepository) {
     this.answerRepository = answerRepository;
 }

 @Override
 public Answer createAnswer(Answer answer) {
     return answerRepository.save(answer);
 }

 @Override
 public Answer getAnswerById(Long id) {
     return answerRepository.findById(id)
             .orElseThrow(() -> new AnswerNotFoundException("Answer not found with id: " + id));
 }

 @Override
 public List<Answer> getAllAnswers() {
     return answerRepository.findAll();
 }

 @Override
 public void deleteAnswer(Long id) {
     if (!answerRepository.existsById(id)) {
         throw new AnswerNotFoundException("Answer not found with id: " + id);
     }
     answerRepository.deleteById(id);
 }
}