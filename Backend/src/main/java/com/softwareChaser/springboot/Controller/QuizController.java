package com.softwareChaser.springboot.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softwareChaser.springboot.Model.Question;
import com.softwareChaser.springboot.Service.QuizService;


@RestController
public class QuizController {
	

	
	@Autowired
	private QuizService Qservice;
	
	@GetMapping("/")
	public String home() {
		return "hello";
	}

	@PostMapping("/questions")
	public ResponseEntity<Question> SaveQuestions(@RequestBody Question question) {
	
		return new ResponseEntity<>(Qservice.saveQuestions(question),HttpStatus.CREATED);
	}
	
	@GetMapping("/questions")
	public ResponseEntity<List <Question> >getQuestions() {
	        return new ResponseEntity<>(Qservice.getQuestions(),HttpStatus.OK);
	}
	
	@GetMapping("/quiz/{Category}/{difficulty}")
	public ResponseEntity< List <Question> >findByCategoryAndDifficulty(@RequestParam("Category") String Category,@RequestParam("Difficulty") String Difficulty){
		
		return new ResponseEntity<>(Qservice.findByCategoryAndDifficulty(Category,Difficulty),HttpStatus.OK);
		
	}

//	public  List<Question> findBySubjectAndLevel(Subject subject, String level){
//		return Qservice.findBySubjectAndLevel(subject,level);
//		
//	}
	

}
