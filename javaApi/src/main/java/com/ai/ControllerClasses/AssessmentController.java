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

import com.ai.EntityClasses.Assessment;
import com.ai.Service.Interface.AssessmentService;

//AssessmentController.java
@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {
	@Autowired
 private  AssessmentService assessmentService;

 public AssessmentController(AssessmentService assessmentService) {
     this.assessmentService = assessmentService;
 }

 @PostMapping
 public ResponseEntity<Assessment> createAssessment(@RequestBody Assessment assessment) {
     Assessment createdAssessment = assessmentService.createAssessment(assessment);
     return ResponseEntity.status(HttpStatus.CREATED).body(createdAssessment);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Assessment> getAssessmentById(@PathVariable Long id) {
     Assessment assessment = assessmentService.getAssessmentById(id);
     if (assessment != null) {
         return ResponseEntity.ok(assessment);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @GetMapping
 public ResponseEntity<List<Assessment>> getAllAssessments() {
     List<Assessment> assessments = assessmentService.getAllAssessments();
     return ResponseEntity.ok(assessments);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteAssessment(@PathVariable Long id) {
     assessmentService.deleteAssessment(id);
     return ResponseEntity.noContent().build();
 }
}
