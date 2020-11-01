package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.dxc.airline.exception.UserSecurityException;

@Entity
@Component
public class UserSecurity {
	
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

	public UserSecurity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSecurity(String username,String securityQuestion, String answer) {
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
		return "UserSecurity [username=" + username + ",securityQuestion=" + securityQuestion + ", answer=" + answer + "]";
	}
	
	public String validateUsername(String username) {
		if (username == null) {
			throw new UserSecurityException("Username cannot be blank");
		} else {
			if (!username.endsWith("gmail.com") && !username.endsWith("yahoo.com") && username.contains("@")) {
				throw new UserSecurityException("Username should ends with @gmail.com or @yahoo.com");
			} else {
				if (username.length()-10 < 3) {
					throw new UserSecurityException("Username is too short");
				} else if (username.length() > 25) {
					throw new UserSecurityException("Username is too long");
				}
			}
		}
		return username;
	}

	public String validateSecurityQuestion(String securityQuestion) {
		if (securityQuestion == null) {
			throw new UserSecurityException("securityQuestion cannot be blank");
		} else {
				if (securityQuestion.length() < 6) {
					throw new UserSecurityException("securityQuestion is too short or Invalid");
				} else if (securityQuestion.length() > 100) {
					throw new UserSecurityException("securityQuestion should not contain any complexity");
				}
			}
		return securityQuestion;
	}

	public String validateAnswer(String answer) {
		if (answer == null) {
			throw new UserSecurityException("Answer cannot be blank");
		} else if (answer.length() > 30) {
					throw new UserSecurityException("Answer should not be too much complexity because its to remember!!!");
				}
		return answer;
	}

}
