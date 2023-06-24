package com.ai.Service.Interface;

import java.util.List;

import com.ai.EntityClasses.Assessment;

//AssessmentService.java
public interface AssessmentService {
 Assessment createAssessment(Assessment assessment);
 Assessment getAssessmentById(Long id);
 List<Assessment> getAllAssessments();
 void deleteAssessment(Long id);
}