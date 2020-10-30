package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Passenger {
	
	String username;
	String name;
	String gender;
	int age;
	@Id
	long govt_id;
	int flight_id;
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger(String username, String name, String gender, int age, long govt_id, int flight_id)  {
		super();
		this.username = username;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.govt_id = govt_id;
		this.flight_id = flight_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getGovt_id() {
		return govt_id;
	}
	public void setGovt_id(long govt_id) {
		this.govt_id = govt_id;
	}

	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	@Override
	public String toString() {
		return "Passenger [username=" + username + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", govt_id=" + govt_id + ", flight_id=" + flight_id + "]";
	}
	

	
}
