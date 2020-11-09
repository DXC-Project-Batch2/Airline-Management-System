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

import com.dxc.airline.exception.TicketBookingException;
import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
public class TicketBooking {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long ticketId;
	
	@NotNull(message = "Mandatory field")
	@Size(min = 3, max = 25)
	private String username;
	
	@NotNull
	private long flightId;
	
	@NotNull
	@Size(min = 3, max = 20,message = "Name of destination should have minimum 3 characters")
	private String source;
	
	@NotNull
	@Size(min = 3, max = 20,message = "Name of destination should have minimum 3 characters")
	private String destination;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	private Date date;
	
	@NotNull(message = "Mandatory field")
	private int noOfPassengers;
	
	public TicketBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TicketBooking(long ticketId,String username,long flightId, String source, String destination,String strdate, int noOfPassengers) throws ParseException {
		super();
		this.source = validateSource(source);
		this.username = validateUsername(username);
		this.flightId = validateFlightId(flightId);
		this.destination = validateDestination(destination);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		date=sdf.parse(strdate);
		this.noOfPassengers = validateNoOfPassengers(noOfPassengers);
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
		this.username = validateUsername(username);
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
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
		this.noOfPassengers = validateNoOfPassengers(noOfPassengers);	
	}

	@Override
	public String toString() {
		return "TicketBooking [ticketId=" + ticketId + ", username=" + username + ", flightId=" + flightId + ", source="
				+ source + ", destination=" + destination + ", date=" + date + ", noOfPassengers=" + noOfPassengers
				+ "]";
	}

	public long validateFlightId(long flightId2) {
		if (flightId2 == 0) {
			throw new TicketBookingException("flightId cannot be blank");
		} else {
				if (flightId2 > 10111) {
					throw new TicketBookingException("flightId not found");
			}
		}
		return flightId2;
	}
	
	public String validateSource(String source) {
		if (source == null) {
			throw new TicketBookingException("source cannot be blank");
		} else {
			if (source.length() < 3) {
				throw new TicketBookingException("Invalid city");
			}
		}
		return source;
	}

	public String validateDestination(String destination) {
		if (destination == null) {
			throw new TicketBookingException("destination cannot be blank");
		} else if (destination.length() < 3) {
			throw new TicketBookingException("Invalid city");
		}
		return destination;
	}
	
	public int validateNoOfPassengers(int noOfPassengers) {
		if (noOfPassengers == 0) {
			throw new TicketBookingException("number Of Ticket a Passenger can book per flight 1-5");
		} else {
				if (noOfPassengers > 5) {
					throw new TicketBookingException("number Of Ticket a Passenger can book per flight 1-5");
			}
		}
		return noOfPassengers;
	}
	public String validateUsername(String username) {
		if (username == null) {
			throw new TicketBookingException("Username cannot be blank");
		} else {
			if (!username.endsWith("gmail.com") && !username.endsWith("yahoo.com") && username.contains("@")) {
				throw new TicketBookingException("Username should ends with @gmail.com or @yahoo.com");
			} else {
				if (username.length()-10 < 3) {
					throw new TicketBookingException("Username is too short");
				} else if (username.length() > 25) {
					throw new TicketBookingException("Username is too long");
				}
			}
		}
		return username;
	}
	
}
