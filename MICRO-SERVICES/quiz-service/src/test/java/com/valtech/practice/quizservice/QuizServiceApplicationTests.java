package com.valtech.practice.quizservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.valtech.practice.quizservice.services.QuizService;
import com.valtech.practice.quizservice.vos.QuizVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuizServiceApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private QuizService quizService;

	
	@Test
	public void test() {
		String url = "http://localhost:"+port+"/api/v1/quiz/";
//		String url = "http://localhost:"+port+"/api/v1/questions/";
		QuizVO quizVO = restTemplate.postForObject(url, new QuizVO(0,"GK",5,null), QuizVO.class);

//		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	
	

}
