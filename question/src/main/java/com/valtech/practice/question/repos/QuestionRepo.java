package com.valtech.practice.question.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.practice.question.entities.Question;

@Repository
public interface QuestionRepo  extends JpaRepository<Question, Integer>{

	int countByTopic(String topic);

	List<Question> findAllByTopic(String topic);
	

}
