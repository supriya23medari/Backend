package com.softwareChaser.springboot.Error;

@SuppressWarnings("serial")
public class QuizAlreadyExistsException  extends RuntimeException {
    @SuppressWarnings("unused")
	private String message;
    public QuizAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    public QuizAlreadyExistsException() {
    }
}
