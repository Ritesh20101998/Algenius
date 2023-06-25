package com.ai.EntityClasses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

//Question.java
@Data
@Entity
public class Question {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String text;
 // other question properties

 @ManyToOne
 private Assessment assessment;

 // Getters and setters
}