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

import com.dxc.airline.exception.AirlineException;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
public class AirLine {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int sno; 
	
	@NotNull(message = "Cannot be null")
	int planeId; 
	
	@NotNull(message = "Caannot be null")
	@Size(min=2,max = 40,message="Name should have atleast 2 characters")
	String carrierName;
	
	@NotNull(message = "Caannot be null")
	@Size(min=2,max = 30,message="Name should have atleast 2 characters")
	String source;
	

	@NotNull(message = "Cannot be null")
	@Size(min=2,max = 30,message="Name should have atleast 2 characters")
	String destination;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	Date date;
	
	@NotNull(message = "Cannot be null")
	String duration;
	
	@NotNull(message = "Cannot be null")
	String starting_time;
	
	@NotNull(message = "Cannot be null")
	String ending_time;
	
	@NotNull(message = "Cannot be null")
	int prize;
	
	@NotNull(message = "Cannot be null")
	int avaliable_seats;
	
	@NotNull(message = "Cannot be null")
	int sold_out;

	public AirLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AirLine(int sno,int planeId, String carrierName,
			@NotNull @Size(min = 2, message = "Name should have atleast 2 characters") String source,
			String destination, String strdate, String duration, String starting_time, String ending_time, int prize,
			int avaliable_seats, int sold_out) throws ParseException {
		super();
		this.planeId = validatePlaneId(planeId);
		this.carrierName = validateCarrierName(carrierName);
		this.source = validateSource(source);
		this.destination = validateDestination(destination);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		date=sdf.parse(strdate);
		this.duration = validateDuration(duration);
		this.starting_time = validateStarting_time(starting_time);
		this.ending_time = validateEnding_time(ending_time);
		this.prize = validatePrize(prize);
		this.avaliable_seats = validateAvaliable_seats(avaliable_seats);
		this.sold_out = validateSold_out(sold_out);
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	
	public int getPlaneId() {
		return planeId;
	}
	public void setPlaneId(int planeId) {
		this.planeId = validatePlaneId(planeId);
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = validateCarrierName(carrierName);
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = validateDuration(duration);
	}
	public String getStarting_time() {
		return starting_time;
	}
	public void setStarting_time(String starting_time) {
		this.starting_time = validateStarting_time(starting_time);
	}
	public String getEnding_time() {
		return ending_time;
	}
	public void setEnding_time(String ending_time) {
		this.ending_time = validateEnding_time(ending_time);
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = validatePrize(prize);
	}
	public int getAvaliable_seats() {
		return avaliable_seats;
	}
	public void setAvaliable_seats(int avaliable_seats) {
		this.avaliable_seats = validateAvaliable_seats(avaliable_seats);
	}
	public int getSold_out() {
		return sold_out;
	}
	public void setSold_out(int sold_out) {
		this.sold_out = validateSold_out(sold_out);
	}
	@Override
	public String toString() {
		return "AirLine [planeId=" + planeId + ", carrierName=" + carrierName + ", source=" + source + ", destination="
				+ destination + ", date=" + date + ", duration=" + duration + ", starting_time=" + starting_time
				+ ", ending_time=" + ending_time + ", prize=" + prize + ", avaliable_seats=" + avaliable_seats
				+ ", sold_out=" + sold_out + "]";
	}
	
	public int validatePlaneId(int planeId) {
		if (planeId == 0) {
			throw new AirlineException("planeId cannot be blank");
		} 
		return planeId;
	}
	
	public String validateCarrierName(String carrierName) {
		if (carrierName == null) {
			throw new AirlineException("carrierName cannot be blank");
		}else {
			if (carrierName.length() < 3) {
				throw new AirlineException("Invalid carrierName");
			}
		}
		return carrierName;
	}

	public String validateSource(String source) {
		if (source == null) {
			throw new AirlineException("source cannot be blank");
		} else {
			if (source.length() < 3) {
				throw new AirlineException("Invalid city");
			}
		}
		return source;
	}

	public String validateDestination(String destination) {
		if (destination == null) {
			throw new AirlineException("destination cannot be blank");
		} else if (destination.length() < 3) {
			throw new AirlineException("Invalid city");
		}
		return destination;
	}
	
	public String validateDuration(String duration) {
		if (duration == null) {
			throw new AirlineException("duration cannot be blank");
		}
		return duration;
	}

	public String validateStarting_time(String starting_time) {
		if (starting_time == null) {
			throw new AirlineException("starting_time cannot be blank");
		} 
		return starting_time;
	}
	public String validateEnding_time(String ending_time) {
		if (ending_time == null) {
			throw new AirlineException("ending_time cannot be blank");
		} 
		return ending_time;
	}
	
	public int validatePrize(int prize) {
		if (prize == 0) {
			throw new AirlineException("prize cannot be blank");
		}
		return prize;
	}

	public int validateAvaliable_seats(int avaliable_seats) {
		if (avaliable_seats == 0) {
			throw new AirlineException("avaliable_seats cannot be blank");
		} 
		return avaliable_seats;
	}

	public int validateSold_out(int sold_out) {
		if (sold_out < 0) {
			throw new AirlineException("sold_out cannot be blank");
		} 
		return sold_out;
	}
	
}
