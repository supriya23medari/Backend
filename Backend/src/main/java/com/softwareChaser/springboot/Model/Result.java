package com.softwareChaser.springboot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
@Table(name="Result")
public class Result {
	
	public void setRid(Long rid) {
		Rid = rid;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}



	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Rid;
	
	@NotBlank(message="Add category name")
	@Column(name = "category")
	private String category;
	
	@NotBlank(message="Add difficulty ")
	@Column(name = "difficulty")
	private String difficulty;

	@NotBlank(message="Add difficulty percentage")
	@Column(name = "percentage")
	private String percentage;

	public Result(Long rid, @NotBlank(message = "Add category name") String category,
			@NotBlank(message = "Add difficulty ") String difficulty,
			@NotBlank(message = "Add difficulty percentage") String percentage) {
		super();
		Rid = rid;
		this.category = category;
		this.difficulty = difficulty;
		this.percentage = percentage;
	}



	public Result() {
		super();
	}
	
	
	
	

}
