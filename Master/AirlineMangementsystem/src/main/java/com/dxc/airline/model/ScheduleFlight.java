package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
public class ScheduleFlight {
	@Id
	private int flightId;
	
	
	@NotNull
	@Size(min = 3, max = 20,message = "Name of source should have minimum 3 characters")
	private String source;
	
	@NotNull
	@Size(min = 3, max = 20,message = "Name of destination should have minimum 3 characters")
	private String destination;
	
	private int seatingCapacity;
	
	private int amount;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
