package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.dxc.airline.exception.AirportException;

@Component
@Entity
public class Airport {
	@Id
	@NotNull
	private String AirportCode;
	@NotNull
	private String AirportName;
	@NotNull
	private String AirportLocation;
	
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Airport(String airportCode, String airportName, String airportLocation) {
		super();
		AirportCode = validateAirportCode(airportCode);
		AirportName = validateAirportName(airportName);
		AirportLocation = validateAirportLocation(airportLocation);
	}

	public String getAirportCode() {
		return AirportCode;
	}
	public void setAirportCode(String airportCode) {
		AirportCode = validateAirportCode(airportCode);
	}
	public String getAirportName() {
		return AirportName;
	}
	public void setAirportName(String airportName) {
		AirportName = validateAirportName(airportName);
	}
	public String getAirportLocation() {
		return AirportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		AirportLocation = validateAirportLocation(airportLocation);
	}

	
	@Override
	public String toString() {
		return "Airport [AirportCode=" + AirportCode + ", AirportName=" + AirportName + ", AirportLocation="
				+ AirportLocation + "]";
	}

	public String validateAirportCode(String AirportCode) {
		if (AirportCode == null) {
			throw new AirportException("AirportCode cannot be blank");
		} 
		return AirportCode;
	}
	
	public String validateAirportName(String AirportName) {
		if (AirportName == null) {
			throw new AirportException("AirportName cannot be blank");
		}
		return AirportName;
	}

	public String validateAirportLocation(String AirportLocation) {
		if (AirportLocation == null) {
			throw new AirportException("AirportLocation cannot be blank");
		} 
		return AirportLocation;
	}
	
}
