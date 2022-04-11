package com.softwareChaser.springboot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "Answer")
public class Answer {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Aid;
	
	@Column(name = "correct_answers")
	private String correct_answers;

	@JsonBackReference
	@OneToOne(mappedBy="answer")
	private Question question;

	public int getAid() {
		return Aid;
	}

	public void setAid(int aid) {
		Aid = aid;
	}

	public String getCorrect_answers() {
		return correct_answers;
	}

	public void setCorrect_answers(String correct_answers) {
		this.correct_answers = correct_answers;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer(int aid, String correct_answers, Question question) {
		super();
		Aid = aid;
		this.correct_answers = correct_answers;
		this.question = question;
	}

	public Answer() {
		super();
	}

	@Override
	public String toString() {
		return "Answer [Aid=" + Aid + ", correct_answers=" + correct_answers + ", question=" + question + "]";
	}

	
}
