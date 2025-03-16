package com.valtech.practice.quizservice.services;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.valtech.practice.quizservice.vos.QuestionVO;

public class QuestionClient {
	
	public List<QuestionVO> ques (String topic) {
		RestTemplate temp = new RestTemplate();
		String url = "http://localhost:9010/api/v1/questions/"+topic;
		List<QuestionVO> ques = temp.getForObject(url, List.class);
		return ques;
	}

}
