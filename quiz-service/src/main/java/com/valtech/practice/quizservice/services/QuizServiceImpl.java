package com.valtech.practice.quizservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.practice.quizservice.entities.Quiz;
import com.valtech.practice.quizservice.repos.QuizRepo;
import com.valtech.practice.quizservice.vos.QuizVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Override
	public QuizVO saveOrUpdateQuiz(QuizVO vo) {
		Quiz quiz = vo.to();
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);
	}
	
	
	
	
	
	

}
