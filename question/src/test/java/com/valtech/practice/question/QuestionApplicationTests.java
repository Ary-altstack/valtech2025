package com.valtech.practice.question;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.valtech.practice.question.services.QuestionService;
import com.valtech.practice.question.vos.QuestionVO;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuestionApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private Integer port; 
	
	@Autowired
	private QuestionService questionService;

	@Test
	void questionService() {
		
//		assertEquals(5, questionService.countByTopic("GK"));
		assertEquals(2, questionService.countByTopic("Design"));	
	}
//	@Test
//	public void test() {
//		String url ="http://localhost:"+port+"/api/v1/questions/";
//		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//	}
	

	
	@BeforeEach
	void addQuestions() {
//		long count = questionService.count();
		
		String url = "http://localhost:"+port+"/api/v1/questions/topic/Design";
		List question = restTemplate.getForObject(url,List.class);
//		System.out.println("PPPPPPPPPPPPPPPPPPPPP"+question);
		
//		if (count!=0) 
//			return;
		
//		QuestionVO q = questionService.saveOrUpdateQuestion(new QuestionVO(0, "Which file format should never be given to the client??", "png","psd","gif","jpg", "psd", "Design"));
//		(new QuestionVO(0, "Which country has the highest life expectancy?", "Hong-Kong","India","Australia","USA", "Hong-Kong", "GK"));
//		questionService.saveOrUpdateQuestion(new QuestionVO(0, "How many minutes are in a full week??", "10,090","10,080","10,070","10,060", "10,080", "GK"));
//		questionService.saveOrUpdateQuestion(new QuestionVO(0, "What company was initially known as Blue Ribbon Sports?", "Adidas","Under-Armour","Nike","Puma", "Nike", "GK"));
//		questionService.saveOrUpdateQuestion(new QuestionVO(0, "How many dots appear on a pair of dice?", "36","42","48","52", "42", "GK"));
//		questionService.saveOrUpdateQuestion(new QuestionVO(0, "What phone company produced the 3310?", "Nokia","Samsung","Apple","Microsoft", "Nokia", "GK"));

		
		
	}

}
