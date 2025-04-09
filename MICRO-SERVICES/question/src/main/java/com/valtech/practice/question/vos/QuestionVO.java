package com.valtech.practice.question.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.practice.question.entities.Question;

public record QuestionVO(int id, String questionText,String option1, String option2,String option3,String option4,String correctOption,String topic) {
	
	
	public Question to() {
		return new Question(questionText,option1,option2,option3,option4,correctOption,topic);
	}
	
	public static QuestionVO from(Question ques) {
		return new QuestionVO(ques.getId(),ques.getQuestionText(),ques.getOption1(),ques.getOption2(),ques.getOption3(),
				ques.getOption4(),ques.getCorrectoption(),ques.getTopic());
	}
	
	public static List<QuestionVO> from(List<Question>ques){
		return ques.stream().map(l->QuestionVO.from(l)).collect(Collectors.toList());
	}
	
	
	
	

}
