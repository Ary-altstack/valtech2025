package com.valtech.practice.quizservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.practice.quizservice.entities.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer>{

}
