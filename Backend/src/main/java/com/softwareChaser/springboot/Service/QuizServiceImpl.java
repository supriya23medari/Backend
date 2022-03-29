package com.softwareChaser.springboot.Service;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwareChaser.springboot.Model.Answer;
import com.softwareChaser.springboot.Model.Question;
import com.softwareChaser.springboot.Repository.QuestionRepository;

import ch.qos.logback.classic.Level;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuestionRepository Qrepo;
	
	public Question saveQuestions(Question question) {
		return Qrepo.save(question);
	}
	
	public List<Question> getQuestions() {
		return Qrepo.findAll();
	}



	
	public List<Question> FindBySubjectAndLevel(Subject subject, Level level) {
		// TODO Auto-generated method stub
		return Qrepo.findBySubjectAndLevel(subject, level);
	}

	

	

}
