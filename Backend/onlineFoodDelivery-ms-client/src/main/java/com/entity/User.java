package com.entity;

public class User {
	private int userId;
	private String email;
	private String userName;
	private String password;
	private String securityQuestion;
	private String answer;
	private String type;
	public User() {
		super();
	}
	public User(int userId, String email, String userName, String password, String securityQuestion,
			String answer, String type) {
		super();
		this.userId = userId;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + "userId=" + userId + ", userName=" + userName + ", password=" + password + ", securityQuestion="
				+ securityQuestion + ", answer=" + answer + ", type=" + type + "]";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
