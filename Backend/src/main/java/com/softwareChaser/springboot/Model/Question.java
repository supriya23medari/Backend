package com.softwareChaser.springboot.Model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Qid;
	
	@Column(name = "Subject")
	private String Subject;
	
	@Column(name = "Level")
	private String Level;
	
	@Column(name = "Qtitle")
	private String Qtitle;
	
	@Column(name = "Option_A")
	private String Option_A;
	
	@Column(name = "Option_B")
	private String Option_B;

	@Column(name = "Option_C")
	private String Option_C;
	
	@Column(name = "Option_D")
	private String Option_D;
	
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Answer answer;

	public Long getQid() {
		return Qid;
	}

	public void setQid(Long qid) {
		Qid = qid;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getLevel() {
		return Level;
	}

	public void setLevel(String level) {
		Level = level;
	}

	public String getQtitle() {
		return Qtitle;
	}

	public void setQtitle(String qtitle) {
		Qtitle = qtitle;
	}

	public String getOption_A() {
		return Option_A;
	}

	public void setOption_A(String option_A) {
		Option_A = option_A;
	}

	public String getOption_B() {
		return Option_B;
	}

	public void setOption_B(String option_B) {
		Option_B = option_B;
	}

	public String getOption_C() {
		return Option_C;
	}

	public void setOption_C(String option_C) {
		Option_C = option_C;
	}

	public String getOption_D() {
		return Option_D;
	}

	public void setOption_D(String option_D) {
		Option_D = option_D;
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

	public Question(Long qid, String subject, String level, String qtitle, String option_A, String option_B,
			String option_C, String option_D, String choose, Answer answer) {
		super();
		Qid = qid;
		Subject = subject;
		Level = level;
		Qtitle = qtitle;
		Option_A = option_A;
		Option_B = option_B;
		Option_C = option_C;
		Option_D = option_D;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [Qid=" + Qid + ", Subject=" + Subject + ", Level=" + Level + ", Qtitle=" + Qtitle
				+ ", Option_A=" + Option_A + ", Option_B=" + Option_B + ", Option_C=" + Option_C + ", Option_D="
				+ Option_D + ", answer=" + answer + "]";
	}

	
	

}
