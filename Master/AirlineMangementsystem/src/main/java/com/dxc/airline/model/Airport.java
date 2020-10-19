package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Airport {
	@Id
	private String AirportCode;
	private String AirportName;
	private String AirportLocation;
	
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Airport(String airportCode, String airportName, String airportLocation) {
		super();
		AirportCode = airportCode;
		AirportName = airportName;
		AirportLocation = airportLocation;
	}

	public String getAirportCode() {
		return AirportCode;
	}
	public void setAirportCode(String airportCode) {
		AirportCode = airportCode;
	}
	public String getAirportName() {
		return AirportName;
	}
	public void setAirportName(String airportName) {
		AirportName = airportName;
	}
	public String getAirportLocation() {
		return AirportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		AirportLocation = airportLocation;
	}

	@Override
	public String toString() {
		return "Airport [AirportCode=" + AirportCode + ", AirportName=" + AirportName + ", AirportLocation="
				+ AirportLocation + "]";
	}
	
}
