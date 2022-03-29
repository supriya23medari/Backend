package com.softwareChaser.springboot.Controller;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softwareChaser.springboot.Model.Question;
import com.softwareChaser.springboot.Service.QuizService;

import ch.qos.logback.classic.Level;

@RestController
public class QuizController {
	

	
	@Autowired
	private QuizService Qservice;
	
	@GetMapping("/")
	public String home() {
		return "hello";
	}

	@PostMapping("/questions")
	public Question SaveQuestions(@RequestBody Question question) {
	
		return Qservice.saveQuestions(question);
	}
	
	@GetMapping("/questions")
	public List <Question> getQuestions() {
	        return Qservice.getQuestions();
	}
	
	@GetMapping("/quiz/subjectandlevel")
	public List<Question> findBySubjectAndLevel(@PathVariable("Subject") Subject subject,@PathVariable("Level") Level level) {
		return Qservice.FindBySubjectAndLevel(subject,level);
	} 
	
}
