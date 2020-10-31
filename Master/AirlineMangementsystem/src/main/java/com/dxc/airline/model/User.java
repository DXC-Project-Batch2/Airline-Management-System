package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.dxc.airline.exception.UserException;

@Entity
@Component
public class User {
	
	@Id
	@NotNull(message = "Mandatory field")
	@Size(min = 3, max = 25)
	String username;

	@NotNull(message = "Mandatory field")
	@Size(min = 3, max = 20)
	String password;

	
	
	public User() {
		super();
		
	}
	
	public User(String username, String password) {
		super();
		this.username = validateUsername(username);
		this.password = ValidPassword(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = validateUsername(username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = ValidPassword(password);
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	public String validateUsername(String username) {
		if (username == null) {
			throw new UserException("Username cannot be blank");
		} else {
			if (!username.endsWith("gmail.com") && !username.endsWith("yahoo.com") && username.contains("@")) {
				throw new UserException("Username should ends with @gmail.com or @yahoo.com");
			} else {
				if (username.length()-10 < 3) {
					throw new UserException("Username is too short");
				} else if (username.length() > 25) {
					throw new UserException("Username is too long");
				}
			}
		}
		return username;
	}

	public String ValidPassword(String password) {
		
		if (password == null) {
			throw new UserException("Password cannot be blank");
		}

		if (password.length() > 20) {
			throw new UserException("Password must be less than 20characters in length");
		}

		if (password.length() < 8) {
			throw new UserException("Password must be more than 8 characters in length");
		}
		String upperCaseChars = "(.*[A-Z].*)";
		if (!password.matches(upperCaseChars)) {
			throw new UserException("Password must have atleast one uppercase character");
		}
		String lowerCaseChars = "(.*[a-z].*)";
		if (!password.matches(lowerCaseChars)) {
			throw new UserException("Password must have atleast one lowercase character");
		}
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			throw new UserException("Password must have atleast one number");
		}
		String specialChars = "(.*[@,#,$,%].*$)";
		if (!password.matches(specialChars)) {
			throw new UserException("Password must have atleast one special character among @#$%");
		}
		return password;
	}

}
