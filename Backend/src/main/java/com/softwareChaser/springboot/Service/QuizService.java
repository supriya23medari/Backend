package com.softwareChaser.springboot.Service;

import java.util.List;

import com.softwareChaser.springboot.Error.QuizNotFoundException;
import com.softwareChaser.springboot.Model.Question;
import com.softwareChaser.springboot.Model.Result;



public interface QuizService {
	


	public List<Question> getQuestions();


	public Question saveQuestions(Question question);

	public List<Question> fetchByCategory(String Category);
	
	public List<Question> fetchByDifficulty(String Difficulty);

	public List<Question> fetchByCategoryAndDifficulty(String category, String difficulty);


	public Result saveResults(Result result);


	public List<Result>  getResults();


	public Question fetchByQid(Long Qid) throws QuizNotFoundException;
	 
}
