package com.dxc.airline.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
public class TicketBooking {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long ticketId;
	
	private String username;
	private int flightId;
	
	@NotNull
	@Size(min = 3, max = 20,message = "Name of destination should have minimum 3 characters")
	private String source;
	
	@NotNull
	@Size(min = 3, max = 20,message = "Name of destination should have minimum 3 characters")
	private String destination;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	private Date date;
	private int noOfPassengers;
	
	public TicketBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TicketBooking(long ticketId,String username,int flightId, String source, String destination,String strdate, int noOfPassengers) throws ParseException {
		super();
		this.source = source;
		this.username = username;
		this.flightId = flightId;
		this.destination = destination;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		date=sdf.parse(strdate);
		this.noOfPassengers = noOfPassengers;
	}



	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public String toString() {
		return "TicketBooking [ticketId=" + ticketId + ", username=" + username + ", flightId=" + flightId + ", source="
				+ source + ", destination=" + destination + ", date=" + date + ", noOfPassengers=" + noOfPassengers
				+ "]";
	}

	
	
}
