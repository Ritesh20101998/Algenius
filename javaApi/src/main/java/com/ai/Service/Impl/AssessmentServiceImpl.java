package com.ai.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.EntityClasses.Assessment;
import com.ai.ExceptionClasses.AssessmentNotFoundException;
import com.ai.Repositories.AssessmentRepository;
import com.ai.Service.Interface.AssessmentService;

//AssessmentServiceImpl.java
@Service
public class AssessmentServiceImpl implements AssessmentService {
	
	@Autowired
 private  AssessmentRepository assessmentRepository;

 public AssessmentServiceImpl(AssessmentRepository assessmentRepository) {
     this.assessmentRepository = assessmentRepository;
 }

 @Override
 public Assessment createAssessment(Assessment assessment) {
     return assessmentRepository.save(assessment);
 }

 @Override
 public Assessment getAssessmentById(Long id) {
     return assessmentRepository.findById(id)
             .orElseThrow(() -> new AssessmentNotFoundException("Assessment not found with id: " + id));
 }

 @Override
 public List<Assessment> getAllAssessments() {
     return assessmentRepository.findAll();
 }

 @Override
 public void deleteAssessment(Long id) {
     if (!assessmentRepository.existsById(id)) {
         throw new AssessmentNotFoundException("Assessment not found with id: " + id);
     }
     assessmentRepository.deleteById(id);
 }
}