package com.ai.ControllerClasses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.EntityClasses.Question;
import com.ai.Service.Interface.QuestionService;

//QuestionController.java
@RestController
@RequestMapping("/api/questions")
public class QuestionController {
	
	@Autowired
 private  QuestionService questionService;

 public QuestionController(QuestionService questionService) {
     this.questionService = questionService;
 }

 @PostMapping
 public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
     Question createdQuestion = questionService.createQuestion(question);
     return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
     Question question = questionService.getQuestionById(id);
     if (question != null) {
         return ResponseEntity.ok(question);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @GetMapping
 public ResponseEntity<List<Question>> getAllQuestions() {
     List<Question> questions = questionService.getAllQuestions();
     return ResponseEntity.ok(questions);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
     questionService.deleteQuestion(id);
     return ResponseEntity.noContent().build();
 }
}