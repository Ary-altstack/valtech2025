package com.valtech.practice.quizservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.practice.quizservice.services.QuizService;
import com.valtech.practice.quizservice.vos.QuizVO;

@RestController
@RequestMapping("api/v1/quiz")

public class QuizController {
	
	@Autowired
	private QuizService quizService;

	@PostMapping("/")
	public QuizVO createQuiz(@RequestBody QuizVO quizVO) {
		return quizService.saveOrUpdateQuiz(quizVO);
	}
	
}
