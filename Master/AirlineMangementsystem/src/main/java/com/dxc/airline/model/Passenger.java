package com.dxc.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import com.dxc.airline.exception.PassengerException;

@Entity
@Component
public class Passenger {
	
	private long ticket_id;
	String username;
	@NotNull(message = "Mandatory field")
	String name;
	@NotNull(message = "Mandatory field")
	String gender;
	@NotNull(message = "Mandatory field")
	int age;
	@NotNull(message = "Mandatory field")
	@Id
	long govt_id;
	@NotNull(message = "Mandatory field")
	int flight_id;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger(long ticketId,String username, String name, String gender, int age, long govt_id, int flight_id)  {
		super();
		this.ticket_id  = ticketId;
		this.username = validateUsername(username);
		this.name = validateName(name);
		this.gender = validateGender(gender);
		this.age = validateAge(age);
		this.govt_id = validategovt_id(govt_id);
		this.flight_id = validateFlightId(flight_id);
	}
	
	public long getTicketId() {
		return ticket_id;
	}
	public void setTicketId(long ticketId) {
		this.ticket_id = ticketId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = validateUsername(username);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = validateName(name);
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = validateGender(gender);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = validateAge(age);
	}
	public long getGovt_id() {
		return govt_id;
	}
	public void setGovt_id(long govt_id) {
		this.govt_id = validategovt_id(govt_id);
	}

	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = validateFlightId(flight_id);
	}
	@Override
	public String toString() {
		return "Passenger [username=" + username + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", govt_id=" + govt_id + ", flight_id=" + flight_id +", ticket_id ="+ticket_id +"]";
	}
	
	public String validateUsername(String username) {
		if (username == null) {
			throw new PassengerException("Username cannot be blank");
		} else {
			if (!username.endsWith("gmail.com") && !username.endsWith("yahoo.com") && username.contains("@")) {
				throw new PassengerException("Username should ends with @gmail.com or @yahoo.com");
			} else {
				if (username.length()-10 < 3) {
					throw new PassengerException("Username is too short");
				} else if (username.length() > 25) {
					throw new PassengerException("Username is too long");
				}
			}
		}
		return username;
	}

	public String validateName(String name) {
		if (name == null) {
			throw new PassengerException("name cannot be blank");
		} 
		return name;
	}

	public String validateGender(String gender) {
		if (gender == null) {
			throw new PassengerException("gender cannot be blank");
		} 
		return gender;
	}

	public long validategovt_id(long govt_id) {
		if (govt_id == 0) {
			throw new PassengerException("govt_id cannot be blank");
		}
		return govt_id;
	}

	public int validateAge(int age) {
		if (age == 0) {
			throw new PassengerException("age cannot be blank");
		}
		return age;
	}

	public int validateFlightId(int flight_id) {
		if (flight_id == 0) {
			throw new PassengerException("flightId cannot be blank");
		}
		return flight_id;
	}

}
