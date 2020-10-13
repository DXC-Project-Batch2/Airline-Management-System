package com.dxc.airline.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
public class TicketBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ticketId;
	private String from;
	private String to;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	private Date date;
	private int noOfPassengers;
	
	
	
	public TicketBooking(long ticketId, String strdate,String from, String to, Date date) throws ParseException {
		super();
		this.ticketId = ticketId;
		this.from = from;
		this.to = to;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		date=sdf.parse(strdate);
	}
	public TicketBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
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
	
	
	

}
