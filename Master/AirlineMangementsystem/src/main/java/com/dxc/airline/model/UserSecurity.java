package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserSecurity {
	
	@Id
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =80)
	private String username;
	
	private String securityQuestion;
	
	@NotNull(message = "Minimum size of character is 10")
	@Size(min = 1,max =400)
	private String answer;
	public UserSecurity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSecurity(String username,String securityQuestion, String answer) {
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
		return "UserSecurity [username=" + username + ", securityQuestion=" + securityQuestion
				+ ", answer=" + answer + "]";
	}
	
	
	

}
