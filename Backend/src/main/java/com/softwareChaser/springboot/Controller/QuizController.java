package com.softwareChaser.springboot.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softwareChaser.springboot.Error.QuizNotFoundException;
import com.softwareChaser.springboot.Model.Question;
import com.softwareChaser.springboot.Service.QuizService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class QuizController {
	
	Logger logger=LoggerFactory.getLogger(QuizController.class);
	
	@Autowired
	private QuizService Qservice;
	
	@GetMapping("/")
	public String home() {
		return "hello";
	}

	@PostMapping("/quiz")
	public ResponseEntity<Question> SaveQuestions(@RequestBody Question question) {
	
		logger.error("questions saved");
		return new ResponseEntity<>(Qservice.saveQuestions(question), HttpStatus.OK);
	}
	

	
	@GetMapping("/quiz")
	public ResponseEntity<List <Question>> getQuestions() {
		
			
			return new ResponseEntity<>(Qservice.getQuestions(),HttpStatus.OK);
	        
	}
	
	@GetMapping("/quiz/{id}")
	public ResponseEntity<Question> fetchByQid(@PathVariable("id") Long Qid) throws QuizNotFoundException
	{
		
		logger.error("question id is "+Qid);
		return new ResponseEntity<>(Qservice.fetchByQid(Qid),HttpStatus.OK);
	}	
	
	@GetMapping("/quiz/Category/{Category}")
	public ResponseEntity<List<Question>> fetchByCategory(@PathVariable("Category") String Category)
	{
		logger.error("You have choosed category"+Category);
		return new ResponseEntity<>(Qservice.fetchByCategory(Category),HttpStatus.OK);
	}	

	@GetMapping("/quiz/Difficulty/{Difficulty}")
	public ResponseEntity<List<Question>> fetchByDifficulty(@PathVariable("Difficulty") String Difficulty)
	{
		logger.error("You have entered into "+Difficulty);
		return new ResponseEntity<>(Qservice.fetchByDifficulty(Difficulty),HttpStatus.OK);
	}	
	
	@GetMapping("/quiz/CategoryAndDifficulty") 
	public ResponseEntity<List<Question>> fetchByCategoryAndDifficulty(@RequestParam String Category,@RequestParam String Difficulty) 
	{ 
		logger.error("you have choosed "+Category+" of "+Difficulty);
	return new ResponseEntity<>(Qservice.fetchByCategoryAndDifficulty(Category, Difficulty),HttpStatus.OK); 
    	
	}
	 


}
