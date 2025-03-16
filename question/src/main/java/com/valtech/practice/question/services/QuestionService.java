package com.valtech.practice.question.services;

import java.util.List;

import com.valtech.practice.question.entities.Question;
import com.valtech.practice.question.vos.QuestionVO;

public interface QuestionService {

	QuestionVO saveOrUpdateQuestion(QuestionVO vo);

	QuestionVO getQuestion (int id);

	List<QuestionVO> getAllQuestion();

	long count();

	int countByTopic(String topic);

	List<Question> findAllByTopic(String topic);

}