package com.exception;

public class UserExistsException extends RuntimeException {
	public UserExistsException(String userName) {
		super("User with name " + userName + " exists");
	}

}
