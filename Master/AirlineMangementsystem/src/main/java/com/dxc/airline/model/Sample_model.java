
package com.dxc.airline.model;

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
public class Sample_model {

	

	private long ticket_id;
	private String source;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	private Date date;
	private int no_of_passengers;
	private int flight_id;
	private int age;
	private String username;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String name;
	private String destination;
	
	private String gender;
	private String carrier_name;
	private String duration;
	private String starting_time;
	private String ending_time;

	public Sample_model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sample_model(long ticket_id, String source, Date date, int no_of_passengers, int flight_id, int age,
			String username, String name, String destination, String gender, String carrier_name, String duration,
			String starting_time, String ending_time) {
		super();
		this.ticket_id = ticket_id;
		this.source = source;
		this.date = date;
		this.no_of_passengers = no_of_passengers;
		this.flight_id = flight_id;
		this.age = age;
		this.username = username;
		this.name = name;
		this.destination = destination;
		this.gender = gender;
		this.carrier_name = carrier_name;
		this.duration = duration;
		this.starting_time = starting_time;
		this.ending_time = ending_time;
	}

	public long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(long ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNo_of_passengers() {
		return no_of_passengers;
	}

	public void setNo_of_passengers(int no_of_passengers) {
		this.no_of_passengers = no_of_passengers;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCarrier_name() {
		return carrier_name;
	}

	public void setCarrier_name(String carrier_name) {
		this.carrier_name = carrier_name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStarting_time() {
		return starting_time;
	}

	public void setStarting_time(String starting_time) {
		this.starting_time = starting_time;
	}

	public String getEnding_time() {
		return ending_time;
	}

	public void setEnding_time(String ending_time) {
		this.ending_time = ending_time;
	}

	
}
