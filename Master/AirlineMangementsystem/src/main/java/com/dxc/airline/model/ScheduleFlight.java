package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.scheduling.SchedulingException;
import org.springframework.stereotype.Component;

@Component
@Entity
public class ScheduleFlight {

	@NotNull	
	@Id
	private int flightId;
	
	@NotNull
	@Size(min = 3, max = 20,message = "Name of source should have minimum 3 characters")
	private String source;
	
	@NotNull
	@Size(min = 3, max = 20,message = "Name of destination should have minimum 3 characters")
	private String destination;
	
	@NotNull	
	private int seatingCapacity;
	
	@NotNull	
	private int amount;
	
	public ScheduleFlight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ScheduleFlight(int flightId,String source,String destination,int seatingCapacity, int amount) {
		super();
		this.flightId = validateFlightId(flightId);
		this.source = validateSource(source);
		this.destination = validateDestination(destination);
		this.seatingCapacity = validateSeatingCapacity(seatingCapacity);
		this.amount = validateAmount(amount);
	}


	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = validateFlightId(flightId);
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = validateSource(source);
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = validateDestination(destination);
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = validateSeatingCapacity(seatingCapacity);
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = validateAmount(amount);
	}

	@Override
	public String toString() {
		return "ScheduleFlight [flightId=" + flightId + ", source=" + source + ", destination=" + destination
				+ ", seatingCapacity=" + seatingCapacity + ", amount=" + amount + "]";
	}
	
	public int validateFlightId(int flightId) {
		if (flightId == 0) {
			throw new SchedulingException("flightId cannot be blank");
		}
		return flightId;
	}
	
	public String validateSource(String source) {
		if (source == null) {
			throw new SchedulingException("source cannot be blank");
		} else {
			if (source.length() < 3) {
				throw new SchedulingException("Invalid city");
			}
		}
		return source;
	}

	public String validateDestination(String destination) {
		if (destination == null) {
			throw new SchedulingException("destination cannot be blank");
		} else if (destination.length() < 3) {
			throw new SchedulingException("Invalid city");
		}
		return destination;
	}

	public int validateSeatingCapacity(int seatingCapacity) {
		if (seatingCapacity == 0) {
			throw new SchedulingException("seatingCapacity cannot be blank");
		}
		return seatingCapacity;
	}

	public int validateAmount(int amount) {
		if (amount == 0) {
			throw new SchedulingException("amount cannot be blank");
		} 
		return amount;
	}

}
