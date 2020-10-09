package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class AdminSecurity {
	
	@Id
	String username;
	private String securityQuestion;
	private String answer;
	public AdminSecurity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminSecurity(String username, String securityQuestion, String answer) {
		super();
		this.username=username;
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
		return "AdminSecurity [username=" + username + ",securityQuestion=" + securityQuestion + ", answer=" + answer + "]";
	}
	
	

}
