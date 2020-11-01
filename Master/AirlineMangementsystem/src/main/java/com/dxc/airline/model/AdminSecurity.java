package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.dxc.airline.exception.AdminSecurityException;

@Entity
@Component
public class AdminSecurity {
	
	@Id
	@NotNull(message = "Mandatory field")
	@Size(min = 3, max = 25)
	String username;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 6, max = 100)
	private String securityQuestion;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1, max = 30)
	private String answer;
	public AdminSecurity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminSecurity(String username, String securityQuestion, String answer) {
		super();
		this.username=validateUsername(username);
		this.securityQuestion = validateSecurityQuestion(securityQuestion);
		this.answer = validateAnswer(answer);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = validateUsername(username);
	}
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = validateSecurityQuestion(securityQuestion);
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = validateAnswer(answer);
	}
	@Override
	public String toString() {
		return "AdminSecurity [username=" + username + ",securityQuestion=" + securityQuestion + ", answer=" + answer + "]";
	}
	
	public String validateUsername(String username) {
		if (username == null) {
			throw new AdminSecurityException("Username cannot be blank");
		} else {
			if (!username.endsWith("dxc.com") && username.contains("@")) {
				throw new AdminSecurityException("Username should ends with @dxc.com");
			} else {
				if (username.length()-8 < 3) {
					throw new AdminSecurityException("Username is too short");
				} else if (username.length() > 25) {
					throw new AdminSecurityException("Username is too long");
				}
			}
		}
		return username;
	}

	public String validateSecurityQuestion(String securityQuestion) {
		if (securityQuestion == null) {
			throw new AdminSecurityException("securityQuestion cannot be blank");
		} else {
				if (securityQuestion.length() < 6) {
					throw new AdminSecurityException("securityQuestion is too short or Invalid");
				} else if (securityQuestion.length() > 100) {
					throw new AdminSecurityException("securityQuestion should not contain any complexity");
				}
			}
		return securityQuestion;
	}

	public String validateAnswer(String answer) {
		if (answer == null) {
			throw new AdminSecurityException("Answer cannot be blank");
		} else if (answer.length() > 30) {
					throw new AdminSecurityException("Answer should not be too much complexity because its to remember!!!");
				}
		return answer;
	}

}
