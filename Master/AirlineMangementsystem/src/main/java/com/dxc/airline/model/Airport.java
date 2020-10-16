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
	
	
	

}
