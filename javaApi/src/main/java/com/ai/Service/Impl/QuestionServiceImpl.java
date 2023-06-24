package com.ai.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.EntityClasses.Question;
import com.ai.ExceptionClasses.QuestionNotFoundException;
import com.ai.Repositories.QuestionRepository;
import com.ai.Service.Interface.QuestionService;

//QuestionServiceImpl.java
@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
 private  QuestionRepository questionRepository;

 public QuestionServiceImpl(QuestionRepository questionRepository) {
     this.questionRepository = questionRepository;
 }

 @Override
 public Question createQuestion(Question question) {
     return questionRepository.save(question);
 }

 @Override
 public Question getQuestionById(Long id) {
     return questionRepository.findById(id)
             .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + id));
 }

 @Override
 public List<Question> getAllQuestions() {
     return questionRepository.findAll();
 }

 @Override
 public void deleteQuestion(Long id) {
     if (!questionRepository.existsById(id)) {
         throw new QuestionNotFoundException("Question not found with id: " + id);
     }
     questionRepository.deleteById(id);
 }
}
