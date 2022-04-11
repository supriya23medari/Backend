package com.softwareChaser.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwareChaser.springboot.Model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long>{

}
