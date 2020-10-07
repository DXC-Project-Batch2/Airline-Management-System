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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String securityQuestion;
	private String answer;
	public AdminSecurity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminSecurity(long id, String securityQuestion, String answer) {
		super();
		this.id = id;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		return "AdminSecurity [id=" + id + ", securityQuestion=" + securityQuestion + ", answer=" + answer + "]";
	}
	
	

}
