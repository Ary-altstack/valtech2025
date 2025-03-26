package com.valtech.practice.quizservice.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.practice.quizservice.entities.Quiz;
import com.valtech.practice.quizservice.repos.QuizRepo;
import com.valtech.practice.quizservice.vos.QuestionVO;
import com.valtech.practice.quizservice.vos.QuizVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	@Autowired
	private QuestionClient questionClient;
	
	@Override
	public QuizVO saveOrUpdateQuiz(QuizVO vo) {
		Quiz quiz = vo.to();
		String topic = quiz.getTopic();
		List<QuestionVO> questions = questionClient.getQuestion(topic);
		Collections.shuffle(questions);
		System.out.println("------------------"+questions);
//		int noOfQues = quiz.getNoOfQuestions();
		questions = questions.stream().limit(questions.size()).collect(Collectors.toList());
		List<Integer> quesId = questions.stream().map(l->l.id()).collect(Collectors.toList());
		quiz.setTopic(topic);
		quiz.setNoOfQuestions(questions.size());
//		quiz.setQuestionId(quesId);
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);
	}
	
	
	
	
	
	

}
