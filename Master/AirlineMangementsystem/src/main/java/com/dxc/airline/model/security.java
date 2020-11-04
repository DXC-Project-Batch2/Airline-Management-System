package com.dxc.airline.model;

public class security {

	String username;
	String securityQuestion;
	String answer;
	
	public security() {
		super();
		// TODO Auto-generated constructor stub
	}

	public security(String username, String securityQuestion, String answer) {
		super();
		this.username = username;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "security [username=" + username + ", securityQuestion=" + securityQuestion + ", answer=" + answer + "]";
	}
}
