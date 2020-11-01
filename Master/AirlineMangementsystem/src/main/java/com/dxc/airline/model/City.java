package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.dxc.airline.exception.CityException;

@Entity
@Component
public class City {

	@Id
	@NotNull(message = "Mandatory field")
	@Size(min = 3)
	String city;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(String city) {
		super();
		this.city = validateCity(city);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = validateCity(city);
	}

	@Override
	public String toString() {
		return "City [city=" + city + "]";
	}
	
	public String validateCity(String city) {
		if (city == null) {
			throw new CityException("city cannot be blank");
		} else if (city.length() < 3) {
					throw new CityException("Invalid city");
				}
		return city;
	}
	
	
}
