package com.softwareChaser.springboot.Service;

import java.util.List;

import javax.security.auth.Subject;

import com.softwareChaser.springboot.Model.Question;

import ch.qos.logback.classic.Level;


public interface QuizService {
	


	public List<Question> getQuestions();


	public Question saveQuestions(Question question);




	public List<Question> FindBySubjectAndLevel(Subject subject, Level level);


}
