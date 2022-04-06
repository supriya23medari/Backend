package com.softwareChaser.springboot.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwareChaser.springboot.Model.Question;
import com.softwareChaser.springboot.Repository.QuestionRepository;


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

	@Override
	public List <Question> findByCategoryAndDifficulty(String Category, String Difficulty) {
		// TODO Auto-generated method stub
		return Qrepo.findByCategoryAndDifficulty(Category,Difficulty);
	}
	

//	@Override
//	public List<Question> findBySubjectAndLevel(Subject subject, String level) {
//		// TODO Auto-generated method stub
//		return Qrepo.findBySubjectAndLevel(subject, level);
//		}

	

	

}
