package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.dxc.airline.exception.AdminException;

@Entity
@Component
public class Admin {

	@Id
	@NotNull(message = "Mandatory field")
	@Size(min = 3, max = 25)
	String username;

	@NotNull(message = "Mandatory field")
	@Size(min = 3, max = 20)
	String password;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub//
	}

	public Admin(String username, String password) {
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
		return "Admin [username=" + username + ", password=" + password + "]";
	}

	public String validateUsername(String username) {
		if (username == null) {
			throw new AdminException("Username cannot be blank");
		} else {
			if (!username.endsWith("dxc.com") && username.contains("@")) {
				throw new AdminException("Username should ends with @dxc.com");
			} else {
				if (username.length()-8 < 3) {
					throw new AdminException("Username is too short");
				} else if (username.length() > 25) {
					throw new AdminException("Username is too long");
				}
			}
		}
		return username;
	}

	public String ValidPassword(String password) {
		
		if (password == null) {
			throw new AdminException("Password cannot be blank");
		}

		if (password.length() > 20) {
			throw new AdminException("Password must be less than 20characters in length");
		}

		if (password.length() < 8) {
			throw new AdminException("Password must be more than 8 characters in length");
		}
		String upperCaseChars = "(.*[A-Z].*)";
		if (!password.matches(upperCaseChars)) {
			throw new AdminException("Password must have atleast one uppercase character");
		}
		String lowerCaseChars = "(.*[a-z].*)";
		if (!password.matches(lowerCaseChars)) {
			throw new AdminException("Password must have atleast one lowercase character");
		}
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			throw new AdminException("Password must have atleast one number");
		}
		String specialChars = "(.*[@,#,$,%].*$)";
		if (!password.matches(specialChars)) {
			throw new AdminException("Password must have atleast one special character among @#$%");
		}
		return password;
	}

}
