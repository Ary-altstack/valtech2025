 package com.valtech.practice.quizservice.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Quiz {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="quiz_seq")
	@SequenceGenerator(name="quiz_seq",sequenceName="quiz_seq",allocationSize = 1)
	public int id;
	public String topic;
	public int noOfQuestions;
	
//	@ElementCollection
//	@CollectionTable(name="quiz_table",joinColumns = @JoinColumn(name="quiz_id"))
	private List<Integer> questionId;

	@OneToMany()
	@JoinColumn(name = "questionResult_id",referencedColumnName = "id")
	private List<QuestionResult> questionResult;
	
	public Quiz() {}


	public Quiz( String topic, int noOfQuestions) {
		this.topic = topic;
		this.noOfQuestions = noOfQuestions;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public int getNoOfQuestions() {
		return noOfQuestions;
	}


	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	
	public List<Integer> getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(List<Integer> questionId) {
		this.questionId = questionId;
	}
	
	
	
	

}
