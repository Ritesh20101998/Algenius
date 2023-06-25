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

import com.ai.EntityClasses.Answer;
import com.ai.Service.Interface.AnswerService;

//AnswerController.java
@RestController
@RequestMapping("/api/answers")
public class AnswerController {
     @Autowired
 	private  AnswerService answerService;

 public AnswerController(AnswerService answerService) {
     this.answerService = answerService;
 }

 @PostMapping
 public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {
     Answer createdAnswer = answerService.createAnswer(answer);
     return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
     Answer answer = answerService.getAnswerById(id);
     if (answer != null) {
         return ResponseEntity.ok(answer);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @GetMapping
 public ResponseEntity<List<Answer>> getAllAnswers() {
     List<Answer> answers = answerService.getAllAnswers();
     return ResponseEntity.ok(answers);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
     answerService.deleteAnswer(id);
     return ResponseEntity.noContent().build();
 }
}