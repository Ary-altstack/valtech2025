package com.valtech.practice.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.practice.question.entities.Question;
import com.valtech.practice.question.services.QuestionService;
import com.valtech.practice.question.vos.QuestionVO;

@RestController
@RequestMapping("api/v1/questions")
public class questionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/")
	public List<QuestionVO>getAllQuestions(){
		return questionService.getAllQuestion();
	}
	
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable("id") int id) {
		return questionService.getQuestion(id);
	}
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO questionVO) {
		return questionService.saveOrUpdateQuestion(questionVO);
	}
	@GetMapping("/{topic}")
	public int countByTopic(@PathVariable("topic")String topic ){
		return questionService.countByTopic(topic);
	}
	
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> getAllByTopic(@PathVariable("topic") String topic ) {
		return questionService.findAllByTopic(topic);
	}
	
	
	
	
	
	

}
