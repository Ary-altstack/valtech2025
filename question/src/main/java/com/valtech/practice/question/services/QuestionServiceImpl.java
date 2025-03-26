package com.valtech.practice.question.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.practice.question.entities.Question;
import com.valtech.practice.question.repos.QuestionRepo;
import com.valtech.practice.question.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {
	
	
	@Autowired
	private QuestionRepo questionRepo;
	
	
	
	@Override
	public QuestionVO saveOrUpdateQuestion(QuestionVO vo) {
		Question ques = vo.to();
		ques = questionRepo.save(ques);
		return QuestionVO.from(ques);
		
	}
	
	@Override
	public QuestionVO getQuestion (int id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getAllQuestion(){
		return questionRepo.findAll().stream().map(q->QuestionVO.from(q)).collect(Collectors.toList());
	}

	@Override
	public long count() {
		return questionRepo.count();
	}

	@Override
	public int countByTopic(String topic) {
		return questionRepo.countByTopic(topic);
	}
	
	@Override
	public List<QuestionVO> findAllByTopic(String topic){
		return QuestionVO.from(questionRepo.findAllByTopic(topic));

//		return questionRepo.findAllByTopic(topic);
		
	}
	
	
	
}
