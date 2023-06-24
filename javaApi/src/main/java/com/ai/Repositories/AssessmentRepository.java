package com.ai.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.EntityClasses.Assessment;

//AssessmentRepository.java
@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
 // Custom query methods if needed
}