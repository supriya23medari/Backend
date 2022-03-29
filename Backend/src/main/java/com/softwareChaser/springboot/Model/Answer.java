package com.softwareChaser.springboot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Qid;
	
	
	private String ans;

	@OneToOne(mappedBy="answer")
	private Question question;

	public int getQid() {
		return Qid;
	}

	public void setQid(int qid) {
		Qid = qid;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	

	public Answer() {
		super();
	}

	public Answer(int qid, String ans, Question question) {
		super();
		Qid = qid;
		this.ans = ans;
		this.question = question;
	}
	
	

}
