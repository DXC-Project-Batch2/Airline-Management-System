package com.dxc.airline.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
public class AirLine {

	@Id
	int planeId; 
	
	@NotNull
	@Size(min=2,message="Name should have atleast 2 characters")
	String source;
	
	String destination;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	Date date;
	String duration;
	String starting_time;
	String ending_time;
	int prize;
	int avaliable_seats;
	int sold_out;
	
	public AirLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AirLine(int planeId, String source, String destination, String strdate, String duration, String starting_time,
			String ending_time, int prize, int avaliable_seats, int sold_out) throws ParseException {
		super();
		this.planeId = planeId;
		this.source = source;
		this.destination = destination;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		date=sdf.parse(strdate);
		this.duration = duration;
		this.starting_time = starting_time;
		this.ending_time = ending_time;
		this.prize = prize;
		this.avaliable_seats = avaliable_seats;
		this.sold_out = sold_out;
	}

	public int getPlaneId() {
		return planeId;
	}

	public void setPlaneId(int planeId) {
		this.planeId = planeId;
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

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public int getAvaliable_seats() {
		return avaliable_seats;
	}

	public void setAvaliable_seats(int avaliable_seats) {
		this.avaliable_seats = avaliable_seats;
	}

	public int getSold_out() {
		return sold_out;
	}

	public void setSold_out(int sold_out) {
		this.sold_out = sold_out;
	}

	@Override
	public String toString() {
		String strdate=new SimpleDateFormat("dd-MM-yyyy").format(date);
		return "AirLine [planeId=" + planeId + ", source=" + source + ", destination=" + destination + ", date=" + strdate
				+ ", duration=" + duration + ", starting_time=" + starting_time + ", ending_time=" + ending_time
				+ ", prize=" + prize + ", avaliable_seats=" + avaliable_seats + ", sold_out=" + sold_out + "]";
	}
	
	
}
