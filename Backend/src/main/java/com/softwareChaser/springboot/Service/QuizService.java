package com.softwareChaser.springboot.Service;

import java.util.List;


import com.softwareChaser.springboot.Model.Question;



public interface QuizService {
	


	public List<Question> getQuestions();


	public Question saveQuestions(Question question);


	public List<Question> fetchByCategory(String Category);
	
	public List<Question> fetchByDifficulty(String Difficulty);

	public List<Question> fetchByCategoryAndDifficulty(String category, String difficulty);
	 
}
