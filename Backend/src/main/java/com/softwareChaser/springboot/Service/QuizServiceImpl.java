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


	public List<Question> fetchByCategory(String Category) {
		// TODO Auto-generated method stub
	   return Qrepo.findByCategory(Category);
	}

	

	public List<Question> fetchByCategoryAndDifficulty(String Category, String Difficulty) {
		// TODO Auto-generated method stub
		return Qrepo.findByCategoryAndDifficulty(Category,Difficulty); 
	}

	@Override
	public List<Question> fetchByDifficulty(String Difficulty) {
		// TODO Auto-generated method stub
		return Qrepo.findByDifficulty(Difficulty);
	}
	


		

}
