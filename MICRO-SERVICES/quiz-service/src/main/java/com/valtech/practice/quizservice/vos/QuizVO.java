package com.valtech.practice.quizservice.vos;

import java.util.ArrayList;
import java.util.List;

import com.valtech.practice.quizservice.entities.Question;
import com.valtech.practice.quizservice.entities.Quiz;

public record QuizVO(int id,String topic, int noOfQuestions,List<Integer> questionId) {
	
	public Quiz to() {
//		List<Question>questions = new ArrayList<Question>();
//		questions.add(questions());
		return new Quiz(topic,noOfQuestions);
//		return new Quiz(id,topic,noOfQuestions,questions);
	}

	public static QuizVO from(Quiz quiz) {
//		return new QuizVO(quiz.getId(),quiz.topic,quiz.getNoOfQuestions(),quiz.questions);
//		List<Question>questions = quiz.getQuestions();
		return new QuizVO(quiz.getId(),quiz.getTopic(),quiz.getNoOfQuestions(),quiz.getQuestionId());
//		return null;
	}
	
	
}
