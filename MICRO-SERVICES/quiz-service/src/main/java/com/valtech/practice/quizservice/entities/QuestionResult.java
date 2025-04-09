 package com.valtech.practice.quizservice.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

public class QuestionResult {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "quesRes_seq")
	@SequenceGenerator(name = "quesRes_seq", sequenceName = "quesRes",allocationSize = 1)
	private int id;
	
	private String userAnswer;
	private String result;
	
	private List<Integer> questionId;
	
	@ManyToOne(targetEntity = Quiz.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name ="quiz_id",referencedColumnName = "id")
	private Quiz quiz;
	
	
	public QuestionResult() {}
	

	public QuestionResult(int id, String userAnswer, String result, List<Integer> questionId) {
		this.id = id;
		this.userAnswer = userAnswer;
		this.result = result;
		this.questionId = questionId;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<Integer> getQuestionId() {
		return questionId;
	}

	public void setQuestionId(List<Integer> questionId) {
		this.questionId = questionId;
	}
	

}
