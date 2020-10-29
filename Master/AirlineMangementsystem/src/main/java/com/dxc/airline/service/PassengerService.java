package com.dxc.airline.service;

import java.util.List;
import com.dxc.airline.model.Passenger;

public interface PassengerService {

	public List<Passenger> findAll();

	public Passenger save(Passenger thePassenger);
	
	public Passenger update(Passenger thePassenger);
	
	public Passenger findById(int id);

	public void deleteById(int id);
	
	
	public List<Passenger> findByUserName(String username);
	
	public List<Passenger> findByUser(String username, int flightId);
}
