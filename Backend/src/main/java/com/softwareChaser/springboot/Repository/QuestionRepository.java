package com.softwareChaser.springboot.Repository;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwareChaser.springboot.Model.Question;

import ch.qos.logback.classic.Level;



@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
	

	public List<Question> findBySubjectAndLevel(Subject subject, Level level);
}
