package com.valtech.practice.quizservice.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.practice.quizservice.vos.QuestionVO;

@Component
public class QuestionClient {
	
	public List<QuestionVO> getQuestion (String topic) {
		RestTemplate temp = new RestTemplate();
		String url = "http://localhost:9040/api/v1/questions/topic/"+topic;
		List<QuestionVO> ques = Arrays.asList(temp.getForObject(url,QuestionVO[].class)) ;
		return ques;
	}

}
