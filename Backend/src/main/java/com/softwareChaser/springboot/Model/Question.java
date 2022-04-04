package com.softwareChaser.springboot.Model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="Question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Qid;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "difficulty")
	private String difficulty;
	
	@Column(name = "question")
	private String Question;
	
	@ElementCollection
	@Column(name = "incorrect_answers")
	private List<String> incorrect_answers;
	
	@Column(name = "correct_answers")
	private String correct_answers;

	public Long getQid() {
		return Qid;
	}

	public void setQid(Long qid) {
		Qid = qid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
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

	public String getCorrect_answers() {
		return correct_answers;
	}

	public void setCorrect_answers(String correct_answers) {
		this.correct_answers = correct_answers;
	}

	public Question(Long qid, String category, String difficulty, String question, List<String> incorrect_answers,
			String correct_answers) {
		super();
		Qid = qid;
		this.category = category;
		this.difficulty = difficulty;
		Question = question;
		this.incorrect_answers = incorrect_answers;
		this.correct_answers = correct_answers;
	}

	public Question() {
		super();
	}

	@Override
	public String toString() {
		return "Question [Qid=" + Qid + ", Category=" + category + ", Difficulty=" + difficulty + ", Question="
				+ Question + ", incorrect_answers=" + incorrect_answers + ", correct_answers=" + correct_answers + "]";
	}
	
	
}
