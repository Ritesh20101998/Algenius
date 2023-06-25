package com.ai.Service.Interface;

import java.util.List;

import com.ai.EntityClasses.Answer;

//AnswerService.java
public interface AnswerService {
 Answer createAnswer(Answer answer);
 Answer getAnswerById(Long id);
 List<Answer> getAllAnswers();
 void deleteAnswer(Long id);
}