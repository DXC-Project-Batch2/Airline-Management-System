package com.dxc.airline.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AirLineDetalis {

	int planeId; 
	String carrierName;
	String source;
	String destination;
	Date date;
	int schedule_period;
	String duration;
	String starting_time;
	String ending_time;
	int prize;
	int avaliable_seats;
	int sold_out;

	public AirLineDetalis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AirLineDetalis(int planeId, String carrierName, String source, String destination, String strdate, int schedule_period,
			String duration, String starting_time, String ending_time, int prize, int avaliable_seats, int sold_out) throws ParseException {
		super();
		this.planeId = planeId;
		this.carrierName = carrierName;
		this.source = source;
		this.destination = destination;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		date=sdf.parse(strdate);
		this.schedule_period = schedule_period;
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

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
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

	public int getSchedule_period() {
		return schedule_period;
	}

	public void setSchedule_period(int schedule_period) {
		this.schedule_period = schedule_period;
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
		return "AirLineDetalis [planeId=" + planeId + ", carrierName=" + carrierName + ", source=" + source
				+ ", destination=" + destination + ", date=" + date + ", period=" + schedule_period + ", duration=" + duration
				+ ", starting_time=" + starting_time + ", ending_time=" + ending_time + ", prize=" + prize
				+ ", avaliable_seats=" + avaliable_seats + ", sold_out=" + sold_out + "]";
	}

}
