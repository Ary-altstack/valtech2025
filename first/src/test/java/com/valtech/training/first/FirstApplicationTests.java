package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
//@Transactional(propagation = Propagation.REQUIRED)
class FirstApplicationTests {
	
	@Autowired
	private Arithmetic arithmetic;
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService;
	

	@Test
	void testArithmetic() {
		assertEquals(10,arithmetic.add(5, 5));
		assertEquals(200,simpleInterest.compute(200,5,20));
	}
	
	
	@Test
	@Rollback()
	void questionService() {
		
		initData();
//		assertEquals(6, questionService.findAllByTopic("GK".si()));
//		assertEquals(6, questionService.findAllByTopic("Java".size()));
		assertEquals(6, questionService.countByTopic("GK"));
		assertEquals(6, questionService.countByTopic("Java"));
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("Java","Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("Java","Interface"));
//		assertEquals(1, questionService.findAllByTopic("GK", 2,5));

	
	}
	@Test
//	@Rollback
	
	@BeforeEach
	void initData() {
		long count = questionService.count();
		if (count!=0) return;
	
	
//		System.out.println("Question service class name: "+questionService.getClass().getName());
//		long count = questionService.count();
		Question q = questionService.saveQuestion(new Question("What is the color of Sky??","Red","Blue","Green","Pink","White","GK"));
		questionService.saveQuestion(new Question("What is the color of Mars??","Red","Blue","Green","Pink","White","GK"));
		questionService.saveQuestion(new Question("What is the color of Moon??","Red","Blue","Green","Pink","White","GK"));
		questionService.saveQuestion(new Question("What is the color of Jupiter??","Red","Blue","Green","Pink","White","GK"));
		questionService.saveQuestion(new Question("What is the color of Saturn??","Red","Blue","Green","Pink","White","GK"));
		questionService.saveQuestion(new Question("What is the color of Venus??","Red","Blue","Green","Pink","White","GK"));
		
		questionService.saveQuestion(new Question("What is the SuperClass of Exceptions??","Obj","Exception","Throwable","Error","White","Java"));
		questionService.saveQuestion(new Question("Which class is used to create Dynamic Strings??","DynamicStrings","Builder","StringBuilder","Pink","White","GK"));
		questionService.saveQuestion(new Question("How many methods are there in marker Interface??","None","One","Two","Three","Four","Java"));
		questionService.saveQuestion(new Question("How many methods are there in functional Interface??","None","One","Two","Three","Four","Java"));
		questionService.saveQuestion(new Question("Can an Interface have private methods??","Yes","No","Maybe","No methods can be there","Yes","Java"));
		questionService.saveQuestion(new Question("Which subclass of Exception is not checked by the compile??","Exception","Error","RuntimeException,","CompiletimeException","Many","Java"));



		
//		assertTrue(q.getId() > 0);
////		System.out.println(q);
//		assertEquals(count+1, questionService.count());
	}
	
	
}
