package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.Airport;

@Service
public interface IAirportService {
	
	public Airport add(Airport airport);
	
	public Airport update(Airport airport);
	
	public List<Airport> findAll();
	
	//public Airport findByAirportCode(String airportcode);
	
	public Airport findBycode(String airportcode);
	
	public void delete(String airportcode);

}
