package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class City {

	@Id
	
	String city;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(String city) {
		super();
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "City [city=" + city + "]";
	}
	
	
	
}
