package com.softwareChaser.springboot.Model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="Question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Qid;
	
	@Column(name = "category")
	private String Category;
	
	@Column(name = "difficulty")
	private String Difficulty;
	
	@Column(name = "question")
	private String Question;
	
	@ElementCollection
	@Column(name = "incorrect_answers")
	private List<String> incorrect_answers;
	//to hide answer we wil use jsponbackreference
	//@JsonBackReference 
	@OneToOne(cascade = CascadeType.ALL)
	private Answer answer;

	public Long getQid() {
		return Qid;
	}

	public void setQid(Long qid) {
		Qid = qid;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getDifficulty() {
		return Difficulty;
	}

	public void setDifficulty(String difficulty) {
		Difficulty = difficulty;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public List<String> getIncorrect_answers() {
		return incorrect_answers;
	}

	public void setIncorrect_answers(List<String> incorrect_answers) {
		this.incorrect_answers = incorrect_answers;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Question() {
		super();
	}

	public Question(Long qid, String category, String difficulty, String question, List<String> incorrect_answers,
			Answer answer) {
		super();
		Qid = qid;
		Category = category;
		Difficulty = difficulty;
		Question = question;
		this.incorrect_answers = incorrect_answers;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [Qid=" + Qid + ", Category=" + Category + ", Difficulty=" + Difficulty + ", Question="
				+ Question + ", incorrect_answers=" + incorrect_answers + ", answer=" + answer + "]";
	}

	
}
