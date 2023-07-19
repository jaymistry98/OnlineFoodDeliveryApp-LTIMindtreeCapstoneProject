package com.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(int userId) {
		super("Could not find the user with id " + userId);
	}

}