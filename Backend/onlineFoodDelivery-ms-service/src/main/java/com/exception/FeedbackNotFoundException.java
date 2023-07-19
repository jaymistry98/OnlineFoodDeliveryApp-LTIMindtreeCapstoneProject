package com.exception;

public class FeedbackNotFoundException extends RuntimeException{
	public FeedbackNotFoundException(int id) {
		super("Could not find the feedback with id " + id);
	}

}
