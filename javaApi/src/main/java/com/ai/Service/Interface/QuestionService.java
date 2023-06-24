package com.ai.Service.Interface;

import java.util.List;

import com.ai.EntityClasses.Question;

//QuestionService.java
public interface QuestionService {
 Question createQuestion(Question question);
 Question getQuestionById(Long id);
 List<Question> getAllQuestions();
 void deleteQuestion(Long id);
}