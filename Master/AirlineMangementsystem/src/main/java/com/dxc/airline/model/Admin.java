package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Admin {
	
	@Id
	@NotNull(message = "Mandatory field")
	@Size(min = 1,max =100)
	String username;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 1)
	String password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub//
	}

	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
	

}
