package com.softwareChaser.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwareChaser.springboot.Error.QuizNotFoundException;
import com.softwareChaser.springboot.Model.Question;
import com.softwareChaser.springboot.Model.Result;
import com.softwareChaser.springboot.Repository.QuestionRepository;
import com.softwareChaser.springboot.Repository.ResultRepository;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuestionRepository Qrepo;
	
	@Autowired
	private ResultRepository Rrepo;

	public Question fetchByQid(Long QId) throws QuizNotFoundException {
		// TODO Auto-generated method stub
       Optional<Question> question= Qrepo.findById(QId);
		
		if(!question.isPresent())
		{
			throw new QuizNotFoundException("Quiz not found");
		}
		return question.get();
	}
	
	public Question saveQuestions(Question question) {
		return Qrepo.save(question);
	}


	public Result saveResults(Result result) {
		return Rrepo.save(result);
	}

	@Override
	public List<Result> getResults() {
		// TODO Auto-generated method stub
		return Rrepo.findAll();
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
