package com.exception;

public class UserInfoInvalidException extends RuntimeException {
	public UserInfoInvalidException(String userName, String email, String securityQuestion, String answer) {
		super("User with username " + userName + ", email " + email + ", security question "
				+ securityQuestion + ", and answer " + answer + " does not exist");
	}

}
